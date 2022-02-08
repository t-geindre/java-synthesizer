package tgeindre.Synthesizer.Gui.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Dispatcher implements Emitter
{
    ArrayList<ActionListener> listeners;

    public Dispatcher()
    {
        listeners = new ArrayList<>();
    }

    public void dispatch(Object source, String command)
    {
        ActionEvent event = new ActionEvent(source, 0, command);
        for (ActionListener listener: listeners) {
            listener.actionPerformed(event);
        }
    }

    @Override
    public void addActionListener(ActionListener l)
    {
        listeners.add(l);
    }
}
