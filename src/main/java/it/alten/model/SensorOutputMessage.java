package it.alten.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class SensorOutputMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonProperty("serial_number")
    @Column(nullable = false)
    private String serialNumber;
    @JsonProperty("data")
    @Column(nullable = false)
    private double data;
    @JsonProperty("timestamp")
    @Column(nullable = false)
    private LocalDateTime timestamp;
}
