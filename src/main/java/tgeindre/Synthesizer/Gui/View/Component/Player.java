package tgeindre.Synthesizer.Gui.View.Component;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;

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

    boolean isPlaying;

    tgeindre.Synthesizer.Gui.Input.Arranger arranger;

    public Player(tgeindre.Synthesizer.Gui.Input.Arranger arranger)
    {
        super();

        isPlaying = false;

        this.arranger = arranger;
        this.arranger.addActionListener(this);

        setBackground(new Color(60, 63, 65));
        setBorder(BorderFactory.createMatteBorder(1, 0, 1, 0, new Color(38, 38, 38)));

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
            if (!isPlaying) {
                arranger.play();
                return;
            }
            arranger.stop(false);
        }

        if (actionEvent.getSource() == buttonStop) {
            arranger.stop(true);
            return;
        }

        if (actionEvent.getSource() == arranger) {
            if (Objects.equals(actionEvent.getActionCommand(), "play")) {
                buttonPlay.setIcon(iconPause);
                isPlaying = true;
                return;
            }
            if (Objects.equals(actionEvent.getActionCommand(), "stop")) {
                buttonPlay.setIcon(iconPlay);
                isPlaying = false;
            }
        }
    }
}
