package tgeindre.Synthesizer.Input;

import tgeindre.Synthesizer.Dsp.Generator.Instrument.AllKeys;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Instrument;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Preset.Default;
import tgeindre.Synthesizer.Dsp.Generator.Stack;
import tgeindre.Synthesizer.Input.Producer.Clip.Clip;
import tgeindre.Synthesizer.Input.Producer.Message;
import tgeindre.Synthesizer.Dsp.Ouput.Output;
import tgeindre.Synthesizer.Dsp.Ouput.System;
import tgeindre.Synthesizer.Input.Song.Clip.Insomnia.MainMelody;
import tgeindre.Synthesizer.Dsp.Time.Clock;

import javax.sound.sampled.LineUnavailableException;

public class Arranger
{
    Clock clock;
    Output output;
    boolean isStopRequested = false;
    boolean isPlaying = false;

    public Arranger()
    {
        try {
            output = new System();
        } catch (LineUnavailableException e) {
            java.lang.System.out.println("Audio initialization failed " + e.getMessage());
            java.lang.System.exit(1);
        }

        clock = output.getClock();
    }

    public void play()
    {
        if (isPlaying) {
            return;
        }

        isStopRequested = false;
        isPlaying = true;

        clock.reset();

        Instrument inst = new AllKeys(new Default());

        Stack stack = new Stack();
        stack.add(inst);

        Clip clip = new MainMelody();

        double lastSample = 0;

        while (!isStopRequested && (!clip.isOver() || !inst.isOver() || lastSample != 0)) {
            for (Message message : clip.pullMessages(clock.getTime())) {
                if (message.isOn()) {
                    inst.noteOn(message.getNote(), 1);
                } else {
                    inst.noteOff(message.getNote());
                }
            }

            lastSample = stack.getValue(clock.getTickDuration());
            output.addSample(lastSample);
        }

        isPlaying = false;
    }

    public void stop()
    {
        isStopRequested = true;
    }

    public Output getOutput()
    {
        return output;
    }

    public void close()
    {
        output.close();
    }
}
