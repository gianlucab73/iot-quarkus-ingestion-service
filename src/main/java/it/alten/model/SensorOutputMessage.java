package it.alten.model;

import it.alten.model.id.SensorOutputMessageId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "sensor_output_message")
public class SensorOutputMessage {
    @EmbeddedId
    private SensorOutputMessageId id;

    @Column(nullable = false)
    private double data;
}
