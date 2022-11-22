package storageOfTheAlliance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import storageOfTheAlliance.domain.entities.Container;
import storageOfTheAlliance.repositories.ContainerRepo;
import storageOfTheAlliance.repositories.ItemRepo;

@SpringBootTest
public class ContainerRepoTests {

	@Autowired
	private ContainerRepo cR;
	
	@Autowired
	private ItemRepo iR;

	private List<Container> cL = setCL();
	private Container c = cL.get(0);

	@BeforeEach
	private void beforeEach() {
		iR.deleteAll();
		cR.deleteAll();
	}
	
	@AfterEach
	private void afterEach() {
		cR.deleteAll();
	}

	@Test
	public void findAll() {
		cL.forEach(cR::save);
		assertEquals(cR.count(), 3);
	}
	
	@Test
	public void save() {
		Long l = cR.save(c).getCid();
		assertEquals(cR.findById(l).get().getName(), "T1");
	}

	@Test
	public void delete() {
		Long l = cR.save(c).getCid();
		cR.deleteById(l);
		assertEquals(cR.count(), 0);
	}

	private List<Container> setCL() {
		return Arrays.asList(new String[] { "T1", "T2", "T3" }).stream().map(s -> new Container(s)).toList();
	}

}
