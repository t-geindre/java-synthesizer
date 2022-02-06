package tgeindre.Synthesizer.Dsp.Ouput;

import tgeindre.Synthesizer.Dsp.Time.Clock;

import javax.sound.sampled.*;
import java.nio.ByteBuffer;

public class System implements Output
{
    private int sampleRate;
    private int sampleSize = 2;
    private SourceDataLine line;
    private ByteBuffer buffer;
    private Clock clock;
    int volume = 1000; // 0-1000

    public System() throws LineUnavailableException
    {
        this(44100);
    }

    public System(int sampleRate) throws LineUnavailableException
    {
        this.sampleRate = sampleRate;
        initialize();
    }

    @Override
    public void addSample(double sample)
    {
        clock.tick();

        buffer.clear();
        buffer.putShort(getShortSample(sample));
        line.write(buffer.array(), 0, buffer.position());

        while (line.available() == 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {};
        }
    }

    private short getShortSample(double sample)
    {
        sample = sample * Short.MAX_VALUE * ((double)volume / 20000);
        sample = sample > Short.MAX_VALUE ? Short.MAX_VALUE : sample;
        sample = sample < -Short.MAX_VALUE ? -Short.MAX_VALUE : sample;

        return (short) sample;
    }

    @Override
    public Clock getClock()
    {
        return clock;
    }

    private void initialize() throws LineUnavailableException
    {
        clock = new Clock(1000000 / sampleRate);

        AudioFormat format = new AudioFormat(sampleRate, sampleSize * 8, 1, true, true);
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        if (!AudioSystem.isLineSupported(info)){
            throw new LineUnavailableException(info.toString());
        }

        line = (SourceDataLine) AudioSystem.getLine(info);
        line.open(format);
        line.start();

        buffer = ByteBuffer.allocate(line.getBufferSize());
    }

    @Override
    public void close()
    {
        line.drain();
        line.close();
    }
}
