package tgeindre.Synthesizer.Input.Track;

import tgeindre.Synthesizer.Input.Producer.Message;
import tgeindre.Synthesizer.Input.Producer.Producer;

import java.util.ArrayList;

public class ProducerOnTrack implements Producer
{
    Producer producer;
    double at;

    public ProducerOnTrack(Producer producer, double at)
    {
        this.producer = producer;
        this.at = at;
    }

    public double getAt()
    {
        return at;
    }

    @Override
    public ArrayList<Message> pullMessages(double time)
    {
        return producer.pullMessages(time);
    }

    @Override
    public double getLength()
    {
        return producer.getLength();
    }

    @Override
    public boolean isOver()
    {
        return producer.isOver();
    }
}
