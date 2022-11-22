package storageOfTheAlliance.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private Long uid;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(name = "passwd", nullable = false)
	private String passHash;

	@Column(name = "rol", nullable = false)
	private String role;

	@Transient
	private PasswordEncoder pE = new BCryptPasswordEncoder();

	public AppUser() {
	}

	public AppUser(String uN, String pW, String r) {
		this.username = uN;
		this.passHash = pE.encode(pW);
		this.role = r;
	}

	public Long getId() {
		return uid;
	}

	public void setId(Long l) {
		this.uid = l;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String uN) {
		this.username = uN;
	}

	public String getPassHash() {
		return passHash;
	}

	public void setPassHash(String pH) {
		this.passHash = pH;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String r) {
		this.role = r;
	}

	@Override
	public String toString() {
		return String.format("AppUser{ name: %s, password: %s, role: %s }", username, passHash, role);
	}

}
