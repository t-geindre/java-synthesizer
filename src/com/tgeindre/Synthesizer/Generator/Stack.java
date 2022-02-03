package com.tgeindre.Synthesizer.Generator;


import java.util.ArrayList;

public class Stack implements Generator
{
    private ArrayList<Generator> generators;

    public Stack()
    {
        generators = new ArrayList<>();
    }

    public void add(Generator generator)
    {
        generators.add(generator);
    }

    @Override
    public double getValue(double deltaTime)
    {
        double value = 0;

        for(Generator generator: generators) {
            if (generator instanceof Over && ((Over) generator).isOver()) {
                generators.remove(generator);
                continue;
            }

            value += generator.getValue(deltaTime);
        }

        return value;
    }
}
