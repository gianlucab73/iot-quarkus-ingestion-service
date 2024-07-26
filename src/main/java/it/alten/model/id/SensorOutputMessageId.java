package it.alten.model.id;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class SensorOutputMessageId implements Serializable {
    private String serialNumber;
    private Instant timestamp;
}