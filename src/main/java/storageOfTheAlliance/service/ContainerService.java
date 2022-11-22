package storageOfTheAlliance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import storageOfTheAlliance.domain.dtos.ContainerDTO;
import storageOfTheAlliance.domain.entities.Container;
import storageOfTheAlliance.repositories.ContainerRepo;

@Component
public class ContainerService {

	@Autowired
	private ContainerRepo cRepo;

	public List<ContainerDTO> all() {
		return ((List<Container>) cRepo.findAll()).stream().map(this::toDTO).toList();
	}

	public void add(ContainerDTO cDTO) {
		cRepo.save(new Container(cDTO.getName()));
	}

	public void edit(ContainerDTO cDTO) {
		cRepo.save(toEnt(cDTO));
	}

	public void delete(ContainerDTO cDTO) {
		cRepo.deleteById(cDTO.getId());
	}

	private ContainerDTO toDTO(Container c) {
		return new ContainerDTO(c.getCid(), c.getName(), c.getSpaceLeft(), c.empty());
	}

	private Container toEnt(ContainerDTO cDTO) {
		return new Container(cDTO.getId(), cDTO.getName(), cDTO.getSpaceLeft());
	}

}
