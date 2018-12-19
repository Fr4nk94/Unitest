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
		List<Exam> exams = null;
		try {
			tx=session.beginTransaction();
			String hql = "from Exam ";
			Query<Exam> query = session.createQuery(hql);
			exams = query.list();
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return exams;
	}
	
	public List<Exam> getPage(int startPosition,int numberOfExams){
		Session session = getCurrentSession();
		Transaction tx = null;
		List<Exam> results = null;
		try {
			tx=session.beginTransaction();
			String hql = "from Exam";
			Query<Exam> query = session.createQuery(hql);
			query.setFirstResult(startPosition);
			query.setMaxResults(numberOfExams);
			results = query.list();
			tx.commit();
		}
		catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		return results;
	}
}
