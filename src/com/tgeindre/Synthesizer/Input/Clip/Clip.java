package com.tgeindre.Synthesizer.Input.Clip;

import com.tgeindre.Synthesizer.Input.Message;
import com.tgeindre.Synthesizer.Input.Producer;

import java.util.ArrayList;
import java.util.Comparator;

public class Clip implements Producer {
    private ArrayList<Note> partition;
    private ArrayList<Note> notesOn;
    private double length;
    private int index;
    private int maxIndex;

    public Clip(ArrayList<Note> partition)
    {
        notesOn = new ArrayList<>();
        this.partition = partition;
        computePartition();
    }

    public Clip()
    {
        this(new ArrayList<Note>());
    }

    public void reset()
    {
        index = 0;
    }

    public double getLength() {
        return length;
    }

    public void addNote(String note, double at, double duration)
    {
        partition.add(new Note(note, at, duration));
        computePartition();
    }

    public void appendNote(String note, double duration)
    {
        addNote(note, length, duration);
    }

    public void stackNote(String note, double duration)
    {
        double at = maxIndex == 0 ? 0 : partition.get(maxIndex - 1).getAt();
        addNote(note, at, duration);
    }

    public boolean isOver()
    {
        return index >= maxIndex && notesOn.size() == 0;
    }

    @Override
    public ArrayList<Message> pullMessages(double time)
    {
        ArrayList<Message> messages = new ArrayList<>();

        while (index < maxIndex) {
            Note note = partition.get(index);
            if (note.getAt() < time) {
                messages.add(new com.tgeindre.Synthesizer.Input.Clip.Message(note.getNote(), true));
                notesOn.add(note);
                index++;
            }
            break;
        }

        ArrayList<Note> notesOff = new ArrayList<>();
        for (Note note: notesOn) {
            if (note.getAt() + note.getDuration() < time) {
                messages.add(new com.tgeindre.Synthesizer.Input.Clip.Message(note.getNote(), false));
                notesOff.add(note);
            }
        }
        notesOn.removeAll(notesOff);

        return messages;
    }

    private void computePartition()
    {
        partition.sort(Comparator.comparingDouble(Note::getAt));
        maxIndex = partition.size();

        if (maxIndex == 0) {
            length = 0;
            return;
        }

        Note lastNote = partition.get(maxIndex - 1);
        length = lastNote.getAt() + lastNote.getDuration();
    }
}
