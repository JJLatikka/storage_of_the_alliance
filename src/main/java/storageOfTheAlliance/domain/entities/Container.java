package storageOfTheAlliance.domain.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Container {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cid;

	@Column(unique = true)
	private String name;

	private Boolean spaceLeft;

	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "container")
	private List<Item> items;

	public Container() {
	}

	public Container(String s) {
		this.name = s;
		this.spaceLeft = true;
	}

	public Container(Long l, String s, Boolean sL) {
		this.cid = l;
		this.name = s;
		this.spaceLeft = sL;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long l) {
		this.cid = l;
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

	public Boolean empty() {
		return items != null ? items.isEmpty() : true;
	}

	public List<Item> getItems() {
		return items;
	}

	@Override
	public String toString() {
		return String.format("Container{ name: %s, space_left: %s, empty: %s }", name, spaceLeft, empty());
	}

}
