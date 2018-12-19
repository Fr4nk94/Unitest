package it.unical.asde2018.unitest.components.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.unical.asde2018.unitest.model.Answer;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Question;
import it.unical.asde2018.unitest.model.Question_Type;
import it.unical.asde2018.unitest.model.User;

@Service
public class QuestionService {

	@Autowired
	private ExamService examService;
	
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
//		Question q4= new Question("cazz e domanda �?", Question_Type.SINGLE_CHOICE);
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
	
	public int automaticCorrection(HashMap<String, Object> map, long examID) {
		int partialScore=0;
		Exam professorExam = examService.getExamByIDFromDB(examID);
		System.out.println("numProfQuest"+professorExam.getQuestions().size());
		for (String studentQuestionID : map.keySet()) {
			System.out.println("--------ENTROOOOOOOOOOOOOO------");

			for (Question professorQuestion : professorExam.getQuestions()) {
				System.out.println("Numero di questions del prof:"+ professorExam.getQuestions().size());
				if(professorQuestion.getQuestionID()==Long.parseLong(studentQuestionID)) {
					if(professorQuestion.getType()==Question_Type.OPEN_ANSWER 
							|| professorQuestion.getType()==Question_Type.ATTACH_FILE) {
						//CompletelyCorrect=false;
					}
					if(professorQuestion.getType()==Question_Type.SINGLE_CHOICE) {
						System.out.println("ENTROOOOOOOOOOOOOO");
						
						for (Answer professorAnswer : professorQuestion.getAnswers()) {
							if(((String)map.get(studentQuestionID)).equals(professorAnswer.getAnswer_body())
									&& professorAnswer.isCorrect()) {
								
								partialScore+=professorQuestion.getCorrectScore();
								System.out.println("+++++CiEntro perchè è corretta."+partialScore);
							}
							else if(((String)map.get(studentQuestionID)).equals(professorAnswer.getAnswer_body())
									&& !professorAnswer.isCorrect()) {
								partialScore+=professorQuestion.getWrongScore();
								System.out.println("-----CiEntro perchè è sbagliata."+partialScore);

							}
						}
					}
					if(professorQuestion.getType()==Question_Type.MULTIPLE_CHOICE) {
						for (Answer professorAnswer : professorQuestion.getAnswers()) {
							for (String studentAnswer : (ArrayList<String>)map.get(studentQuestionID)) {
								if(studentAnswer.equals(professorAnswer.getAnswer_body()) && professorAnswer.isCorrect()) {
									partialScore+=professorQuestion.getCorrectScore();
								}
								if(studentAnswer.equals(professorAnswer.getAnswer_body()) && !professorAnswer.isCorrect()) {
									partialScore+=professorQuestion.getWrongScore();
								}
							}

						}
					}
				}
			}
		}
		return partialScore;
	}
}
