package tgeindre.Synthesizer.Input.Song;

import tgeindre.Synthesizer.Dsp.Generator.Instrument.AllKeys;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Instrument;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Preset.Default;
import tgeindre.Synthesizer.Input.Producer.Clip.Clip;
import tgeindre.Synthesizer.Input.Song.Clip.Insomnia.MainMelody;
import tgeindre.Synthesizer.Input.Track.BaseTrack;
import tgeindre.Synthesizer.Input.Track.Track;

import java.util.ArrayList;

public class Insomnia implements Song
{
    @Override
    public ArrayList<Track> getTracks()
    {
        Instrument synth = new AllKeys(new Default());
        ArrayList<Track> tracks = new ArrayList<>();

        Track track = new BaseTrack(synth, "Main melody");
        Clip c = new MainMelody();
        track.append(c);
        track.append(new MainMelody());
        track.addAt(new MainMelody(), c.getLength() * 3);
        tracks.add(track);

        synth = new AllKeys(new Default());
        track = new BaseTrack(synth, "Main melody copy");
        track.addAt(new MainMelody(), c.getLength() * 2);
        track.append(new MainMelody());
        track.setAmplitude(.5);
        tracks.add(track);

        return tracks;
    }
}
