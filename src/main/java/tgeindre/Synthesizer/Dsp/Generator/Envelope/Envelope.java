package tgeindre.Synthesizer.Dsp.Generator.Envelope;

import tgeindre.Synthesizer.Dsp.Generator.Generator;
import tgeindre.Synthesizer.Dsp.Generator.Oscillator.Oscillator;
import tgeindre.Synthesizer.Dsp.Generator.Over;

public class Envelope implements Generator, Over
{
    private Oscillator oscillator;
    private Shape shape;
    private enum Phase {ATTACK, DECAY, SUSTAIN, RELEASE, OVER};
    private Phase phase;
    private double lifeTime;
    private double timeOff;
    private double amplitude;

    public Envelope(Oscillator oscillator, Shape shape)
    {
        this.oscillator = oscillator;
        this.shape = shape;
        amplitude = 0;
        phase = Phase.ATTACK;
    }

    public void noteOn(double velocity)
    {
        lifeTime = 0;
        timeOff = 0;
        phase = Phase.ATTACK;
        shape.getAttack().setFrom(amplitude);
    }

    public void noteOff()
    {
        timeOff = lifeTime;
        phase = Phase.RELEASE;
        shape.getRelease().setFrom(amplitude);
    }

    public boolean isOver()
    {
        return phase == Phase.OVER;
    }

    @Override
    public double getValue(double deltaTime)
    {
        lifeTime += deltaTime;
        computeAmplitude();
        return oscillator.getValue(deltaTime) * amplitude;
    }

    private void computeAmplitude()
    {
        switch (phase) {
            case ATTACK:
                amplitude = shape.getAttack().getValue(lifeTime);
                if (lifeTime >= shape.getAttack().getDuration()) {
                    amplitude = shape.getAttack().getTargetValue();
                    shape.getDecay().setFrom(amplitude);
                    phase = Phase.DECAY;
                }
                break;

            case DECAY:
                double decayLifeTime = lifeTime - shape.getAttack().getDuration();
                amplitude = shape.getDecay().getValue(decayLifeTime);
                if (decayLifeTime >= shape.getDecay().getDuration()) {
                    amplitude = shape.getDecay().getTargetValue();
                    shape.getSustain().setFrom(amplitude);
                    phase = Phase.SUSTAIN;
                }
                break;

            case SUSTAIN:
                amplitude = shape.getSustain().getValue(lifeTime);
                break;

            case RELEASE:
                double releaseLifeTime = lifeTime - timeOff;
                amplitude = shape.getRelease().getValue(releaseLifeTime);
                if (releaseLifeTime >= shape.getRelease().getDuration()) {
                    amplitude = shape.getRelease().getTargetValue();
                    phase = Phase.OVER;
                }
                break;
        }
    }
}
