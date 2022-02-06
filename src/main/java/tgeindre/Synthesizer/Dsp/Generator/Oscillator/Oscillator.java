package tgeindre.Synthesizer.Dsp.Generator.Oscillator;

import tgeindre.Synthesizer.Dsp.Generator.Generator;
import tgeindre.Synthesizer.Dsp.Generator.Oscillator.Frequency.Frequency;

public interface Oscillator extends Generator
{
    Oscillator clone();

    Frequency getFrequency();
    void setFrequency(Frequency freq);
    void setFrequency(double freq);

    void setPhase(double phase);
    double getPhase();
}
