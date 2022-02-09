package tgeindre.Synthesizer.Gui.View;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import tgeindre.Synthesizer.Gui.View.Component.Player;
import tgeindre.Synthesizer.Gui.Input.Arranger;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame
{
    JPanel panel;
    Player player;
    Arranger arranger;

    public Main(Arranger arranger)
    {
        super("JaSynth");
        this.arranger = arranger;

        panel = new JPanel(new GridBagLayout());
        GridBagConstraints panelConstraint = new GridBagConstraints();
        setContentPane(panel);

        panelConstraint.fill = GridBagConstraints.HORIZONTAL;
        panelConstraint.gridx = 0;
        panelConstraint.gridy = 0;
        panelConstraint.weightx = 1;
        player = new Player(arranger);
        panel.add(player, panelConstraint);

        panelConstraint.fill = GridBagConstraints.BOTH;
        panelConstraint.gridy = 1;
        panelConstraint.weighty = 1;
        panel.add(arranger.getView(), panelConstraint);


        setSize(1200, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void initLookAndFeel()
    {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }

        IconFontSwing.register(FontAwesome.getIconFont());
    }
}
