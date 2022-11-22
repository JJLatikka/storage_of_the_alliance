package storageOfTheAlliance.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storageOfTheAlliance.domain.dtos.ContainerDTO;
import storageOfTheAlliance.domain.dtos.DTO;
import storageOfTheAlliance.service.ContainerService;

@RestController
@RequestMapping("/containers")
public class ContainerRestController {

	@Autowired
	private ContainerService cS;

	@GetMapping
	public List<ContainerDTO> all() {
		return cS.all();
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public DTO add(@RequestBody @Valid ContainerDTO cDTO, BindingResult bR) {
		if (!bR.hasErrors()) {
			cS.add(cDTO);
		} else {
			cDTO.setAlert("Säilön nimi ei voi olla tyhjä!");
		}
		return cDTO;
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping
	public void edit(@RequestBody ContainerDTO cDTO) {
		cS.edit(cDTO);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping
	public DTO delete(@RequestBody ContainerDTO cDTO) {
		if (cDTO.getEmpty()) {
			cS.delete(cDTO);
		} else {
			cDTO.setAlert("Vain tyhjän säilön voi poistaa!");
		}
		return cDTO;
	}

}
