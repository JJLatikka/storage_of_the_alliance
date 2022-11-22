package storageOfTheAlliance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import storageOfTheAlliance.domain.dtos.ItemDTO;
import storageOfTheAlliance.domain.entities.Container;
import storageOfTheAlliance.domain.entities.Item;
import storageOfTheAlliance.repositories.ContainerRepo;
import storageOfTheAlliance.repositories.ItemRepo;

@Component
public class ItemService {

	@Autowired
	ItemRepo iRepo;

	@Autowired
	ContainerRepo cRepo;

	public List<ItemDTO> fromContainer(Long id) {
		return cRepo.findById(id).get().getItems().stream().map(this::toDTO).toList();
	}

	public List<ItemDTO> nameLikeStr(String s) {
		return ((List<Item>) iRepo.findAll()).stream().filter(i -> i.getName().toLowerCase().contains(s.toLowerCase()))
				.map(this::toDTO).toList();
	}

	public void add(List<ItemDTO> l) {
		l.stream().map(iDTO -> new Item(iDTO.getName(), findC(iDTO.getContainerId()))).forEach(iRepo::save);
	}

	public void edit(ItemDTO iDTO) {
		iRepo.save(toEnt(iDTO));
	}

	public void delete(ItemDTO iDTO) {
		iRepo.deleteById(iDTO.getId());
	}

	private ItemDTO toDTO(Item i) {
		return new ItemDTO(i.getIid(), i.getName(), i.getRemoved(), i.getContainer().getCid());
	}

	private Item toEnt(ItemDTO iDTO) {
		return new Item(iDTO.getId(), iDTO.getName(), iDTO.getRemoved(), findC(iDTO.getContainerId()));
	}

	private Container findC(Long id) {
		return cRepo.findById(id).get();
	}

}
