package it.alten;

import io.quarkus.runtime.StartupEvent;
import it.alten.mapper.SensorOutputMessageMapper;
import it.alten.model.SensorOutputMessage;
import it.alten.repository.SensorOutputMessageRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
public class KafkaConsumer {
    @Inject
    SensorOutputMessageRepository sensorOutputMessageRepository;

    @Inject
    EntityManager entityManager;

    @Incoming("kafka-channel-in")
    public void consume(String message) {
        SensorOutputMessage sensorOutputMessage = new SensorOutputMessageMapper().readValue(message);
        sensorOutputMessage.prePersist();

        sensorOutputMessageRepository.save(sensorOutputMessage);

        System.out.println("Deserialized message: " + sensorOutputMessage);
    }

    void onStart(@Observes StartupEvent ev) {
        entityManager.createNativeQuery("SELECT create_hypertable('sensor_output_message', 'timestamp', if_not_exists => TRUE);").getSingleResult();
    }
}