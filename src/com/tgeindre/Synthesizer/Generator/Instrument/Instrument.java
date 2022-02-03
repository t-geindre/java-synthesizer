package com.tgeindre.Synthesizer.Generator.Instrument;

import com.tgeindre.Synthesizer.Generator.Envelope.Envelope;
import com.tgeindre.Synthesizer.Generator.Generator;
import com.tgeindre.Synthesizer.Generator.Instrument.Preset.Preset;
import com.tgeindre.Synthesizer.Generator.Oscillator.Frequency.NoteReference;
import com.tgeindre.Synthesizer.Generator.Oscillator.Oscillator;
import com.tgeindre.Synthesizer.Generator.Stack;

import java.util.HashMap;

public class Instrument implements Generator {

    private Preset preset;
    private NoteReference noteReference;
    private Stack generators;
    private HashMap<String, Envelope> notesOn;

    public Instrument(Preset preset)
    {
        this(preset, new NoteReference());
    }

    public Instrument(Preset preset, NoteReference noteReference)
    {
        this.preset = preset;
        this.noteReference = noteReference;

        notesOn = new HashMap<>();
        generators = new Stack();
    }

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

        generators.add(env);
        notesOn.put(note, env);
    }

    public void noteOff(String note)
    {
        if (notesOn.containsKey(note)) {
            Envelope envelope = notesOn.get(note);
            envelope.noteOff();
            notesOn.remove(envelope);
        }
    }

    public void sustainOn()
    {

    }

    public void sustainOff()
    {

    }

    @Override
    public double getValue(double deltaTime) {
        return generators.getValue(deltaTime);
    }
}
