package tgeindre.Synthesizer.Gui.View;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import tgeindre.Synthesizer.Gui.Component.Player;
import tgeindre.Synthesizer.Gui.Input.Arranger;

import javax.swing.*;

public class Main extends JFrame
{
    JPanel panel;
    Player player;
    private Arranger arranger;

    public Main(Arranger arranger)
    {
        super("JaSynth");
        this.arranger = arranger;
        panel = new JPanel();
        setContentPane(panel);
        player = new Player(arranger);
        panel.add(player);
        setLocationRelativeTo(null);
        setSize(600, 600);
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
