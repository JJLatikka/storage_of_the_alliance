package storageOfTheAlliance.repositories;

import org.springframework.data.repository.CrudRepository;

import storageOfTheAlliance.domain.entities.AppUser;

public interface AppUserRepo extends CrudRepository<AppUser, Long> {

	public AppUser findByUsername(String uN);

}
