package tgeindre.Synthesizer.Dsp.Generator.Oscillator.Frequency;

public class Frequency
{
    private double freq;

    public Frequency(double freqMhz)
    {
        this.freq = freqMhz / 1000000; // Mega hz to micro he
    }

    public double getFrequency(double deltaTime)
    {
        return freq;
    }

    public void detune(double step)
    {
        this.freq += step / 1000000;
    }

    public Frequency clone()
    {
        return new Frequency(freq * 1000000);
    }

    // Todo add LFO
}
