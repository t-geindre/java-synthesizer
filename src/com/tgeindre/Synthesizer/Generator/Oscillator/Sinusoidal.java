package com.tgeindre.Synthesizer.Generator.Oscillator;

import com.tgeindre.Synthesizer.Generator.Oscillator.Frequency.Frequency;

public class Sinusoidal implements Oscillator
{
    private Frequency freq;
    private double amplitude;
    private double phase;

    public Sinusoidal(Frequency freq, double amplitude, double phase)
    {
        this.freq = freq;
        this.amplitude = amplitude;
        this.phase = phase;
    }

    public Sinusoidal(double freq, double amplitude, double phase)
    {
        this(new Frequency(freq), amplitude, phase);
    }

    @Override
    public double getValue(double deltaTime)
    {
        return Math.sin(2 * Math.PI * freq.getFrequency(deltaTime) * (deltaTime + phase)) * amplitude;
    }
}
