package com.tgeindre.Synthesizer.Generator.Instrument.Preset;

import com.tgeindre.Synthesizer.Generator.Envelope.Shape;
import com.tgeindre.Synthesizer.Generator.Oscillator.Oscillator;

public interface Preset
{
    Shape getEnvelopeShape();
    Oscillator getOscillator(double freq);
}
