package it.unical.asde2018.unitest.components.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde2018.unitest.components.services.ServiceProfessor;
import it.unical.asde2018.unitest.model.Student_Answer;
import it.unical.asde2018.unitest.model.Student_Exam;
import it.unical.asde2018.unitest.model.Student_Question;

@Controller
public class ControllerProfessor {

	@Autowired
	private ServiceProfessor testService;

//	@GetMapping("/")
//	private String goToIndex(Model model, HttpSession session) {
////		if (session.getAttribute("user") != null) {
////			return "listLobbies";
////		}
//		return "index";
//	}

	@GetMapping("/checkExam")
	public String checkExam(HttpSession session, Model model, @RequestParam int idExam) {
		for (Student_Exam exam : testService.getPortfolio()) {
			if (exam.getStudent_ExamID() == idExam) {
//				model.addAttribute("idExam", idExam);
				session.setAttribute("exam", testService.getExam(idExam));
				session.setAttribute("idExam", idExam);
				return "correctExam";
			}
		}
		return "";
	}

	@GetMapping("setScore")
//	@ResponseBody
	public String setScore(HttpSession session, Model model, @RequestParam int totalScore, @RequestParam int idExam) {
//		System.out.println("Score " + totalScore + " ID " + idExam);
		testService.getExam(idExam).setStudent_score(totalScore);
		return "listExam";
	}

	@GetMapping("goToExam")
	public String goToExam(HttpSession session, Model model) {
//		model.addAttribute("idExam", testService.getExam(idExam));
		return "correctExam";
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
		Student_Exam exam = (Student_Exam) session.getAttribute("exam");
		examJSON.put("idExam", exam.getStudent_ExamID());
		examJSON.put("nameExam", exam.getExam().getName());
		JSONArray questionArrayJSON = new JSONArray();
		for (Student_Question question : exam.getGiven_question()) {
			JSONObject questionObjectJSON = new JSONObject();
			questionObjectJSON.put("name", question.getQuestion().getQuestion_body());
			questionObjectJSON.put("score", question.getQuestion().getCorrectScore());
			JSONArray answerArrayJSON = new JSONArray();
			for (Student_Answer answer : question.getAnswer_given()) {
				JSONObject answerOjectJSON = new JSONObject();
				answerOjectJSON.put("answer", answer.getAnswer_given());
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
		List<Student_Exam> exams = testService.getPortfolio();
//		Integer exami = (Integer) session.getAttribute("exam");

//		System.out.println("SIZE " + exami);
		for (Student_Exam exam : exams) {
			JSONObject examJSON = new JSONObject();
			examJSON.put("scoreExam", exam.getStudent_score());
			System.out.println("SCORE " + exam.getStudent_score());
			examJSON.put("nameExam", exam.getExam().getName());
			examJSON.put("dateExam", exam.getSubmission_date().toString());
			examJSON.put("idExam", exam.getStudent_ExamID());
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
