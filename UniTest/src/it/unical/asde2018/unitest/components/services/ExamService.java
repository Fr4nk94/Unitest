package it.unical.asde2018.unitest.components.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.components.persistence.ExamDAO;
import it.unical.asde2018.unitest.components.persistence.impl.ExamDAOImpl;
import it.unical.asde2018.unitest.components.persistence.impl.QuestionDAOImpl;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Question;

@Service
public class ExamService {
	
	@Autowired
	private ExamDAOImpl examDAO;
	
	@Autowired
	private QuestionDAOImpl questionDAO;
	
	public void insertExam(Exam exam) {
		
		List<Question> questions = exam.getQuestions();
		for (Question question : questions) {
			questionDAO.save(question);
		}
		examDAO.save(exam);
	}
	
	public List<Exam> getAllExams(){
		return examDAO.getAllExams();
	}
	
	
}
