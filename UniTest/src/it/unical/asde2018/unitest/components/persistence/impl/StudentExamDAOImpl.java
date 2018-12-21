package it.unical.asde2018.unitest.components.persistence.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import it.unical.asde2018.unitest.components.persistence.global.AbstractBaseDAO;
import it.unical.asde2018.unitest.components.persistence.global.Student_ExamDAO;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Student_Exam;
import it.unical.asde2018.unitest.model.User;

@Repository
public class StudentExamDAOImpl extends AbstractBaseDAO<Student_Exam, Long> implements Student_ExamDAO {

	public StudentExamDAOImpl() {
		super(Student_Exam.class);
	}

	@Override
	public List<Student_Exam> getAllStudentExam(long examID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student_Exam> getAllStudentExamProf(User user, boolean correct) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		String hql = "";
		if (user.getRoles().iterator().next().getAuthority().equals("ROLE_Professor")) {
//			System.out.println("SEI PROFESSOREEEEE");
			hql = "from Student_Exam WHERE correct = :bool and exam.user.id = :id";

		} 

		Query query = session.createQuery(hql);
		query.setParameter("bool", correct);
		query.setParameter("id", user.getId());
		List<Student_Exam> results = query.list();

		session.close();
		return results;
	}

}
