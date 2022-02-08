package tgeindre.Synthesizer;

import tgeindre.Synthesizer.Gui.Input.Arranger;
import tgeindre.Synthesizer.Input.BaseArranger;
import tgeindre.Synthesizer.Input.Song.Insomnia;

import javax.swing.*;

public class Main
{
    public static void main(String[] args) {
        Arranger arranger = new Arranger(new BaseArranger());
        arranger.loadSong(new Insomnia());
        tgeindre.Synthesizer.Gui.View.Main.initLookAndFeel();
        SwingUtilities.invokeLater(() -> new tgeindre.Synthesizer.Gui.View.Main(arranger));
    }
}
