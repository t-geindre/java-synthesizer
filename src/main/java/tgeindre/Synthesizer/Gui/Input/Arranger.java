package tgeindre.Synthesizer.Gui.Input;

import tgeindre.Synthesizer.Dsp.Ouput.Output;
import tgeindre.Synthesizer.Gui.Event.Dispatcher;
import tgeindre.Synthesizer.Gui.Event.Emitter;
import tgeindre.Synthesizer.Input.Song.Song;
import tgeindre.Synthesizer.Input.Track.Track;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Arranger implements tgeindre.Synthesizer.Input.Arranger, Emitter
{
    tgeindre.Synthesizer.Input.Arranger arranger;
    Dispatcher eventDispatcher;

    public Arranger(tgeindre.Synthesizer.Input.Arranger arranger)
    {
        this.arranger = arranger;
        eventDispatcher = new Dispatcher();
    }

    public void play()
    {
        eventDispatcher.dispatch(this, "play");

        SwingWorker<Integer, Void> sw = new SwingWorker<>() {
            @Override
            protected Integer doInBackground() throws Exception
            {
                try {
                    arranger.play();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                return 0;
            }

            @Override
            protected void done()
            {
                eventDispatcher.dispatch(Arranger.this, "stop");
            }
        };
        sw.execute();
    }

    public void addActionListener(ActionListener l)
    {
        eventDispatcher.addActionListener(l);
    }

    @Override
    public void stop()
    {
        arranger.stop();
    }

    @Override
    public void close()
    {
        arranger.close();
    }

    @Override
    public void loadSong(Song song)
    {
        arranger.loadSong(song);
    }

    @Override
    public void addTrack(Track track)
    {
        arranger.addTrack(track);
    }

    @Override
    public void reset()
    {
        arranger.reset();
    }
}
