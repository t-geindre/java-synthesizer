package tgeindre.Synthesizer.Input;

import java.util.ArrayList;

public interface Producer {
    ArrayList<Message> pullMessages(double time);
}
