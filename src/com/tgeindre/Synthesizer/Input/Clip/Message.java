package com.tgeindre.Synthesizer.Input.Clip;

public class Message implements com.tgeindre.Synthesizer.Input.Message {
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
