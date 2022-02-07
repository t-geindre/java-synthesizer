package tgeindre.Synthesizer.Dsp.Generator.Instrument;

import tgeindre.Synthesizer.Dsp.Generator.Generator;
import tgeindre.Synthesizer.Dsp.Generator.Over;

public interface Instrument extends Generator, Over
{
    void noteOn(String note, double velocity);

    void noteOff(String note);

    void sustainOn();

    void sustainOff();
}
