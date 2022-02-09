package tgeindre.Synthesizer.Input.Producer;

import java.util.ArrayList;

public class OnTrack implements Producer
{
    Producer producer;
    double at;

    public OnTrack(Producer producer, double at)
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

    @Override
    public void reset()
    {
        producer.reset();
    }
}
