package tgeindre.Synthesizer.Dsp.Generator;


import java.util.ArrayList;

public class Stack implements Generator, Over
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
            value += generator.getValue(deltaTime);
        }

        return value;
    }

    public void clearOver()
    {
        ArrayList<Generator> toRemove = new ArrayList<>();

        for(Generator generator: generators) {
            if (generator instanceof Over && ((Over) generator).isOver()) {
                toRemove.add(generator);
                continue;
            }
        }

        generators.removeAll(toRemove);
    }

    @Override
    public boolean isOver()
    {
        return generators.size() == 0;
    }
}
