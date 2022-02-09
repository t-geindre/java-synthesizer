package tgeindre.Synthesizer.Gui.View.Component.Track;

import tgeindre.Synthesizer.Input.Track.Track;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Control extends JPanel implements ActionListener
{
    Track track;

    public Control(Track track)
    {
        setBackground(new Color(0, 255, 0));
        this.track = track;

        add(new JLabel(track.getName()));
        add(new JSlider());

        System.out.println(track.getName());
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {

    }
}
