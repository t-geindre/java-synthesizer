package tgeindre.Synthesizer.Generator.Instrument.Preset;

import tgeindre.Synthesizer.Generator.Effect.Effect;
import tgeindre.Synthesizer.Generator.Envelope.Shape;
import tgeindre.Synthesizer.Generator.Generator;
import tgeindre.Synthesizer.Generator.Oscillator.Oscillator;

public interface Preset
{
    Shape getEnvelopeShape();
    Oscillator getOscillator(double freq);
    Effect getEffectChain(Generator generator);
}
