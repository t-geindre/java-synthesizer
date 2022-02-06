package tgeindre.Synthesizer.Generator.Instrument.Preset.Utils;

import tgeindre.Synthesizer.Generator.Oscillator.Frequency.Frequency;
import tgeindre.Synthesizer.Generator.Oscillator.Oscillator;
import tgeindre.Synthesizer.Generator.Oscillator.Stack;

public class Unison
{
    private int voices = 0;
    private double detuneStep = 0;
    private double dephaseStep = 0;

    public Oscillator getOscillator(Oscillator oscillator)
    {
        Stack stack = new Stack();

        double detune = 0;
        double dephase = 0;

        for (int i = 0; i < voices / 2; i++) {
            for (int signe = -1; signe <= 1; signe += 2) {
                detune += detuneStep;
                dephase += dephaseStep;

                Oscillator osc = oscillator.clone();
                Frequency freq = osc.getFrequency().clone();

                freq.detune(detune * signe);
                osc.setFrequency(freq);

                osc.setPhase(dephase * signe);

                stack.add(osc);
            }
        }

        stack.add(oscillator);

        return stack;
    }

    public void setVoices(int voices)
    {
        if (voices < 0 || voices % 2 > 0) {
            throw new IllegalArgumentException("Voices must be greater than 0 and even");
        }

        this.voices = voices;
    }

    public void setDephaseStep(double dephaseStep)
    {
        this.dephaseStep = dephaseStep;
    }

    public void setDetuneStep(double detuneStep)
    {
        this.detuneStep = detuneStep;
    }
}
