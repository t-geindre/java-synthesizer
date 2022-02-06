package tgeindre.Synthesizer.Dsp.Function;

import tgeindre.Synthesizer.Dsp.Generator.Generator;

public interface Function extends Generator
{
    public void setFrom(double from);
    public double getDuration();
    public double getTargetValue();
}
