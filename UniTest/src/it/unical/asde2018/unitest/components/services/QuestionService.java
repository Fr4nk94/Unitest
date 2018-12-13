package it.unical.asde2018.unitest.components.services;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import it.unical.asde2018.unitest.model.Answer;
import it.unical.asde2018.unitest.model.Question;

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

/*		questions = new ArrayList<>();

		Answer ans1 = new Answer("ciccio", false);
		Answer ans2 = new Answer("francesco", false);
		Answer ans3 = new Answer("fra", false);
		Answer ans4 = new Answer("cucco", true);
		List<Answer> lista = new ArrayList<>();
		lista.add(ans1);
		lista.add(ans2);
		lista.add(ans3);
		lista.add(ans4);
		Question q1 = new Question("dove va ciccio", lista, "multiple");
		questions.add(q1);
		Answer ans5 = new Answer("cacca", true);
		Answer ans6 = new Answer("bao", false);
		Answer ans7 = new Answer("miao", false);
		List<Answer> lista2 = new ArrayList<>();
		lista2.add(ans5);
		lista2.add(ans6);
		lista2.add(ans7);
		Question q2 = new Question("dove va ciccio nuova domanda dove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domandadove va ciccio nuova domanda?",
				lista2, "multiple");
		questions.add(q2);
		List<Answer> lista3 = new ArrayList<>();
		Question q3 = new Question("domanda aperta?", lista3, "open");
		questions.add(q3);
		Answer ans8 = new Answer("cacca", true);
		Answer ans9 = new Answer("bao", false);
		Answer ans10 = new Answer("miao", true);
		List<Answer> lista4 = new ArrayList<>();
		lista4.add(ans8);
		lista4.add(ans9);
		lista4.add(ans10);
		Question q4= new Question(3,"cazz e domanda è?",lista4,"open");
		questions.add(q4);*/
	}
}
