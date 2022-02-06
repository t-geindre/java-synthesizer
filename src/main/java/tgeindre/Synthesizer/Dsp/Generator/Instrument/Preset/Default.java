package tgeindre.Synthesizer.Dsp.Generator.Instrument.Preset;

import tgeindre.Synthesizer.Dsp.Generator.Effect.Delay;
import tgeindre.Synthesizer.Dsp.Generator.Effect.Effect;
import tgeindre.Synthesizer.Dsp.Generator.Envelope.Shape;
import tgeindre.Synthesizer.Dsp.Generator.Generator;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Preset.Utils.Unison;
import tgeindre.Synthesizer.Dsp.Generator.Oscillator.Oscillator;
import tgeindre.Synthesizer.Dsp.Generator.Oscillator.SawTooth;

public class Default implements Preset
{
    private Unison unison;

    public Default()
    {
        unison = new Unison();
        unison.setVoices(8);
        unison.setDetuneStep(.2);
        unison.setDephaseStep(0);
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
