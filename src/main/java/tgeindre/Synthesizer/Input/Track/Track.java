package tgeindre.Synthesizer.Input.Track;

import tgeindre.Synthesizer.Dsp.Generator.Generator;
import tgeindre.Synthesizer.Dsp.Generator.Instrument.Instrument;
import tgeindre.Synthesizer.Dsp.Generator.Over;
import tgeindre.Synthesizer.Input.Producer.Message;
import tgeindre.Synthesizer.Input.Producer.Producer;

import java.util.ArrayList;
import java.util.Comparator;

public class Track implements Generator, Over
{
    double length;
    Instrument instrument;
    String name;
    ArrayList<ProducerOnTrack> producers;
    ArrayList<String> notesOn;
    ProducerOnTrack producer;
    int maxIndex;
    int index;
    double lifeTime;
    double lastSample;
    boolean isStopRequested;

    public Track(Instrument instrument, String name)
    {
        this.instrument = instrument;
        this.name = name;
        producers = new ArrayList<>();
        notesOn = new ArrayList<>();
        index = 0;
        maxIndex = 0;
        lifeTime = 0;
        isStopRequested = false;
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
        lifeTime = 0;
        isStopRequested = false;
        producer = null;

        for (Producer producer : producers) {
            producer.reset();
        }
    }

    @Override
    public double getValue(double deltaTime)
    {
        lifeTime += deltaTime;

        updateProducers();
        pullMessages();

        lastSample = instrument.getValue(deltaTime);

        return lastSample;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private void pullMessages()
    {
        if (isStopRequested) {
            for (String note : notesOn) {
                instrument.noteOff(note);
            }
            notesOn.clear();

            return;
        }

        if (producer == null) {
            return;
        }

        for (Message message : producer.pullMessages(lifeTime - producer.getAt())) {
            if (message.isOn()) {
                instrument.noteOn(message.getNote(), 1);
                notesOn.add(message.getNote());
            } else {
                instrument.noteOff(message.getNote());
                notesOn.remove(message.getNote());
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

        if (producers.get(index).getAt() <= lifeTime) {
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

    public void stop()
    {
        isStopRequested = true;
    }

    public void play()
    {
        isStopRequested = false;
    }

    @Override
    public boolean isOver()
    {
        return (isProducersOver() || isStopRequested) && lastSample == 0;
    }

    private boolean isProducersOver()
    {
        return index >= maxIndex && (producer == null || producer.isOver());
    }
}
