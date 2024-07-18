package it.alten.model.id;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class SensorOutputMessageId implements Serializable {
    private String serialNumber;
    private Instant timestamp;
}