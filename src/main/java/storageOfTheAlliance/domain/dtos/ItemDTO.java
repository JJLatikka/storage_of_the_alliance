package storageOfTheAlliance.domain.dtos;

public class ItemDTO {

	private Long id;
	private String name;
	private Boolean removed;
	private Long containerId;

	public ItemDTO(Long id, String s, Boolean b, Long l) {
		this.id = id;
		this.name = s;
		this.removed = b;
		this.containerId = l;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getRemoved() {
		return removed;
	}

	public void setRemoved(Boolean b) {
		this.removed = b;
	}

	public Long getContainerId() {
		return containerId;
	}

	public void setContainerId(Long l) {
		this.containerId = l;
	}

	@Override
	public String toString() {
		return String.format("ItemDTO{ name: %s, removed: %s, containderId: %s }", name, removed, containerId);
	}

}
