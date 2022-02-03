package com.tgeindre.Synthesizer.Time;

public class Clock
{
    // micro second
    private int time;
    private int tickDuration;

    public Clock(int tickDuration)
    {
        this.tickDuration = tickDuration;
        time = 0;
    }

    public void tick()
    {
        time += tickDuration;
    }

    public int getTime()
    {
        return time;
    }

    public int getTickDuration()
    {
        return tickDuration;
    }
}
