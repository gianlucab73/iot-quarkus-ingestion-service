package it.alten.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class SensorOutputMessage {
    @JsonProperty("serial_number")
    private String serialNumber;
    @JsonProperty("data")
    private double data;
}
