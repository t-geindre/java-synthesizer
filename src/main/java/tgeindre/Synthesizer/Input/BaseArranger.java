package tgeindre.Synthesizer.Input;

import tgeindre.Synthesizer.Dsp.Generator.Stack;
import tgeindre.Synthesizer.Dsp.Ouput.Output;
import tgeindre.Synthesizer.Dsp.Ouput.System;
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

        Stack stack = new Stack();
        for (Track track: tracks) {
            track.play();
            stack.add(track);
        }

        while (!stack.isOver()) {
            stack.clearOver();
            output.addSample(stack.getValue(clock.getTickDuration()));
        }

        if (isStopRequested) {
            reset();
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
        if (!isPlaying) {
            reset();
            return;
        }

        isStopRequested = true;
        for (Track track: tracks) {
            track.stop();
        }
    }

    @Override
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
