package storageOfTheAlliance.domain.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long iid;

	private String name;
	private Boolean removed;

	@ManyToOne
	@JoinColumn(name = "cid")
	private Container container;

	public Item() {
	}

	public Item(String s) {
		this.name = s;
		this.removed = false;
	}

	public Item(String s, Container c) {
		this(s);
		this.container = c;
	}

	public Item(Long l, String s, Boolean b, Container c) {
		this.iid = l;
		this.name = s;
		this.removed = b;
		this.container = c;
	}

	public Long getIid() {
		return iid;
	}

	public void setIid(Long l) {
		this.iid = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String s) {
		this.name = s;
	}

	public Boolean getRemoved() {
		return removed;
	}

	public void setRemoved(Boolean b) {
		this.removed = b;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container c) {
		this.container = c;
	}

	@Override
	public String toString() {
		return String.format("Item{ name: %s, removed: %s }", name, removed);
	}

}
