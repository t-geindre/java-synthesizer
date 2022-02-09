package tgeindre.Synthesizer.Input.Track;

import tgeindre.Synthesizer.Dsp.Generator.Generator;
import tgeindre.Synthesizer.Dsp.Generator.Over;
import tgeindre.Synthesizer.Input.Producer.Producer;

public interface Track extends Generator, Over
{
    void append(Producer producer);

    void addAt(Producer producer, double at);

    void reset();

    double getValue(double deltaTime);

    String getName();

    void setName(String name);

    void stop();

    void play();

    boolean isOver();
}
