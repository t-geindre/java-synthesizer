package tgeindre.Synthesizer.Input.Producer.Clip;

public class Message implements tgeindre.Synthesizer.Input.Producer.Message
{
    private String note;
    private boolean isOn;

    public Message(String note, boolean isOn) {
        this.note = note;
        this.isOn = isOn;
    }

    @Override
    public String getNote() {
        return note;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }
}
