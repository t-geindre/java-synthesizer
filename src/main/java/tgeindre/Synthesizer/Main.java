package tgeindre.Synthesizer;

import tgeindre.Synthesizer.Input.Arranger;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) {
        Arranger arranger = new Arranger();
        tgeindre.Synthesizer.Gui.View.Main.initLookAndFeel();
        SwingUtilities.invokeLater(() -> new tgeindre.Synthesizer.Gui.View.Main(arranger));
    }
}
