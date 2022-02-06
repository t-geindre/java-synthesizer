package tgeindre.Synthesizer.Dsp.Ouput;

import tgeindre.Synthesizer.Dsp.Time.Clock;

public interface Output {
    void addSample(double sample);

    Clock getClock();

    void close();
}
