package it.alten;

import it.alten.mapper.SensorOutputMessageMapper;
import it.alten.model.SensorOutputMessage;
import it.alten.repository.SensorOutputMessageRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaConsumer {
    @Inject
    SensorOutputMessageRepository sensorOutputMessageRepository;

    @Incoming("kafka-channel-in")
    public void consume(String message) {
        SensorOutputMessage sensorOutputMessage = new SensorOutputMessageMapper().readValue(message);

        sensorOutputMessageRepository.save(sensorOutputMessage);

        System.out.println("Deserialized message: " + sensorOutputMessage);
    }
}