package com.tgeindre.Synthesizer;

import com.tgeindre.Synthesizer.Generator.Instrument.Instrument;
import com.tgeindre.Synthesizer.Generator.Instrument.Preset.Test;
import com.tgeindre.Synthesizer.Generator.Stack;
import com.tgeindre.Synthesizer.Ouput.Output;
import com.tgeindre.Synthesizer.Ouput.System;
import com.tgeindre.Synthesizer.Time.Clock;

import javax.sound.sampled.LineUnavailableException;

public class Main
{
    public static void main(String[] args) {
        Output output = null;
        try {
            output = new System();
        } catch (LineUnavailableException e) {
            java.lang.System.out.println("Audio initialization failed " + e.getMessage());
            return;
        }

        Clock clock = output.getClock();

        Instrument inst = new Instrument(new Test());
        inst.noteOn("C4", 1);
        inst.noteOn("C5", 1);

        Stack stack = new Stack();
        stack.add(inst);

        while (clock.getTime() < 10000000) {
            if (clock.getTime() > 1000000) {
                inst.noteOff("C4");
                inst.noteOff("C5");
            }
            output.addSample(stack.getValue(clock.getTime()) * 10000);
        }
    }
}
