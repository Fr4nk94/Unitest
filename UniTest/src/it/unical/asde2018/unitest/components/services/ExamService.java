package it.unical.asde2018.unitest.components.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.model.Answer;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Question;
import it.unical.asde2018.unitest.model.User;

@Service
public class ExamService {

	private static int currentID = 0;
	
	// K = ID, V = exam
	private HashMap<Integer, Exam> exams;
	
	
	//TODO method created only or testing purposes
	public void printExam(int examID) {
		Exam e = exams.get(examID);
		
		System.out.println(e);
	}
	
	
	@PostConstruct
	public void init() {
		exams = new HashMap<>(); 
	}
	
	public int getNextExamID() {
		return ++currentID;
	}
	
	public int getExamID(Exam e) {
		return e.getInternalID();
	}
	
	public Exam createExam(User professor, String examName, List<Question> questions, List<Answer> answers, boolean isAvailable) {
		// TODO
		Exam e = new Exam(professor, examName, new Date());
	
		
		e.setInternalID(getNextExamID());
		
		
		//exams.put(professor, new Ha)
		exams.put(e.getInternalID(), e);
		
		System.out.println("EXAMSERVICE, EXAM CREATED "+e);
		
		
		return e;
	}
	
//	public void addQuestion(Question q, Exam e) {
//		//TODO 
//		exams.get(e.getId()).addQuestion(q);
//	}
	
		
	public Exam getExamByID(int examID) {
		return exams.get(examID);
	}
	
}
