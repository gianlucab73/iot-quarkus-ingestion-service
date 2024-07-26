package it.alten;

import io.quarkus.runtime.StartupEvent;
import it.alten.mapper.SensorOutputMessageMapper;
import it.alten.model.SensorOutputMessage;
import it.alten.repository.SensorOutputMessageRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import java.util.logging.Logger;

@ApplicationScoped
public class IotQuarkusSensorDataIngestionServiceApplication {
    private final Logger LOGGER = Logger.getLogger(IotQuarkusSensorDataIngestionServiceApplication.class.getName());

    @Inject
    SensorOutputMessageRepository sensorOutputMessageRepository;

    @Incoming("kafka-channel-in")
    public void consume(String message) {
        SensorOutputMessage sensorOutputMessage = new SensorOutputMessageMapper().readValue(message);

        sensorOutputMessageRepository.save(sensorOutputMessage);
    }

    void onStart(@Observes StartupEvent ev) {
        try {
            sensorOutputMessageRepository.createHypertable();
        } catch (Exception e) {
            LOGGER.warning("Error creating hypertable: " + e.getMessage());
        }
    }
}