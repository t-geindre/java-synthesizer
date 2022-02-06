package tgeindre.Synthesizer.Dsp.Function;

public class Constant implements Function
{
    private double value;
    private double duration;

    public Constant(double value, double duration)
    {
        this.value = value;
        this.duration = duration;
    }

    public Constant(double value)
    {
        this(value, 0);
    }

    @Override
    public double getTargetValue() {
        return value;
    }

    public void setFrom(double from) {}

    public double getDuration() { return duration; }

    public double getValue(double deltaTime) {
        return value;
    }
}
