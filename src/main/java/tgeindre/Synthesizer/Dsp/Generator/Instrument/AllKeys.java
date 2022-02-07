package tgeindre.Synthesizer.Dsp.Generator.Instrument;

import tgeindre.Synthesizer.Dsp.Generator.Effect.Effect;
import tgeindre.Synthesizer.Dsp.Generator.Envelope.Envelope;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Preset.Preset;
import tgeindre.Synthesizer.Dsp.Generator.Oscillator.Frequency.NoteReference;
import tgeindre.Synthesizer.Dsp.Generator.Oscillator.Oscillator;
import tgeindre.Synthesizer.Dsp.Generator.Stack;

import java.util.HashMap;

public class AllKeys implements Instrument
{

    private Preset preset;
    private NoteReference noteReference;
    private Stack generators;
    private Effect generatorsWithEffect;
    private HashMap<String, Envelope> notesOn;

    public AllKeys(Preset preset)
    {
        this(preset, new NoteReference());
    }

    public AllKeys(Preset preset, NoteReference noteReference)
    {
        this.preset = preset;
        this.noteReference = noteReference;

        notesOn = new HashMap<>();
        generators = new Stack();

        generatorsWithEffect = preset.getEffectChain(generators);
    }

    @Override
    public void noteOn(String note, double velocity)
    {
        if (!noteReference.getReference().containsKey(note)) {
            throw new IllegalArgumentException("Unknown note " + note);
        }

        if (notesOn.containsKey(note)) {
            noteOff(note);
        }

        Oscillator osc = preset.getOscillator(noteReference.getReference().get(note));
        Envelope env = new Envelope(osc, preset.getEnvelopeShape());

        env.noteOn(velocity);

        generators.add(env);
        notesOn.put(note, env);
    }

    @Override
    public void noteOff(String note)
    {
        if (notesOn.containsKey(note)) {
            Envelope envelope = notesOn.get(note);
            envelope.noteOff();
            notesOn.remove(note);
        }
    }

    @Override
    public void sustainOn()
    {

    }

    @Override
    public void sustainOff()
    {

    }

    @Override
    public double getValue(double deltaTime)
    {
        generators.clearOver();

        return generatorsWithEffect.getValue(deltaTime);
    }

    @Override
    public boolean isOver()
    {
        return notesOn.size() == 0 && generators.isOver();
    }
}
