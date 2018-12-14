package it.unical.asde2018.unitest.components.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import it.unical.asde2018.unitest.components.persistence.UserDetailsDao;
import it.unical.asde2018.unitest.model.Role;
import it.unical.asde2018.unitest.model.User;
import it.unical.asde2018.unitest.model.security.UserPrincipal;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDetailsDao userDetailsDao;

	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userDetailsDao.findUserByUsername(username);
//		UserBuilder builder = null;
		UserPrincipal principal = null;
		if (user != null) {
//			builder = org.springframework.security.core.userdetails.User.withUsername(username);
//			builder.disabled(!user.isEnabled());
//			builder.password(user.getPassword());
			List<String> authorities = user.getRoles().stream().map(a -> a.getAuthority()).collect(Collectors.toList());
//
//			builder.authorities(authorities);
			principal = new UserPrincipal(user, user.isEnabled(), true, true, true, getAuthorities(authorities));
		} else {
			throw new UsernameNotFoundException("User not found.");
		}
//		return builder.build();
		return principal;
	}

	private List<GrantedAuthority> getAuthorities(List<String> roles) {
		return roles.stream().map(r -> new SimpleGrantedAuthority(r)).collect(Collectors.toList());
	}

	@PostConstruct
	public void init() {
		User a = new User();
		String encoded = new BCryptPasswordEncoder().encode("mano");

		a.setEnabled(true);
		a.setPassword(encoded);
		a.setUsername("mano");

		Role au = new Role();
		au.setAuthority("ROLE_Student");
		Set<Role> authorities = new HashSet<>();
		authorities.add(au);
		a.setRoles(authorities);
		au.setUser(a);
		
		User den = new User();
		String psw = new BCryptPasswordEncoder().encode("den");
		
		den.setEnabled(true);
		den.setPassword(psw);
		den.setUsername("den");
		
		Role prof = new Role();
		prof.setAuthority("ROLE_Professor");
		Set<Role> authorities1 = new HashSet<>();
		authorities1.add(prof);
		den.setRoles(authorities1);
		prof.setUser(den);

		userDetailsDao.save(a);
		userDetailsDao.save(den);

	}

}
