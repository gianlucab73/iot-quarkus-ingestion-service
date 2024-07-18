package it.alten.repository;

import it.alten.model.SensorOutputMessage;
import it.alten.model.id.SensorOutputMessageId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorOutputMessageRepository extends CrudRepository<SensorOutputMessage, SensorOutputMessageId> {
}
