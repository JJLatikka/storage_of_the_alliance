package storageOfTheAlliance;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import storageOfTheAlliance.web.ContainerRestController;
import storageOfTheAlliance.web.ItemRestController;

public class RestControllerTests {

	private ContainerRestController cRC;
	private ItemRestController iRC;

	@BeforeEach
	private void beforeEach() {
		this.cRC = new ContainerRestController();
		this.iRC = new ItemRestController();
	}

	@Test
	public void cRCTest() {
		assertThat(cRC).isNotNull();
	}

	@Test
	public void iRCTest() {
		assertThat(iRC).isNotNull();
	}

}
