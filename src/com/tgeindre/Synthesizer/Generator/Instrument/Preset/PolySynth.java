package com.tgeindre.Synthesizer.Generator.Instrument.Preset;

import com.tgeindre.Synthesizer.Generator.Effect.Delay;
import com.tgeindre.Synthesizer.Generator.Effect.Effect;
import com.tgeindre.Synthesizer.Generator.Effect.Void;
import com.tgeindre.Synthesizer.Generator.Envelope.Shape;
import com.tgeindre.Synthesizer.Generator.Generator;
import com.tgeindre.Synthesizer.Generator.Instrument.Preset.Utils.Unison;
import com.tgeindre.Synthesizer.Generator.Oscillator.Oscillator;
import com.tgeindre.Synthesizer.Generator.Oscillator.SawTooth;

public class PolySynth implements Preset
{
    private Unison unison;

    public PolySynth()
    {
        unison = new Unison();
        unison.setVoices(10);
        unison.setDetuneStep(.6);
        unison.setDephaseStep(9000);
    }

    @Override
    public Shape getEnvelopeShape()
    {
        return new Shape(
            1,
            50000,
            50000,
            .6,
            500000
        );
    }

    @Override
    public Oscillator getOscillator(double freq)
    {
        return unison.getOscillator(new SawTooth(freq, 1, 0));
    }

    @Override
    public Effect getEffectChain(Generator generator)
    {
        return new Delay(generator, 300000, .3);
    }
}
