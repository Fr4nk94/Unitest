package it.unical.asde2018.unitest.components.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde2018.unitest.components.services.ExamService;
import it.unical.asde2018.unitest.model.Answer;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Question;
import it.unical.asde2018.unitest.model.Question_Type;
import it.unical.asde2018.unitest.model.User;


@org.springframework.stereotype.Controller
public class ExamController {
	
	@Autowired
	ExamService examService;
	
	
	//TODO method created only for testing purposes
	@GetMapping("/")
	public String home() {
		
		return "createExam";
	}
	
	@GetMapping("examCreated")
	@ResponseBody
	public String examCreated() {
		return "examCreated";
	}
	
	@PostMapping("createExam")
	@ResponseBody
	public void createGeneralExam(@RequestParam String examName, @RequestParam String isAvailable, HttpSession session) {
		
		List<Question> questions = new ArrayList<>();
		List<Answer> answers = new ArrayList<>();
		
		//TODO
		User professor = new User();

		Exam e = examService.createExam(professor, examName, questions, answers, Boolean.parseBoolean(isAvailable));
		
		session.setAttribute("currentExamID", e.getInternalID());
		
//		if(Exam_Type.valueOf(examType).equals(Exam_Type.OPEN_ANSWER))
//		{
//			return "createOpenAnswerExam";
//		}
//		else if(Exam_Type.valueOf(examType).equals(Exam_Type.SINGLE_CHOICE))
//		{
//			return "createSingleChoiseAnswerExam";
//		}
//		else if(Exam_Type.valueOf(examType).equals(Exam_Type.MULTIPLE_CHOICE))
//		{
//			return "createMultipleChoiseAnswerExam";
//		}
//		return "index";
		
		//return "redirect:/insertQuestions";
	}
	
	@PostMapping("insertQuestions")
	@ResponseBody
	public String insertQuestion(HttpSession session, @RequestParam String exam_ID, @RequestParam String questionTitle, @RequestParam String questionType, @RequestParam String maxScore) {
	
		
		System.out.println("INSERT QUESTION exam_ID ="+exam_ID+" question title = "+questionTitle+" max score = "+maxScore);
		
		Exam e = examService.getExamByID(Integer.parseInt(exam_ID));
		Question question = new Question(questionTitle, Question_Type.valueOf(questionType), Integer.parseInt(maxScore), 0); //Wrong score = 0 because it's open answer
		question.setInternalID(e.getQuestions().size());
		
		
		e.addQuestion(question);
		
		System.out.println(e.toString());
		
		return "addQuestions";
	}
	
	
	
	@GetMapping("addQuestions")
	public String addQuestions() {
		return "addQuestions";
	}
	
/*
	@PostMapping("addQuestionAndAnswers")
	@ResponseBody
	public void addQuestionAndAnswers(@RequestParam String exam_ID, @RequestParam String questionTitle, @RequestParam String correctScore, @RequestParam String wrongScore, @RequestParam String answer, @RequestParam String isCorrect, @RequestParam String questionType) {
		System.out.println("L'ESAME E' "+exam_ID);
		System.out.println("DOMANDA "+questionTitle);
		System.out.println("CORRECT SCORE "+correctScore);
		System.out.println("WRONG SCORE "+wrongScore);
		System.out.println("ANSWER "+answer);

		int i=0;
		
			
		int examID = Integer.parseInt(exam_ID);
		Exam e = examService.getExamByID(examID);
			
		String[] ans = answer.split(",");
		List<Answer> answers = new ArrayList<>();
		
		Question question = new Question(e.getQuestions().size(), questionTitle, Question_Type.valueOf(questionType), Integer.parseInt(correctScore), 0, answers);
		
		
		if(Question_Type.SINGLE_CHOICE == Question_Type.valueOf(questionType)) {
				
				int correct = Integer.parseInt(isCorrect.split("-")[1]);
				System.out.println("LA RISPOSTA CORRETTA E'"+correct );
				
				for(String s : ans) {
					answers.add(new Answer(question.getId(), i, (correct == i ? true : false), s));
					i++;
				}
				
				
			}
		
		else if(Question_Type.MULTIPLE_CHOICE == Question_Type.valueOf(questionType)) {
			String[] tmp = isCorrect.split(",");
			
			int[] corrects = new int[tmp.length];
			int j = 0;
			
			for(String s : tmp) {
				corrects[j] = Integer.parseInt(s.split("-")[1]);
				j++;
			}
			
			for(String s : ans) {
				boolean corr = false;
				
				for(int x : corrects) {
					if(x == i) {
						corr=true;
						break;
						}
				}
				answers.add(new Answer(question.getId(), i, corr, s));
				i++;
			}
			
		}
		

		question.setAnswers(answers);
		
		examService.addQuestion(question, e);
			
		examService.printExam(e.getId());
		
	}
	
	
	
	
	
	// Take the question inserted in the form (Only for the open answer type)
	@PostMapping("addQuestion")
	@ResponseBody
	public void addQuestion(@RequestParam String exam_ID, @RequestParam String questionTitle, @RequestParam String maxScore) {
		//String[] questionTitles = questionTitle.split(",");
		//String[] scores = maxScore.split(",");
		
		int examID = Integer.parseInt(exam_ID);
		Exam e = examService.getExamByID(examID);
		
//		for(int i=0; i< questionTitles.length; i++) {
//			
//			Question question = new Question(i+1, questionTitles[i], Question_Type.OPEN_ANSWER, Integer.parseInt(scores[i]), 0, new ArrayList<Answer>());
//			examService.addQuestion(question, e);
//		
//		}
		
		Question question = new Question(e.getQuestions().size(), questionTitle, Question_Type.OPEN_ANSWER, Integer.parseInt(maxScore), 0, new ArrayList<Answer>());
		examService.addQuestion(question, e);
		
		examService.printExam(e.getId());
		
	}
	*/
}
