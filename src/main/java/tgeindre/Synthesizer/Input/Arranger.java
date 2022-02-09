package tgeindre.Synthesizer.Input;

import tgeindre.Synthesizer.Dsp.Generator.Stack;
import tgeindre.Synthesizer.Dsp.Ouput.Output;
import tgeindre.Synthesizer.Dsp.Ouput.System;
import tgeindre.Synthesizer.Dsp.Time.Clock;
import tgeindre.Synthesizer.Input.Song.Song;
import tgeindre.Synthesizer.Input.Track.Track;

import javax.sound.sampled.LineUnavailableException;
import java.util.ArrayList;

public class Arranger
{
    Clock clock;
    Output output;
    boolean isResetRequested = false;
    boolean isPlaying = false;
    ArrayList<Track> tracks;

    public Arranger()
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

    public void play()
    {
        if (isPlaying) {
            return;
        }

        isPlaying = true;

        Stack stack = new Stack();
        for (Track track: tracks) {
            track.play();
            stack.add(track);
        }

        while (!stack.isOver()) {
            stack.clearOver();
            output.addSample(stack.getValue(clock.getTickDuration()));
        }

        if (isResetRequested) {
            reset();
        }

        isPlaying = false;
    }

    public void loadSong(Song song)
    {
        tracks.clear();
        for (Track track: song.getTracks()) {
            addTrack(track);
        }
    }

    public void addTrack(Track track)
    {
        tracks.add(track);
    }

    public void stop(boolean reset)
    {
        if (!isPlaying) {
            reset();
            return;
        }

        isResetRequested = reset;

        for (Track track: tracks) {
            track.stop();
        }
    }

    public void close()
    {
        output.close();
    }

    public void reset()
    {
        for (Track track : tracks) {
            track.reset();
        }
    }
}
