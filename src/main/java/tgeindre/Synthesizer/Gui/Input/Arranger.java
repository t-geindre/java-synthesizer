package tgeindre.Synthesizer.Gui.Input;

import tgeindre.Synthesizer.Gui.Event.Dispatcher;
import tgeindre.Synthesizer.Gui.Event.Emitter;
import tgeindre.Synthesizer.Input.Track.Track;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Arranger extends tgeindre.Synthesizer.Input.Arranger implements Emitter
{
    tgeindre.Synthesizer.Gui.View.Component.Arranger view;
    Dispatcher eventDispatcher;

    public Arranger()
    {
        view = new tgeindre.Synthesizer.Gui.View.Component.Arranger();
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
                    Arranger.super.play();
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

    @Override
    public void addTrack(Track track)
    {
        view.addTrack(track);
        super.addTrack(track);
    }

    public JComponent getView()
    {
        return view;
    }

    @Override
    public void addActionListener(ActionListener l)
    {
        eventDispatcher.addActionListener(l);
    }
}
