package com.tgeindre.Synthesizer.Function;

public class Linear implements Function
{
    private double from;
    private double target;
    private double duration;

    public Linear(double from, double target, double duration)
    {
        this.from = from;
        this.target = target;
        this.duration = duration;
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
        return from + ((target - from) * (deltaTime / duration));
    }
}
