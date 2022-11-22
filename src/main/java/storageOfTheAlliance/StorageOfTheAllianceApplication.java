package storageOfTheAlliance;

/*
import java.util.Collection;
import org.springframework.boot.CommandLineRunner;
*/
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
import org.springframework.context.annotation.Bean;
import storageOfTheAlliance.domain.entities.AppUser;
import storageOfTheAlliance.domain.entities.Container;
import storageOfTheAlliance.domain.entities.Item;
import storageOfTheAlliance.repositories.AppUserRepo;
import storageOfTheAlliance.repositories.ContainerRepo;
import storageOfTheAlliance.repositories.ItemRepo;
*/

@SpringBootApplication
public class StorageOfTheAllianceApplication {

	public static void main(String[] args) {

		SpringApplication.run(StorageOfTheAllianceApplication.class, args);

	}
	
/*
	@Bean
	public CommandLineRunner cLR(ContainerRepo cR, ItemRepo iR, AppUserRepo aUR) {

		return (args) -> {
	
			
			if (aUR.count() == 0) {
				aUR.save(new AppUser("Jussi", "******", "USER"));
				aUR.save(new AppUser("Miisa", "******", "ADMIN"));
			}

			if (cR.count() == 0) {
				FromLiteToMaria fLTM = new FromLiteToMaria();
				fLTM.containers.keySet().forEach(k -> {
					Container c = new Container(fLTM.containers.get(k));
					c.setSpaceLeft(fLTM.spaceLefts.get(k));
					cR.save(c);
					Collection<String> i = fLTM.items.get(k);
					if (i != null) {
						i.stream().map(s -> new Item(s, c)).forEach(iR::save);
					}
				});
			
			}
			
		};
		
	}
*/
}
