package storageOfTheAlliance.repositories;

import org.springframework.data.repository.CrudRepository;

import storageOfTheAlliance.domain.entities.Container;

public interface ContainerRepo extends CrudRepository<Container, Long> {

}
