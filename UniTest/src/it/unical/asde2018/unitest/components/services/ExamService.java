package it.unical.asde2018.unitest.components.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.components.persistence.global.ExamDAO;
import it.unical.asde2018.unitest.model.Answer;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Question;
import it.unical.asde2018.unitest.model.Question_Type;
import it.unical.asde2018.unitest.model.User;

@Service
public class ExamService {

	private static int currentID = 0;

	@Autowired
	private ExamDAO examDAO;

	// K = InternalID, V = exam
	private HashMap<Integer, Exam> exams;

	// TODO method created only or testing purposes
	public void printExam(int examID) {
		Exam e = exams.get(examID);

		System.out.println(e);
	}

	@PostConstruct
	public void init() {
		exams = new HashMap<>(); 
		Answer a1= new Answer("ciccio", false);
		Answer a2= new Answer("pluto", false);
		Answer a3= new Answer("paperino", false);
		Question q1= new Question("chi sei?", Question_Type.SINGLE_CHOICE, 5, 0);
		q1.addAnswer(a1);
		q1.addAnswer(a2);
		q1.addAnswer(a3);
		Answer a4= new Answer("ciccio", false);
		Answer a5= new Answer("pluto", false);
		Answer a6= new Answer("paperino", false);
		Question q2= new Question("chi sei?", Question_Type.MULTIPLE_CHOICE, 5, 0);
		q2.addAnswer(a4);
		q2.addAnswer(a5);
		q2.addAnswer(a6);
		Question q3= new Question("chi sei?", Question_Type.ATTACH_FILE, 5, 0);
		User user = new User();
		user.setFullName("Pippo il grande");
		Exam exam1= new Exam(user, "primo Esame", new Date(), (float) 3.5);
		examDAO.save(exam1);
		q1.setExam(exam1);
		q2.setExam(exam1);
		q3.setExam(exam1);
		exam1.addQuestion(q1);
		exam1.addQuestion(q2);
		exam1.addQuestion(q3);
		examDAO.update(exam1);
		
		Exam exam2= new Exam(user, "secondo Esame", new Date(), (float) 2);
		examDAO.save(exam2);
		q1.setExam(exam2);
		q2.setExam(exam2);
		q3.setExam(exam2);
		exam2.addQuestion(q1);
		exam2.addQuestion(q2);
		exam2.addQuestion(q3);
		examDAO.update(exam2);
		
	}

	public int getNextExamID() {
		return ++currentID;
	}

	public int getExamID(Exam e) {
		return e.getInternalID();
	}
	
	public Exam getExamByInternalID(int internalID) {
		return exams.get(internalID);
	}
	
	
	public Exam createExam(User professor, String examName, List<Question> questions, List<Answer> answers, boolean isAvailable, float timeAvailable) {
		
		Exam e = new Exam(professor, examName, new Date(), timeAvailable);

		e.setInternalID(getNextExamID());

		exams.put(e.getInternalID(), e);

		System.out.println("EXAMSERVICE, EXAM CREATED " + e);

		return e;
	}

	public Exam getExamByID(int examID) {
		return examDAO.getById((long)examID);
	}

	public void storeExam(Exam exam) {
		examDAO.save(exam);
	}

	public List<Exam> getAllExams() {
		return examDAO.getAllExams();
	}
	
	public List<Exam> getAPage(int pageNumber,int numExams){
		int sPos = (pageNumber-1)*numExams;
		return examDAO.getPage(sPos,numExams);
	}
}
