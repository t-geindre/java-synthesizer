package com.tgeindre.Synthesizer.Generator.Filter;

import com.tgeindre.Synthesizer.Generator.Generator;
import uk.me.berndporr.iirj.Butterworth;

/**
 * @see "https://github.com/berndporr/iirj"
 */
public class LowPass implements Filter
{
    private Butterworth filter;
    private Generator generator;

    // see http://gilles.berthome.free.fr/02-Syntheses/A-Traitement_signaux_analogiques/02-Synthese_filtrage.pdf

    public LowPass(Generator generator)
    {
        this.generator = generator;

        filter = new Butterworth();
        // Todo find a better way to provide sampling rate
        filter.lowPass(10, 44100, 2000);
    }

    @Override
    public double getValue(double deltaTime)
    {
        return filter.filter(generator.getValue(deltaTime));
    }
}
