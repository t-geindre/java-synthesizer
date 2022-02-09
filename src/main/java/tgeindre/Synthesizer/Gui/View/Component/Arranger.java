package tgeindre.Synthesizer.Gui.View.Component;

import tgeindre.Synthesizer.Gui.View.Component.Track.Control;
import tgeindre.Synthesizer.Input.Track.Track;

import javax.swing.*;
import java.awt.*;

public class Arranger extends JPanel
{
    JPanel trackControlPanel;
    JPanel trackContentPanel;

    public Arranger()
    {
        super(new GridBagLayout());
        setBackground(new Color(43, 43, 43));

        GridBagConstraints panelConstraint = new GridBagConstraints();
        panelConstraint.fill = GridBagConstraints.BOTH;
        panelConstraint.weighty = 1;

        panelConstraint.gridx = 0;
        panelConstraint.weightx = .20;
        trackControlPanel = new JPanel(new GridBagLayout());
        trackControlPanel.setBackground(new Color(60, 63, 65));
        trackControlPanel.setBorder(
            BorderFactory.createMatteBorder(0, 1, 0, 1, new Color(38, 38, 38))
        );
        add(trackControlPanel, panelConstraint);

        panelConstraint.gridx = 1;
        panelConstraint.weightx = .80;
        trackContentPanel = new JPanel(new GridBagLayout());
        trackControlPanel.setMaximumSize(new Dimension(100, 0));
        trackContentPanel.setBackground(new Color(43, 43, 43));
        add(trackContentPanel, panelConstraint);
    }

    public void addTrack(Track track)
    {
        GridBagConstraints panelConstraint = new GridBagConstraints();
        panelConstraint.fill = GridBagConstraints.HORIZONTAL;
        panelConstraint.gridwidth = 1;
        panelConstraint.gridy = 0;
        panelConstraint.weighty = 1;
        panelConstraint.weightx = 1;
        panelConstraint.anchor = GridBagConstraints.PAGE_START;

        trackControlPanel.add(new Control(track), panelConstraint);
    }
}
