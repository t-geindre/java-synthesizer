package tgeindre.Synthesizer.Generator.Effect;

import tgeindre.Synthesizer.Generator.Generator;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Delay implements Effect
{
    private Generator generator;
    private double delay;
    private double amplitude;
    private double lifeTime;
    private Queue<Double> samples;

    public Delay(Generator generator, double delay, double amplitude)
    {
        this.generator = generator;
        this.delay = delay;
        this.amplitude = amplitude;
        lifeTime = 0;
        samples = new LinkedList<>();
    }

    @Override
    public double getValue(double deltaTime)
    {
        lifeTime += deltaTime;

        double value = generator.getValue(deltaTime);
        samples.add(value);

        if (lifeTime > delay) {
            value += samples.remove() * amplitude;
        }

        return value;
    }
}
