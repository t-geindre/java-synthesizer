package tgeindre.Synthesizer.Input.Producer;

import tgeindre.Synthesizer.Dsp.Generator.Over;

import java.util.ArrayList;

public interface Producer extends Over
{
    ArrayList<Message> pullMessages(double time);
    double getLength();
    void reset();
}
