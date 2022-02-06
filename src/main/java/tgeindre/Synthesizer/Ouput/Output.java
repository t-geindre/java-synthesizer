package tgeindre.Synthesizer.Ouput;

import tgeindre.Synthesizer.Time.Clock;

public interface Output {
    void addSample(double sample);

    Clock getClock();

    void close();
}
