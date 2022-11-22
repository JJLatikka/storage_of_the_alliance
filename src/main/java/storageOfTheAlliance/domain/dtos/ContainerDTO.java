package storageOfTheAlliance.domain.dtos;

import javax.validation.constraints.NotEmpty;

public class ContainerDTO extends DTO {

	private Long id;

	@NotEmpty
	private String name;

	private Boolean spaceLeft;
	private Boolean empty;

	public ContainerDTO(Long l, String s, Boolean sL, Boolean e) {
		super(null);
		this.id = l;
		this.name = s;
		this.spaceLeft = sL;
		this.empty = e;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long l) {
		this.id = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String s) {
		this.name = s;
	}

	public Boolean getSpaceLeft() {
		return spaceLeft;
	}

	public void setSpaceLeft(Boolean b) {
		this.spaceLeft = b;
	}

	public Boolean getEmpty() {
		return empty;
	}

	public void setEmpty(Boolean b) {
		this.empty = b;
	}

	@Override
	public String toString() {
		return String.format("ContainerDTO{ name: %s, space_left: %s, empty: %s}", name, spaceLeft, empty);
	}

}
