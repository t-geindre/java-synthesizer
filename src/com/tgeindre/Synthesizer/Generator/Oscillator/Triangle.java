package com.tgeindre.Synthesizer.Generator.Oscillator;

import com.tgeindre.Synthesizer.Generator.Oscillator.Frequency.Frequency;

public class Triangle implements Oscillator
{
    private Sinusoidal sin;
    private double amplitude;

    public Triangle(Frequency freq, double amplitude, double phase)
    {
        this.amplitude = amplitude;
        sin = new Sinusoidal(freq, 1, phase);
    }

    public Triangle(double freq, double amplitude, double phase)
    {
        this(new Frequency(freq), amplitude, phase);
    }

    @Override
    public double getValue(double deltaTime) {
        return Math.asin(sin.getValue(deltaTime)) * amplitude;
    }
}