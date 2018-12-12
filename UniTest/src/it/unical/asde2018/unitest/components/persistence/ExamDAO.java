package it.unical.asde2018.unitest.components.persistence;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Exam_Type;
import it.unical.asde2018.unitest.model.Question;
import it.unical.asde2018.unitest.model.Question_Type;

@Repository
public class ExamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@PostConstruct
	public void init() throws ParseException {

		DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
		Date d1;
		d1 = df.parse("12-12-2018");
		Exam fondamenti = new Exam(1, "1", "Fondamenti", d1, true, Exam_Type.MIXED);

		List<Question> l1 = new ArrayList<>();
		Question q1 = new Question(5, "Wich is your favorite team?", Question_Type.OPEN_ANSWER, 1_000.0f, 1_000.0f);
		l1.add(q1);
		fondamenti.setQuestions(l1);

		save(fondamenti);
		save(new Exam(2, "2", "Oggetti", d1, true, Exam_Type.MIXED));
		save(new Exam(3, "3", "Analisi", d1, true, Exam_Type.MIXED));
		save(new Exam(4, "4", "SIW", d1, true, Exam_Type.MIXED));

	}

	public void save(Exam exam) {
		Session session = sessionFactory.openSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(exam);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
		}
		session.close();
	}

	public List<Exam> getAllExams() {

		Session session = sessionFactory.openSession();
		List<Exam> exams = null;
		try {
			exams = session.createQuery("from Exam e", Exam.class).getResultList();
			// System.out.println("exams" + exams);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		session.close();
		return exams;
	}

}
