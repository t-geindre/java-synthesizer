package tgeindre.Synthesizer.Input.Clip;

public class Note {
    private String note;
    private double at;
    private double duration;

    public Note(String note, double at, double duration) {
        this.note = note;
        this.at = at;
        this.duration = duration;
    }

    public String getNote() {
        return note;
    }

    public double getAt() {
        return at;
    }

    public void setAt(double at) {
        this.at = at;
    }

    public double getDuration() {
        return duration;
    }
}
