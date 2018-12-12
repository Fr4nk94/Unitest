package it.unical.asde2018.unitest.components.persistence;

import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.unical.asde2018.unitest.model.User;

@Repository
public class UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@PostConstruct
	public void init() {
		save(new User(1, "a", "a", "askkd@hotmail.it", "a", "a", "Student"));
		save(new User(2, "b", "b", "bjoakk@hotmail.it", "b", "b", "Professor"));
		save(new User(3, "c", "c", "cffg@hotmail.it", "c", "c", "Student"));
	}

	public void save(User user) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(user);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		}
		session.close();

	}

	public boolean exists(User user) {
		Session openSession = sessionFactory.openSession();
		Query<User> query = openSession
				.createQuery("from User as user where user.username=:u and user.password=:p", User.class)
				.setParameter("u", user.getUsername()).setParameter("p", user.getPassword());

		boolean result = query.uniqueResult() != null;

		openSession.close();
		return result;
	}

	public boolean yetAnUser(String username) {
		Session session = sessionFactory.openSession();

		Query<User> query = session.createQuery("from User as user where user.username=:u", User.class)
				.setParameter("u", username);

		boolean result = query.uniqueResult() != null;

		return result;
	}

	public List<User> getAllExistentUsers() {

		Session session = sessionFactory.openSession();
		List<User> users = null;
		try {
			users = session.createQuery("from User u", User.class).getResultList();
			// System.out.println("users" + users);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		session.close();
		return users;
	}

	public User getUser(String username) {
		Session session = sessionFactory.openSession();
		User user = null;
		try {
			user = session.createQuery("from User u where u.username=:username", User.class)
					.setParameter("username", username).getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		session.close();
		return user;
	}

}
