package com.tgeindre.Synthesizer.Ouput;

import com.tgeindre.Synthesizer.Time.Clock;

public interface Output {
    void addSample(double sample);

    Clock getClock();

    void close();
}
