package com.tgeindre.Synthesizer.Function;

public class Linear implements Function
{
    private double from;
    private double target;
    private double duration;
    private double lifeTime;

    public Linear(double from, double target, double duration)
    {
        this.from = from;
        this.target = target;
        this.duration = duration;
        lifeTime = 0;
    }

    public Linear(double target, double duration)
    {
        this(0, target, duration);
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getDuration()
    {
        return duration;
    }

    @Override
    public double getTargetValue() {
        return target;
    }

    @Override
    public double getValue(double deltaTime) {
        lifeTime += deltaTime;

        return from + (target - from) * Math.max(1, lifeTime / duration);
    }
}
