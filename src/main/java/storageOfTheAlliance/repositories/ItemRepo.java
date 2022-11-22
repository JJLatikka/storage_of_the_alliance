package storageOfTheAlliance.repositories;

import org.springframework.data.repository.CrudRepository;

import storageOfTheAlliance.domain.entities.Item;

public interface ItemRepo extends CrudRepository<Item, Long> {

}
