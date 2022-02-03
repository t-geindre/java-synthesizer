package com.tgeindre.Synthesizer.Generator.Oscillator.Frequency;

import java.util.TreeMap;

public class NoteReference
{
    TreeMap<String, Double> reference;

    public NoteReference()
    {
        initialize();
    }

    public TreeMap<String, Double> getReference() {
        return reference;
    }

    private void initialize()
    {
        reference = new TreeMap<>();

        reference.put("C8", 4186.01);
        reference.put("B7", 3951.07);
        reference.put("A#7", 3729.31);
        reference.put("A7", 3520.00);
        reference.put("G#7", 3322.44);
        reference.put("G7", 3135.96);
        reference.put("F#7", 2959.96);
        reference.put("F7", 2793.83);
        reference.put("E7", 2637.02);
        reference.put("D#7", 2489.02);
        reference.put("D7", 2349.32);
        reference.put("C#7", 2217.46);
        reference.put("C7", 2093.00);
        reference.put("B6", 1975.53);
        reference.put("A#6", 1864.66);
        reference.put("A6", 1760.00);
        reference.put("G#6", 1661.22);
        reference.put("G6", 1567.98);
        reference.put("F#6", 1479.98);
        reference.put("F6", 1396.91);
        reference.put("E6", 1318.51);
        reference.put("D#6", 1244.51);
        reference.put("D6", 1174.66);
        reference.put("C#6", 1108.73);
        reference.put("C6", 1046.50);
        reference.put("B5", 987.77);
        reference.put("A#5", 932.33);
        reference.put("A5", 880.00);
        reference.put("G#5", 830.61);
        reference.put("G5", 783.99);
        reference.put("F#5", 739.99);
        reference.put("F5", 698.46);
        reference.put("E5", 659.26);
        reference.put("D#5", 622.25);
        reference.put("D5", 587.33);
        reference.put("C#5", 554.37);
        reference.put("C5", 523.25);
        reference.put("B4", 493.88);
        reference.put("A#4", 466.16);
        reference.put("A4", 440.00);
        reference.put("G#4", 415.30);
        reference.put("G4", 392.00);
        reference.put("F#4", 369.99);
        reference.put("F4", 349.23);
        reference.put("E4", 329.63);
        reference.put("D#4", 311.13);
        reference.put("D4", 293.66);
        reference.put("C#4", 277.18);
        reference.put("C4", 261.63);
        reference.put("B3", 246.94);
        reference.put("A#3", 233.08);
        reference.put("A3", 220.00);
        reference.put("G#3", 207.65);
        reference.put("G3", 196.00);
        reference.put("F#3", 185.00);
        reference.put("F3", 174.61);
        reference.put("E3", 164.81);
        reference.put("D#3", 155.56);
        reference.put("D3", 146.83);
        reference.put("C#3", 138.59);
        reference.put("C3", 130.81);
        reference.put("B2", 123.47);
        reference.put("A#2", 116.54);
        reference.put("A2", 110.00);
        reference.put("G#2", 103.83);
        reference.put("G2", 98.00);
        reference.put("F#2", 92.50);
        reference.put("F2", 87.31);
        reference.put("E2", 82.41);
        reference.put("D#2", 77.78);
        reference.put("D2", 73.42);
        reference.put("C#2", 69.30);
        reference.put("C2", 65.41);
        reference.put("B1", 61.74);
        reference.put("A#1", 58.27);
        reference.put("A1", 55.00);
        reference.put("G#1", 51.91);
        reference.put("G1", 49.00);
        reference.put("F#1", 46.25);
        reference.put("F1", 43.65);
        reference.put("E1", 41.20);
        reference.put("D#1", 38.89);
        reference.put("D1", 36.71);
        reference.put("C#1", 34.65);
        reference.put("C1", 32.70);
        reference.put("B0", 30.87);
        reference.put("A#0", 29.14);
        reference.put("A0", 27.50);
    }
}
