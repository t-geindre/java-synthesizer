package tgeindre.Synthesizer.Dsp.Input;

import java.util.ArrayList;

public interface Producer {
    ArrayList<Message> pullMessages(double time);
}
