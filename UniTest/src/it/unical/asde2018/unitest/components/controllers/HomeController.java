package it.unical.asde2018.unitest.components.controllers;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde2018.unitest.components.services.ExamService;
import it.unical.asde2018.unitest.model.Answer;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Question;
import it.unical.asde2018.unitest.model.Question_Type;

@Controller
public class HomeController {
	
	@Autowired
	ExamService examService;

	@GetMapping("/")
	public String index(Model model, Principal principal, Authentication authentication) {
		if (authentication != null) {
			authentication.getAuthorities().forEach(grant -> {
				System.out.println(grant.getAuthority());
			});
		}
		if(model!=null && principal!=null) {
			model.addAttribute("message", "You are logged in as " + principal.getName());
		}
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/saveExam")
	@ResponseBody
	public String saveExam(HttpSession session, Model model) {
		System.out.println("saveExam CONTROLLER");
		Exam exam = new Exam(1, "myExam", new Date());
		
		Question q = new Question(1, "q1", Question_Type.MULTIPLE_CHOICE);
		q.addAnswer(new Answer("A", true));
		q.addAnswer(new Answer("B", false));
		q.addAnswer(new Answer("C", false));
		
		Question q2 = new Question(2, "q2", Question_Type.MULTIPLE_CHOICE);
		q2.addAnswer(new Answer("D", false));
		q2.addAnswer(new Answer("E", true));
		q2.addAnswer(new Answer("F", false));
		
		exam.addQuestion(q);
		exam.addQuestion(q2);
		
		examService.insertExam(exam);
		return "OK";
	}
	
	@GetMapping("/listExam")
	@ResponseBody
	public String listExam(HttpSession session, Model model) {
		System.out.println("list Exam Function");
		
		List<Exam> exams = examService.getAllExams();
		
		for (Exam exam : exams) {
			System.out.println("Exam " + exam.getExamID());
			for (Question q : exam.getQuestions()) {
				System.out.println("question " + q.getQuestion_body());
				for (Answer a : q.getAnswers()) {
					System.out.println("answer " + a.getAnswer_body() + " id : " + a.isCorrect());
				}
			}
		}
		
		return "ExamList";
	}
}
