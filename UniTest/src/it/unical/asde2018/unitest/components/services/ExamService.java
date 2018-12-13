package it.unical.asde2018.unitest.components.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.components.persistence.global.ExamDAO;
import it.unical.asde2018.unitest.components.persistence.impl.ExamDAOImpl;
import it.unical.asde2018.unitest.components.persistence.impl.QuestionDAOImpl;
import it.unical.asde2018.unitest.components.persistence.impl.StudentExamDAOImpl;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Question;

// This class is the service that handles the request Exam 
@Service
public class ExamService {
	
	@Autowired
	private ExamDAOImpl examDAO;
	
	@Autowired
	private QuestionDAOImpl questionDAO;
	
	@Autowired 
	private StudentExamDAOImpl studentExamDAO;
	
//	The insertExam saves an Exam object, it needs to save the question first, because of cascade purposes 
	public void insertExam(Exam exam) {
		
		List<Question> questions = exam.getQuestions();
		for (Question question : questions) {
			questionDAO.save(question);
		}
		examDAO.save(exam);
	}

//	Simple function to retrieve all the exam in DB
	public List<Exam> getAllExams(){
		return examDAO.getAllExams();
	}
	
	
}
