package com.tgeindre.Synthesizer.Generator.Oscillator;

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
}
