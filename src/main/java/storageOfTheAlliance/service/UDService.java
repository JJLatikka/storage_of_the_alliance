package storageOfTheAlliance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import storageOfTheAlliance.domain.entities.AppUser;
import storageOfTheAlliance.repositories.AppUserRepo;

@Service
public class UDService implements UserDetailsService {

	@Autowired
	private AppUserRepo aUR;

	@Override
	public UserDetails loadUserByUsername(String uN) throws UsernameNotFoundException {
		AppUser aU = aUR.findByUsername(uN);
		UserDetails d = new org.springframework.security.core.userdetails.User(uN, aU.getPassHash(),
				AuthorityUtils.createAuthorityList(aU.getRole()));
		return d;
	}

}
