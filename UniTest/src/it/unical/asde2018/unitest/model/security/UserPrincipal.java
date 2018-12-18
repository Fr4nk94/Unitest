package it.unical.asde2018.unitest.model.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserPrincipal extends User {

	private it.unical.asde2018.unitest.model.User user;

	public it.unical.asde2018.unitest.model.User getUser() {
		return user;
	}

	public void setUser(it.unical.asde2018.unitest.model.User user) {
		this.user = user;
	}

	public UserPrincipal(it.unical.asde2018.unitest.model.User user,
			Collection<? extends GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword(), authorities);
		this.user = user;
	}

	public UserPrincipal(it.unical.asde2018.unitest.model.User user, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired,
				accountNonLocked, authorities);
		this.user = user;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
