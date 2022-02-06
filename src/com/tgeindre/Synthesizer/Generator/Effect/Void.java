package com.tgeindre.Synthesizer.Generator.Effect;

import com.tgeindre.Synthesizer.Generator.Generator;

public class Void implements Effect
{
    private Generator generator;

    public Void(Generator generator)
    {
        this.generator = generator;
    }
    @Override
    public double getValue(double deltaTime)
    {
        return generator.getValue(deltaTime);
    }
}
