package storageOfTheAlliance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import storageOfTheAlliance.domain.entities.Item;
import storageOfTheAlliance.repositories.ItemRepo;

@SpringBootTest
public class ItemRepoTests {

	@Autowired
	private ItemRepo iR;

	private List<Item> iL = setIL();
	private Item i = iL.get(0);

	@BeforeEach
	private void beforeEach() {
		iR.deleteAll();
	}

	@AfterEach
	private void afterEach() {
		iR.deleteAll();
	}

	@Test
	public void findAll() {
		iL.forEach(iR::save);
		assertEquals(iR.count(), 3);
	}

	@Test
	public void save() {
		Long l = iR.save(i).getIid();
		assertEquals(iR.findById(l).get().getName(), "t1");
	}

	@Test
	public void delete() {
		Long l = iR.save(i).getIid();
		iR.deleteById(l);
		assertEquals(iR.count(), 0);
	}

	private List<Item> setIL() {
		return Arrays.asList(new String[] { "t1", "t2", "t3" }).stream().map(s -> new Item(s)).toList();
	}

}
