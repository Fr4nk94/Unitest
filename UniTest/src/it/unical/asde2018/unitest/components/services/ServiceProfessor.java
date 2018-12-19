package it.unical.asde2018.unitest.components.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.components.persistence.global.Student_ExamDAO;
import it.unical.asde2018.unitest.model.Answer;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Question;
import it.unical.asde2018.unitest.model.Question_Type;
import it.unical.asde2018.unitest.model.Student_Exam;
import it.unical.asde2018.unitest.model.User;
import javassist.compiler.ast.NewExpr;

@Service
public class ServiceProfessor {

	@Autowired
	private Student_ExamDAO sExamDAO;

	private List<Student_Exam> portfolio;
////	private List<Exam> portfolio1;
////	private List<Exam> portfolio2;
//	private List<Question> question;
////	private List<Question> question1;
////	private List<Question> question2;
//	private List<Answer> answer;
//	private List<Answer> answer4;
////	private List<Answer> answer2;
//
//	private Answer answer1;
//	private Answer answer2;
//	private Answer answer3;

	@PostConstruct
	public void init() {
//		question = new ArrayList<>();
//		answer = new ArrayList<>();
//		answer4 = new ArrayList<>();
//		answer1 = new Answer(1, true, "Sono morto con altri 100");
//		answer2 = new Answer(2, true, "Sono morto che ero un bambino");
//		answer3 = new Answer(3, true, "Nel freddo giorno di inverno");
//		portfolio = new ArrayList<>();
//		answer.add(answer1);
//		answer4.add(answer2);
////
////		answer.add(new Answer(1, true, "Non ne ho idea"));
////		answer2.add(new Answer(2, true, "Sembra che non sembra niente"));
////		answer2.add(new Answer(3, true, "Non lo so, ho perso la memoria"));
//		question.add(new Question(1, "Ciao come stai?", Question_Type.OPEN_ANSWER, 5, 5, answer));
////		question.add(new Question(4, "E' natale?", Question_Type.OPEN_ANSWER, 5, 5, answer2));
//		question.add(new Question(2, "E' morto Gesù?", Question_Type.OPEN_ANSWER, 6, 5, answer4));
//
////		question1.add(new Question(2, "Ciao come ti sembra?", Question_Type.OPEN_ANSWER, 5, 5, answer1));
////		question2.add(new Question(3, "Ciao come ti chiami?", Question_Type.OPEN_ANSWER, 5, 5, answer));
//
//		portfolio.add(new Exam(1, "Prova", Exam_Type.OPEN_ANSWER, question, new Date(), true));
////		portfolio.add(new Exam(2, "Prova2", Exam_Type.OPEN_ANSWER, question2, new Date(), true));
////		portfolio2.add(new Exam(3, "Prova3", Exam_Type.OPEN_ANSWER, question, new Date(), true));
	}

	public List<Student_Exam> getProfsExamsEval(User user, boolean correct) {
		return sExamDAO.getAllStudentExamProf(user, correct);

	}

	public Student_Exam getExam(int id) {
		return sExamDAO.getById((long) id);

	}

	public void updateStudent_Exam(Student_Exam sExam) {
		sExamDAO.update(sExam);
	}

}
