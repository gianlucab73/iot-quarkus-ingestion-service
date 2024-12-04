package it.alten.repository;

import it.alten.model.SensorOutputMessage;
import it.alten.model.id.SensorOutputMessageId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorOutputMessageRepository extends CrudRepository<SensorOutputMessage, SensorOutputMessageId> {
    @Query(value="SELECT create_hypertable('sensor_output_message', 'timestamp')")
    Object createHypertable();

    List<SensorOutputMessage> findAll();

//    @Query(value="SELECT s.id.timestamp, s.data FROM SensorOutputMessage s WHERE s.id.serialNumber = :serialNumber")
    List<SensorOutputMessage> findByIdSerialNumber(String serialNumber);
}
