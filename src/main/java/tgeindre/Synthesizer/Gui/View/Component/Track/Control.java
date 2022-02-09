package tgeindre.Synthesizer.Gui.View.Component.Track;

import tgeindre.Synthesizer.Input.Track.Track;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control extends JPanel implements ChangeListener
{
    Track track;
    JSlider gain;

    public Control(Track track)
    {
        setBackground(new Color(0, 255, 0));
        this.track = track;

        add(new JLabel(track.getName()));
        gain = new JSlider();
        gain.setMinimum(0);
        gain.setMaximum(100);
        gain.setValue((int) (track.getAmplitude() * 100.0));
        gain.addChangeListener(this);
        add(gain);
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        track.setAmplitude(gain.getValue() / 100.0);
    }
}
