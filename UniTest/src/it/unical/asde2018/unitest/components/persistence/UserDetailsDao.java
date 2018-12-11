package it.unical.asde2018.unitest.components.persistence;

import it.unical.asde2018.unitest.components.persistence.global.BaseDAO;
import it.unical.asde2018.unitest.model.User;

public interface UserDetailsDao extends BaseDAO<User, Long> {

	public User findUserByUsername(String username);

}
