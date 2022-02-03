package com.tgeindre.Synthesizer.Generator.Instrument.Preset;

import com.tgeindre.Synthesizer.Generator.Envelope.Shape;
import com.tgeindre.Synthesizer.Generator.Oscillator.Oscillator;
import com.tgeindre.Synthesizer.Generator.Oscillator.SawTooth;

public class Test implements Preset
{
    @Override
    public Shape getEnvelopeShape() {
        return new Shape(1, 1000, 1000, .2, 1000);
    }

    @Override
    public Oscillator getOscillator(double freq) {
        return new SawTooth(freq, 1, 0);
    }
}
