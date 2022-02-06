package tgeindre.Synthesizer.Dsp.Generator.Oscillator;

import tgeindre.Synthesizer.Dsp.Generator.Oscillator.Frequency.Frequency;

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
        return new Sinusoidal(freq, amplitude, phase);
    }

    @Override
    public Frequency getFrequency()
    {
        return freq;
    }

    @Override
    public void setFrequency(Frequency freq)
    {
        this.freq = freq;
    }

    @Override
    public void setFrequency(double freq)
    {
        this.freq = new Frequency(freq);
    }

    @Override
    public void setPhase(double phase)
    {
        this.phase = phase;
    }

    @Override
    public double getPhase()
    {
        return phase;
    }
}
