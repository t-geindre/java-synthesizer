package tgeindre.Synthesizer.Dsp.Generator.Instrument.Preset;

import tgeindre.Synthesizer.Dsp.Generator.Effect.Effect;
import tgeindre.Synthesizer.Dsp.Generator.Envelope.Shape;
import tgeindre.Synthesizer.Dsp.Generator.Generator;
import tgeindre.Synthesizer.Dsp.Generator.Oscillator.Oscillator;

public interface Preset
{
    Shape getEnvelopeShape();
    Oscillator getOscillator(double freq);
    Effect getEffectChain(Generator generator);
}
