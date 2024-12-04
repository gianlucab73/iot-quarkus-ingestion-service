package it.alten.controller;

import it.alten.dto.response.SensorOutputMessageResponseDTO;
import it.alten.model.SensorOutputMessage;
import it.alten.repository.SensorOutputMessageRepository;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SensorOutputMessageController {
    @Inject
    SensorOutputMessageRepository sensorOutputMessageRepository;

    @GET
    @Path("/all")
    public SensorOutputMessageResponseDTO getAllSensorOutputMessages() {
        List<SensorOutputMessage> sensorOutputMessages = sensorOutputMessageRepository.findAll();

        if(!sensorOutputMessages.isEmpty()) {
            return new SensorOutputMessageResponseDTO(200, "Sensor output messages found", sensorOutputMessages);
        }

        return new SensorOutputMessageResponseDTO(404, "Sensor output messages not found", null);
    }

    @GET
    @Path("/serialNumber/{serialNumber}")
    public SensorOutputMessageResponseDTO getSensorOutputMessages(@PathParam("serialNumber") String serialNumber) {
        List<SensorOutputMessage> sensorOutputMessages = sensorOutputMessageRepository.findByIdSerialNumber(serialNumber);

        if(!sensorOutputMessages.isEmpty()) {
            return new SensorOutputMessageResponseDTO(200, "Sensor output messages found", sensorOutputMessages);
        }

        return new SensorOutputMessageResponseDTO(404, "Sensor output messages not found", null);
    }
}
