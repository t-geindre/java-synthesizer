package tgeindre.Synthesizer.Input.Song.Clip.Insomnia;

import tgeindre.Synthesizer.Input.Producer.Clip.Clip;

public class MainMelody extends Clip
{
    public MainMelody()
    {
        int speed = 50000;

        addNote("F#3", getLength() + 6 * speed, 4 * speed);
        stackNote("B3", 4 * speed);
        stackNote("E4", 4 * speed);

        addNote("F#3",getLength() + 1 * speed, 4 * speed);
        stackNote("B3", 4 * speed);
        stackNote("E4", 4 * speed);

        addNote("E4",getLength() + 1 * speed, 2 * speed);

        appendNote("F#3",6 * speed);
        stackNote("B3", 6 * speed);

        addNote("F#3", getLength() + 2 * speed, 4 * speed);
        stackNote("B3", 4 * speed);
        stackNote("D4", 4 * speed);

        addNote("F#3", getLength() + 1 * speed, 4 * speed);
        stackNote("B3", 4 * speed);
        stackNote("D4", 4 * speed);

        addNote("D4", getLength() + 1 * speed, 2 * speed);

        appendNote("F#3",6 * speed);
        stackNote("B3", 6 * speed);
        stackNote("C#4", 6 * speed);

        addNote("F#3", getLength() + 2 * speed, 4 * speed);
        stackNote("B3", 4 * speed);
        stackNote("C#4", 4 * speed);

        addNote("F#3", getLength() + 1 * speed, 4 * speed);
        stackNote("B3", 4 * speed);
        stackNote("C#4", 4 * speed);

        addNote("C#4", getLength() + 1 * speed, 2 * speed);
        appendNote("F#3",6 * speed);
        stackNote("B3", 6 * speed);
        stackNote("D4", 6 * speed);

        addNote("F#3", getLength() + 2 * speed, 4 * speed);
        stackNote("B3", 4 * speed);
        stackNote("D4", 4 * speed);

        addNote("F#3", getLength() + 1 * speed, 4 * speed);
        stackNote("B3", 4 * speed);
        stackNote("C#4", 4 * speed);

        addNote("F#3", getLength() + 1 * speed, 4 * speed);
        stackNote("B3", 4 * speed);
        stackNote("D4", 4 * speed);
    }
}

