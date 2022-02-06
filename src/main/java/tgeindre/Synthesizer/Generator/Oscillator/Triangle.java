package tgeindre.Synthesizer.Generator.Oscillator;

import tgeindre.Synthesizer.Generator.Oscillator.Frequency.Frequency;

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
    public double getValue(double deltaTime)
    {
        return Math.asin(sin.getValue(deltaTime)) * amplitude;
    }

    @Override
    public Oscillator clone()
    {
        return new Triangle(sin.getFrequency(), amplitude, sin.getPhase());
    }

    @Override
    public Frequency getFrequency()
    {
        return sin.getFrequency();
    }

    @Override
    public void setFrequency(Frequency freq)
    {
        sin.setFrequency(freq);
    }

    @Override
    public void setFrequency(double freq)
    {
        sin.setFrequency(new Frequency(freq));
    }

    @Override
    public void setPhase(double phase)
    {
        sin.setPhase(phase);
    }

    @Override
    public double getPhase()
    {
        return sin.getPhase();
    }
}
