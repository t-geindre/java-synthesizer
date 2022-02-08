package tgeindre.Synthesizer.Input;

import tgeindre.Synthesizer.Input.Song.Song;
import tgeindre.Synthesizer.Input.Track.Track;

public interface Arranger
{
    void play();
    void stop();
    void close();
    void loadSong(Song song);
    void addTrack(Track track);
}
