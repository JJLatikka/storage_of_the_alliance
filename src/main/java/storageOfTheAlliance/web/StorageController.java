package storageOfTheAlliance.web;

import java.util.Objects;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StorageController {

	private String currentUser;

	@RequestMapping("/sign_in")
	public String signIn() {
		return "sign_in";
	}

	@RequestMapping("/storage_of_the_alliance")
	public String storageView(Model m) {
		m.addAttribute("greetings", greetings(getUsername()));
		m.addAttribute("role", getRole());
		return "storage_view";
	}

	@RequestMapping("/sign_out")
	public String signOut() {
		currentUser = null;
		return "sign_in";
	}

	private String getUsername() {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}

	private String greetings(String s) {
		if (!Objects.equals(s, currentUser)) {
			currentUser = s;
			return String.format("Tervetuloa, %s!", s);
		}
		return null;
	}

	private String getRole() {
		return SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
	}

}
