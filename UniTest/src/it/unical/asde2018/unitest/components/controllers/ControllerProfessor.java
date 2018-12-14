package it.unical.asde2018.unitest.components.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde2018.unitest.components.services.ServiceProfessor;
import it.unical.asde2018.unitest.model.Answer;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Question;

@Controller
public class ControllerProfessor {

	@Autowired
	private ServiceProfessor testService;

	private int questions;
	private int answer;

	@GetMapping("/")
	private String goToIndex(Model model, HttpSession session) {
//		if (session.getAttribute("user") != null) {
//			return "listLobbies";
//		}
		return "index";
	}

	@GetMapping("/checkExam")
	public String checkExam(HttpSession session, Model model, @RequestParam int idExam) {
		for (Exam exam : testService.getPortfolio()) {
			if (exam.getId() == idExam) {
//				model.addAttribute("idExam", idExam);
				session.setAttribute("exam", testService.getExam(idExam));
				session.setAttribute("idExam", idExam);
				return "exam";
			}
		}
		return "";
	}

	@GetMapping("setScore")
//	@ResponseBody
	public String setScore(HttpSession session, Model model, @RequestParam int totalScore, @RequestParam int idExam) {
//		System.out.println("Score " + totalScore + " ID " + idExam);
		testService.getExam(idExam).setTotalScore(totalScore);
		return "index";
	}

	@GetMapping("goToExam")
	public String goToExam(HttpSession session, Model model) {
//		model.addAttribute("idExam", testService.getExam(idExam));
		return "exam";
	}

	@GetMapping("/showExam")
	@ResponseBody
	public String showExam(HttpSession session, Model model) {
		JSONObject lob = getExamJSON(session);
//		model.addAttribute("idExam", testService.getExam(idExam));
//		System.out.println("Entro? in showExam" + lob.toJSONString());
		return lob.toJSONString();
	}

	@GetMapping("/listExams")
	@ResponseBody
	public String professorViewTest(HttpSession session, Model model) {

		JSONArray lob = listTests(session);

//		System.out.println("Entro? " + lob.toJSONString());
		return lob.toJSONString();

	}

	@SuppressWarnings("unchecked")
	private JSONObject getExamJSON(HttpSession session) {

		JSONObject examJSON = new JSONObject();
		Exam exam = (Exam) session.getAttribute("exam");
		examJSON.put("idExam", exam.getId());
		examJSON.put("nameExam", exam.getName());
		JSONArray questionArrayJSON = new JSONArray();
		for (Question question : exam.getQuestions()) {
			JSONObject questionObjectJSON = new JSONObject();
			questionObjectJSON.put("name", question.getQuestion_title());
			questionObjectJSON.put("score", question.getCorrect_score());
			JSONArray answerArrayJSON = new JSONArray();
			for (Answer answer : question.getAnswer()) {
				JSONObject answerOjectJSON = new JSONObject();
				answerOjectJSON.put("answer", answer.getAnswer_content());
				answerArrayJSON.add(answerOjectJSON);
			}
			questionObjectJSON.put("answers", answerArrayJSON);
			questionArrayJSON.add(questionObjectJSON);
		}
		examJSON.put("questions", questionArrayJSON);
		return examJSON;

	}

	@SuppressWarnings("unchecked")
	private JSONArray listTests(HttpSession session) {

		JSONArray examList = new JSONArray();
		List<Exam> exams = testService.getPortfolio();
//		Integer exami = (Integer) session.getAttribute("exam");

//		System.out.println("SIZE " + exami);
		for (Exam exam : exams) {
			JSONObject examJSON = new JSONObject();
			examJSON.put("scoreExam", exam.getTotalScore());
			System.out.println("SCORE " + exam.getTotalScore());
			examJSON.put("nameExam", exam.getName());
			examJSON.put("dateExam", exam.getCreationDate().toString());
			examJSON.put("idExam", exam.getId());
			JSONArray jsonQuestionArray = new JSONArray();
//			for (Question question : exam.getQuestions()) {
//				JSONObject objectQuestion = new JSONObject();
//				objectQuestion.put("question", question.getQuestion_title());
//				JSONArray jsonAnswerArray = new JSONArray();
//				for (Answer answer : question.getAnswer()) {
//					JSONObject objectAnswer = new JSONObject();
//					objectAnswer.put("answer", answer.getAnswer_content());
//					jsonAnswerArray.add(objectAnswer);
//					examJSON.put("listAnswer", jsonAnswerArray);
//				}
//				jsonQuestionArray.add(objectQuestion);
//			}
//			examJSON.put("listQuestion", jsonQuestionArray);
			examList.add(examJSON);
		}
		return examList;
	}
}
