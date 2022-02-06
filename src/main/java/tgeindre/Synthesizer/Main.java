package tgeindre.Synthesizer;

import tgeindre.Synthesizer.Dsp.Generator.Instrument.AllKeys;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Preset.Default;
import tgeindre.Synthesizer.Dsp.Generator.Stack;
import tgeindre.Synthesizer.Dsp.Input.Clip.Clip;
import tgeindre.Synthesizer.Dsp.Input.Message;
import tgeindre.Synthesizer.Dsp.Ouput.Output;
import tgeindre.Synthesizer.Dsp.Ouput.System;
import tgeindre.Synthesizer.Dsp.Song.Clip.Insomnia.MainMelody;
import tgeindre.Synthesizer.Dsp.Time.Clock;

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

        AllKeys inst = new AllKeys(new Default());

        Stack stack = new Stack();
        stack.add(inst);

        Clip clip = new MainMelody();

        while (!clip.isOver() || !inst.isOver()) {
            for (Message message : clip.pullMessages(clock.getTime())) {
                if (message.isOn()) {
                    inst.noteOn(message.getNote(), 1);
                } else {
                    inst.noteOff(message.getNote());
                }
            }
            output.addSample(stack.getValue(clock.getTickDuration()));
        }

        output.close();
    }
}
