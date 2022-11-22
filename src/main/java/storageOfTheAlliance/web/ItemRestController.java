package storageOfTheAlliance.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import storageOfTheAlliance.domain.dtos.ItemDTO;
import storageOfTheAlliance.service.ItemService;

@RestController
@RequestMapping("/items")
public class ItemRestController {

	@Autowired
	private ItemService iS;

	@GetMapping("/{cId}")
	public List<ItemDTO> fromContainer(@PathVariable Long cId) {
		return iS.fromContainer(cId);
	}

	@GetMapping("/'{s}'")
	public List<ItemDTO> nameLikeStr(@PathVariable String s) {
		return iS.nameLikeStr(s);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PostMapping
	public void add(@RequestBody List<ItemDTO> l) {
		iS.add(l);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@PutMapping
	public void edit(@RequestBody ItemDTO iDTO) {
		iS.edit(iDTO);
	}

	@PreAuthorize("hasAuthority('ADMIN')")
	@DeleteMapping
	public void delete(@RequestBody ItemDTO iDTO) {
		iS.delete(iDTO);
	}

}
