package it.unical.asde2018.unitest.components.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.model.Answer;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Exam_Type;
import it.unical.asde2018.unitest.model.Question;

@Service
public class ExamService {

	private static int currentID = 0;
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
	
	public int getCurrentExamID() {
		return currentID;
	}
	
	public void createExam(String examName, Exam_Type examType, List<Question> questions, List<Answer> answers, boolean isAvailable) {
		// TODO
		Exam e = new Exam(getNextExamID(), examName, examType, questions, new Date(), isAvailable);
		
		exams.put(e.getId(), e);
		
		System.out.println("EXAMSERVICE, EXAM CREATED "+e);
	}
	
	public void addQuestion(Question q, Exam e) {
		//TODO 
		exams.get(e.getId()).addQuestion(q);
	}
	
	public int getNextQuestionID(int examID) {
		return exams.get(examID).getQuestions().size();
	}
	
	public Exam getExamByID(int examID) {
		return exams.get(examID);
	}
	
}
