package it.alten.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import it.alten.model.id.SensorOutputMessageId;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;

@Entity
@Data
@Table(name = "sensor_output_message")
public class SensorOutputMessage {
    @EmbeddedId
    private SensorOutputMessageId id;

    @JsonProperty("serial_number")
    @Transient  // This field is not part of the table
    private String serialNumber;
    @JsonProperty("timestamp")
    @Transient  // This field is not part of the table
    private Instant timestamp;

    @JsonProperty("data")
    @Column(nullable = false)
    private double data;


    public void prePersist() {
        this.id = new SensorOutputMessageId(this.serialNumber, this.timestamp);
    }
}
