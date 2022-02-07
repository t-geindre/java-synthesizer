package tgeindre.Synthesizer.Input.Track;

import tgeindre.Synthesizer.Dsp.Generator.Generator;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Instrument;
import tgeindre.Synthesizer.Input.Producer.Clip.Note;
import tgeindre.Synthesizer.Input.Producer.Message;
import tgeindre.Synthesizer.Input.Producer.Producer;

import java.util.ArrayList;
import java.util.Comparator;

public class Track implements Generator
{
    double length;
    Instrument instrument;
    ArrayList<ProducerOnTrack> producers;
    ProducerOnTrack producer;
    int maxIndex;
    int index;
    double lifeTime;

    public Track(Instrument instrument)
    {
        this.instrument = instrument;
        producers = new ArrayList<>();
        index = 0;
        maxIndex = 0;
        lifeTime = 0;
    }

    public void append(Producer producer)
    {
        this.addAt(producer, length);
    }

    public void addAt(Producer producer, double at)
    {
        producers.add(new ProducerOnTrack(producer, at));
        computeProducers();
    }

    public void reset()
    {
        index = 0;
    }

    @Override
    public double getValue(double deltaTime)
    {
        lifeTime += deltaTime;

        updateProducers();
        pullMessages();

        return instrument.getValue(deltaTime);
    }

    private void pullMessages()
    {
        if (producer == null) {
            return;
        }

        for (Message message : producer.pullMessages(lifeTime - producer.getAt())) {
            if (message.isOn()) {
                instrument.noteOn(message.getNote(), 1);
            } else {
                instrument.noteOff(message.getNote());
            }
        }
    }

    private void updateProducers()
    {
        if (index >= maxIndex) {
            return;
        }

        if (producer != null && !producer.isOver()) {
            return;
        }

        if (producers.get(index).getAt() >= lifeTime) {
            producer = producers.get(index);
            index++;
        }
    }

    private void computeProducers()
    {
        producers.sort(Comparator.comparingDouble(ProducerOnTrack::getAt));
        maxIndex = producers.size();

        if (maxIndex == 0) {
            length = 0;
            return;
        }

        ProducerOnTrack lastProducer = producers.get(maxIndex - 1);
        length = lastProducer.getAt() + lastProducer.getLength();
    }
}
