package it.unical.asde2018.unitest.components.persistence.impl;

import org.hibernate.Session;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import it.unical.asde2018.unitest.components.persistence.UserDetailsDao;
import it.unical.asde2018.unitest.components.persistence.global.AbstractBaseDAO;
import it.unical.asde2018.unitest.model.User;

@Repository
public class UserDetailsDaoImpl extends AbstractBaseDAO<User, Long> implements UserDetailsDao {

	public UserDetailsDaoImpl() {
		super(User.class);
	}

	@Override
	public User findUserByUsername(String username) {
		Session openSession = sessionFactory.openSession();
		Query<User> query = openSession.createQuery("from User as u where u.username=:n", User.class).setParameter("n",
				username);

		User result = query.uniqueResult();
		openSession.close();
		return result;
	}

}
