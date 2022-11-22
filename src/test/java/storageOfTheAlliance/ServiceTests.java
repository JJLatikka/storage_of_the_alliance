package storageOfTheAlliance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import storageOfTheAlliance.service.ContainerService;
import storageOfTheAlliance.service.ItemService;

public class ServiceTests {

	private ContainerService cS;
	private ItemService iS;

	@BeforeEach
	private void beforeEach() {
		this.cS = new ContainerService();
		this.iS = new ItemService();
	}

	@Test
	public void cSTest() {
		assertThat(cS).isNotNull();
	}

	@Test
	public void iSTest() {
		assertThat(iS).isNotNull();
	}

}
