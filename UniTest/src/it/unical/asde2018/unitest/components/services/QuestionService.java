package it.unical.asde2018.unitest.components.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import it.unical.asde2018.unitest.model.Answer;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Question;
import it.unical.asde2018.unitest.model.Question_Type;
import it.unical.asde2018.unitest.model.User;

@Service
public class QuestionService {

	private List<Question> questions;

	public QuestionService() {
		super();
	}

	public List<Question> getListQuestions() {
		return questions;
	}

	@PostConstruct
	public void init() {

		
		
		
//		questions = new ArrayList<>();
//		
//		Exam exam = new Exam(new User(), "Esame di Giancarlo", new Date());
//
//		Question q1 = new Question("dove va ciccio", Question_Type.MULTIPLE_CHOICE);
//		q1.addAnswer(new Answer("ciccio", false));
//		q1.addAnswer(new Answer("francesco", false));
//		q1.addAnswer(new Answer("fra", false));
//		q1.addAnswer(new Answer("cucco", true));
//
//		Question q2 = new Question("dove va ciccio nuova domanda dove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domanda?", Question_Type.MULTIPLE_CHOICE);
//		q2.addAnswer(new Answer("cacca", true));
//		q2.addAnswer(new Answer("bao", false));
//		q2.addAnswer(new Answer("miao", false));
//
//		Question q3 = new Question("domanda aperta?", Question_Type.OPEN_ANSWER);
//
//		Question q4= new Question("cazz e domanda è?", Question_Type.SINGLE_CHOICE);
//		q4.addAnswer(new Answer("cacca", true));
//		q4.addAnswer(new Answer("bao", false));
//		q4.addAnswer(new Answer("miao", true));
//		
//		exam.addQuestion(q1);
//		exam.addQuestion(q2);
//		exam.addQuestion(q3);
//		exam.addQuestion(q4);
//		
//		questions.add(q1);
//		questions.add(q2);
//		questions.add(q3);
//		questions.add(q4);
	}
}
