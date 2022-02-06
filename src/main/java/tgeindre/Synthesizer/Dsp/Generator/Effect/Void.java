package tgeindre.Synthesizer.Dsp.Generator.Effect;

import tgeindre.Synthesizer.Dsp.Generator.Generator;

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
