package it.unical.asde2018.unitest.components.persistence.global;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

public abstract class AbstractBaseDAO<T, X extends Serializable> {

	@Autowired
	protected SessionFactory sessionFactory;

	private Class<T> tClass;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Class<T> gettClass() {
		return tClass;
	}

	public void settClass(Class<T> tClass) {
		this.tClass = tClass;
	}

	public AbstractBaseDAO(Class<T> tClass) {
		this.tClass = tClass;
	}

	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public void save(T object) {
		Session session = getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
//			session.persist(object);
			session.save(object);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
	}

	public T getById(X id) {
		Session session = getCurrentSession();
		Transaction tx = null;
		T entitity = null;
		try {
			tx = session.beginTransaction();
			entitity = session.get(gettClass(), id);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
		return entitity;
	}

	public void update(T object) {
		Session session = getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.update(object);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
	}

	public void delete(T object) {
		Session session = getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.delete(object);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
	}

	public void deleteById(X id) {
		T entity = getById(id);
		delete(entity);
	}

	public void saveOrUpdate(T object) {
		Session session = getCurrentSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(object);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		session.close();
	}

	public List<T> getAll() {

		return (List<T>) getCurrentSession().createQuery("from " + gettClass()).list();
//
//		Session session = sessionFactory.getCurrentSession();
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<T> query = builder.createQuery(tClass);
//		Root<T> root = query.from(tClass);
//		query.select(root);
//		Query<T> q = session.createQuery(query);
//		return q.getResultList();
	}

}
