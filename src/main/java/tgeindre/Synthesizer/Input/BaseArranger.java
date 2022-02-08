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
import tgeindre.Synthesizer.Input.Song.Song;
import tgeindre.Synthesizer.Input.Track.Track;

import javax.sound.sampled.LineUnavailableException;
import java.util.ArrayList;

public class BaseArranger implements Arranger
{
    Clock clock;
    Output output;
    boolean isStopRequested = false;
    boolean isPlaying = false;
    ArrayList<Track> tracks;

    public BaseArranger()
    {
        try {
            output = new System();
        } catch (LineUnavailableException e) {
            java.lang.System.out.println("Audio initialization failed " + e.getMessage());
            java.lang.System.exit(1);
        }

        clock = output.getClock();
        tracks = new ArrayList<>();
    }

    @Override
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

    @Override
    public void loadSong(Song song)
    {
        tracks.clear();
        for (Track track: song.getTracks()) {
            addTrack(track);
        }
    }

    @Override
    public void addTrack(Track track)
    {
        tracks.add(track);
    }

    @Override
    public void stop()
    {
        isStopRequested = true;
    }

    @Override
    public void close()
    {
        output.close();
    }
}
