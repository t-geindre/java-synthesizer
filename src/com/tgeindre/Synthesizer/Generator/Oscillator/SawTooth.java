package com.tgeindre.Synthesizer.Generator.Oscillator;

import com.tgeindre.Synthesizer.Generator.Oscillator.Frequency.Frequency;

public class SawTooth implements Oscillator
{
    private Frequency freq;
    private double amplitude;
    private double phase;

    public SawTooth(Frequency freq, double amplitude, double phase)
    {
        this.freq = freq;
        this.amplitude = amplitude;
        this.phase = phase;
    }

    public SawTooth(double freq, double amplitude, double phase)
    {
        this(new Frequency(freq), amplitude, phase);
    }

    @Override
    public double getValue(double deltaTime)
    {
        double freq = this.freq.getFrequency(deltaTime);

        return ((2 / Math.PI) * (freq * Math.PI * ((deltaTime + phase) % (1 / freq))) - Math.PI / 2) * amplitude;
    }
}
