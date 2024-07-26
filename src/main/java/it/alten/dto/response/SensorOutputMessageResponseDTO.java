package it.alten.dto.response;

import it.alten.model.SensorOutputMessage;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SensorOutputMessageResponseDTO {
    private int code;
    private String message;
    private List<SensorOutputMessage> data;
}
