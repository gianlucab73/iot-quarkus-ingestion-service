package it.alten.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import it.alten.model.SensorOutputMessage;
import it.alten.model.id.SensorOutputMessageId;

import java.time.Instant;

public class SensorOutputMessageMapper extends ObjectMapper {
    public SensorOutputMessageMapper() {
        super();
        super.registerModule(new JavaTimeModule());
    }

    public SensorOutputMessage readValue(String content) {
        try {
            JsonNode jsonNode = this.readTree(content);
            String serialNumber = jsonNode.get("serial_number").asText();
            Instant timestamp = Instant.parse(jsonNode.get("timestamp").asText());
            SensorOutputMessageId sensorOutputMessageId = new SensorOutputMessageId(serialNumber, timestamp);
            double data = jsonNode.get("data").asDouble();

            SensorOutputMessage sensorOutputMessage = new SensorOutputMessage();
            sensorOutputMessage.setId(sensorOutputMessageId);
            sensorOutputMessage.setData(data);

            return sensorOutputMessage;
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing message: " + e.getMessage());
        }
    }
}
