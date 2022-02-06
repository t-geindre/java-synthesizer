package com.tgeindre.Synthesizer.Generator.Oscillator;

import com.tgeindre.Synthesizer.Generator.Oscillator.Frequency.Frequency;

import java.util.ArrayList;

public class Stack implements Oscillator
{
    ArrayList<Oscillator> oscillators;

    public Stack()
    {
        oscillators = new ArrayList<>();
    }

    public void add(Oscillator osc)
    {
        oscillators.add(osc);
    }

    @Override
    public double getValue(double deltaTime)
    {
        double value = 0;

        for (Oscillator oscillator : oscillators) {
            value += oscillator.getValue(deltaTime);
        }

        return value;
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
