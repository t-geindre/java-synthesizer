package tgeindre.Synthesizer.Gui.Component;

import tgeindre.Synthesizer.Input.Arranger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Player extends JPanel implements ActionListener
{
    JButton play;
    JButton stop;
    private Arranger arranger;

    public Player(Arranger arranger)
    {
        super();
        this.arranger = arranger;

        play = new JButton("Play");
        play.addActionListener(this);
        add(play);

        stop = new JButton("stop");
        stop.addActionListener(this);
        add(stop);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent)
    {
        if (actionEvent.getSource() == play) {
            SwingWorker<Integer, Void> sw = new SwingWorker<>() {

                @Override
                protected Integer doInBackground() throws Exception
                {
                    arranger.play();

                    return 0;
                }
            };

            sw.execute();
        }

        if (actionEvent.getSource() == stop) {
            arranger.stop();
        }
    }
}
