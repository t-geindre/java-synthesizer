package com.tgeindre.Synthesizer.Generator.Oscillator;

import com.tgeindre.Synthesizer.Generator.Generator;
import com.tgeindre.Synthesizer.Generator.Oscillator.Frequency.Frequency;

public interface Oscillator extends Generator
{
    Oscillator clone();

    Frequency getFrequency();
    void setFrequency(Frequency freq);
    void setFrequency(double freq);

    void setPhase(double phase);
    double getPhase();
}
