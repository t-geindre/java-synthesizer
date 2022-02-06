package com.tgeindre.Synthesizer.Time;

public class Clock
{
    // micro second
    private double time;
    private double tickDuration;

    public Clock(double tickDuration)
    {
        this.tickDuration = tickDuration;
        time = 0;
    }

    public void tick()
    {
        time += tickDuration;
    }

    public double getTime()
    {
        return time;
    }

    public double getTickDuration()
    {
        return tickDuration;
    }
}
