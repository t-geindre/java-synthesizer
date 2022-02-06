package tgeindre.Synthesizer.Function;

import tgeindre.Synthesizer.Generator.Generator;

public interface Function extends Generator
{
    public void setFrom(double from);
    public double getDuration();
    public double getTargetValue();
}
