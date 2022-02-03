package com.tgeindre.Synthesizer.Generator.Oscillator.Frequency;

public class Frequency
{
    private double freq;

    public Frequency(double freqMhz)
    {
        this.freq = freqMhz / 1000000; // Mega hz to micro he
    }

    public double getFrequency(double deltaTime)
    {
        return freq;
    }

    // Todo add LFO
}
