package it.alten;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.alten.model.SensorOutputMessage;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaConsumer {
    @Incoming("kafka-channel-in")
    public void consume(String message) {
        try {
            SensorOutputMessage sensorOutputMessage = new ObjectMapper().readValue(message, SensorOutputMessage.class);
            System.out.println("Deserialized message: " + sensorOutputMessage);
        } catch (Exception e) {
            System.out.println("Error deserializing message: " + e.getMessage());
        }
    }
}