package tgeindre.Synthesizer.Generator.Oscillator;

import tgeindre.Synthesizer.Generator.Oscillator.Frequency.Frequency;

public class Square implements Oscillator
{
    private double amplitude;
    private Sinusoidal sin;

    public Square(Frequency freq, double amplitude, double phase)
    {
        this.amplitude = amplitude;
        sin = new Sinusoidal(freq, 1, phase);
    }

    public Square(double freq, double amplitude, double phase)
    {
        this(new Frequency(freq), amplitude, phase);
    }

    @Override
    public double getValue(double deltaTime)
    {
        return (sin.getValue(deltaTime) > 0 ? 1 : -1) * amplitude;
    }

    @Override
    public Oscillator clone()
    {
        return new Square(sin.getFrequency(), amplitude, sin.getPhase());
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
        sin.setFrequency(freq);
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
