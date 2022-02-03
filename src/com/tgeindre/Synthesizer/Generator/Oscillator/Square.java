package com.tgeindre.Synthesizer.Generator.Oscillator;

import com.tgeindre.Synthesizer.Generator.Oscillator.Frequency.Frequency;

public class Square implements Oscillator
{
    private Frequency freq;
    private double amplitude;
    private Sinusoidal sin;

    public Square(Frequency freq, double amplitude, double phase)
    {
        this.freq = freq;
        this.amplitude = amplitude;
        sin = new Sinusoidal(freq, 1, phase);
    }

    public Square(double freq, double amplitude, double phase)
    {
        this(new Frequency(freq), amplitude, phase);
    }

    @Override
    public double getValue(double deltaTime) {
        return (sin.getValue(deltaTime) > 0 ? 1 : -1) * amplitude;
    }
}
