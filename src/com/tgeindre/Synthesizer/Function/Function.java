package com.tgeindre.Synthesizer.Function;

import com.tgeindre.Synthesizer.Generator.Generator;

public interface Function extends Generator
{
    public void setFrom(double from);
    public double getDuration();
    public double getTargetValue();
}
