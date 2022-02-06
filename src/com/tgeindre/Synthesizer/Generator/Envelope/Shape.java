package com.tgeindre.Synthesizer.Generator.Envelope;

import com.tgeindre.Synthesizer.Function.Constant;
import com.tgeindre.Synthesizer.Function.Function;
import com.tgeindre.Synthesizer.Function.Linear;

public class Shape {
    private Function attack;
    private Function decay;
    private Function sustain;
    private Function release;

    public Shape(Function attack, Function decay, Function sustain, Function release) {
        this.attack = attack;
        this.decay = decay;
        this.sustain = sustain;
        this.release = release;
    }

    public Shape(double attackAmplitude, double attackDuration, double decayDuration, double sustainAmplitude, double releaseDuration)
    {
        this(
            new Linear(0, attackAmplitude, attackDuration),
            new Linear(sustainAmplitude, decayDuration),
            new Constant(sustainAmplitude),
            new Linear(0, releaseDuration)
        );
    }

    public Function getAttack() {
        return attack;
    }

    public Function getDecay() {
        return decay;
    }

    public Function getSustain() {
        return sustain;
    }

    public Function getRelease() {
        return release;
    }
}
