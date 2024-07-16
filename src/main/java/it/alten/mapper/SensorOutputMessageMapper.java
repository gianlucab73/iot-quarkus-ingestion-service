package it.alten.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import it.alten.model.SensorOutputMessage;

public class SensorOutputMessageMapper extends ObjectMapper {
    public SensorOutputMessageMapper() {
        super();
        super.registerModule(new JavaTimeModule());
    }

    public SensorOutputMessage readValue(String content) {
        try {
            return super.readValue(content, SensorOutputMessage.class);
        } catch (Exception e) {
            throw new RuntimeException("Error deserializing message: " + e.getMessage());
        }
    }
}
