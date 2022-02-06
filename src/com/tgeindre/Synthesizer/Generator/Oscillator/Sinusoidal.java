package com.tgeindre.Synthesizer.Generator.Oscillator;

import com.tgeindre.Synthesizer.Generator.Oscillator.Frequency.Frequency;

public class Sinusoidal implements Oscillator
{
    private Frequency freq;
    private double amplitude;
    private double phase;
    private double lifeTime;

    public Sinusoidal(Frequency freq, double amplitude, double phase)
    {
        this.freq = freq;
        this.amplitude = amplitude;
        this.phase = phase;
        lifeTime = 0;
    }

    public Sinusoidal(double freq, double amplitude, double phase)
    {
        this(new Frequency(freq), amplitude, phase);
    }

    @Override
    public double getValue(double deltaTime)
    {
        lifeTime += deltaTime;

        return Math.sin(2 * Math.PI * freq.getFrequency(lifeTime) * (lifeTime + phase)) * amplitude;
    }

    @Override
    public Oscillator clone()
    {
        return null;
    }

    @Override
    public Frequency getFrequency()
    {
        return null;
    }

    @Override
    public void setFrequency(Frequency freq)
    {

    }

    @Override
    public void setFrequency(double freq)
    {

    }

    @Override
    public void setPhase(double phase)
    {

    }

    @Override
    public double getPhase()
    {
        return 0;
    }
}
