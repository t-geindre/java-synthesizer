package tgeindre.Synthesizer.Gui.Component;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import tgeindre.Synthesizer.Gui.Input.Arranger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Player extends JPanel implements ActionListener
{
    Icon iconPlay;
    Icon iconPause;
    Icon iconStop;

    JButton buttonPlay;
    JButton buttonStop;

    private Arranger arranger;

    public Player(Arranger arranger)
    {
        super();

        this.arranger = arranger;
        this.arranger.addActionListener(this);

        iconPlay = IconFontSwing.buildIcon(FontAwesome.PLAY, 18, new Color(73, 155, 84));
        iconPause = IconFontSwing.buildIcon(FontAwesome.PAUSE, 18, new Color(73, 155, 84));
        iconStop = IconFontSwing.buildIcon(FontAwesome.STOP, 18, new Color(53, 145, 195));

        buttonPlay = new JButton(iconPlay);
        buttonPlay.addActionListener(this);
        buttonPlay.setBorderPainted(false);
        add(buttonPlay);

        buttonStop = new JButton(iconStop);
        buttonStop.addActionListener(this);
        buttonStop.setBorderPainted(false);
        add(buttonStop);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if (actionEvent.getSource() == buttonPlay) {
            arranger.play();
        }

        if (actionEvent.getSource() == buttonStop) {
            arranger.stop();
        }

        if (actionEvent.getSource() == arranger) {
            if (Objects.equals(actionEvent.getActionCommand(), "play")) {
                buttonPlay.setIcon(iconPause);
            }
            if (Objects.equals(actionEvent.getActionCommand(), "stop")) {
                buttonPlay.setIcon(iconPlay);
            }
        }
    }
}
