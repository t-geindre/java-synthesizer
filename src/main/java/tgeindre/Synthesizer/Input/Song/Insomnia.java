package tgeindre.Synthesizer.Input.Song;

import tgeindre.Synthesizer.Dsp.Generator.Instrument.AllKeys;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Instrument;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Preset.Default;
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
        Track track = new BaseTrack(synth, "Main");
        track.append(new MainMelody());

        ArrayList<Track> tracks = new ArrayList<>();
        tracks.add(track);

        return tracks;
    }
}
