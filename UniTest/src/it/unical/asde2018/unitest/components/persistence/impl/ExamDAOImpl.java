package it.unical.asde2018.unitest.components.persistence.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import it.unical.asde2018.unitest.components.persistence.global.AbstractBaseDAO;
import it.unical.asde2018.unitest.components.persistence.global.ExamDAO;
import it.unical.asde2018.unitest.model.Exam;

// Implementation of ExamDAO, every function that provides exams should be here
@Repository
public class ExamDAOImpl extends AbstractBaseDAO<Exam, Long> implements ExamDAO {

	public ExamDAOImpl() {
		super(Exam.class);
	}

	//	Query for all the exam in DB
	@Override
	public List<Exam> getAllExams() {
		Session session = getCurrentSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			String hql = "from Exam ";
			Query query = session.createQuery(hql);
			List<Exam> exams = query.list();
			tx.commit();
			return exams;
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}

	public List<Exam> getPage(int startPosition,int numberOfExams){
		Session session = getCurrentSession();
		Transaction tx = null;
		try {
			tx=session.beginTransaction();
			String hql = "from Exam";
			Query query = session.createQuery(hql);
			query.setFirstResult(startPosition);
			query.setMaxResults(numberOfExams);
			List<Exam> results = query.list();
			tx.commit();
			return results;

		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return null;
	}
}
