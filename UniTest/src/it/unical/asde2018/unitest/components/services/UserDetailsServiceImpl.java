package it.unical.asde2018.unitest.components.services;

import java.util.HashSet;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.unical.asde2018.unitest.components.persistence.UserDetailsDao;
import it.unical.asde2018.unitest.model.Authorities;
import it.unical.asde2018.unitest.model.User;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDetailsDao.findUserByUsername(username);
		UserBuilder builder = null;
		if (user != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.disabled(!user.isEnabled());
			builder.password(user.getPassword());
			String[] authorities = user.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new);

			builder.authorities(authorities);
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
		return builder.build();
	}

	@PostConstruct
	public void init() {
		User a = new User();
		String encoded = new BCryptPasswordEncoder().encode("mano");

		a.setEnabled(true);
		a.setPassword(encoded);
		a.setUsername("mano");

		Authorities au = new Authorities();
		au.setAuthority("ROLE_Student");
		Set<Authorities> authorities = new HashSet<>();
		authorities.add(au);
		a.setAuthorities(authorities);
		au.setUser(a);
		
		userDetailsDao.save(a);

	}

}
