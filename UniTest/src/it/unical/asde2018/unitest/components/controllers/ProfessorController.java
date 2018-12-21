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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.unical.asde2018.unitest.components.services.ServiceProfessor;
import it.unical.asde2018.unitest.model.Question_Type;
import it.unical.asde2018.unitest.model.Student_Answer;
import it.unical.asde2018.unitest.model.Student_Exam;
import it.unical.asde2018.unitest.model.Student_Question;
import it.unical.asde2018.unitest.model.User;

@Controller
public class ProfessorController {

	@Autowired
	private ServiceProfessor testService;

//	@GetMapping("/")
//	private String goToIndex(Model model, HttpSession session) {
////		if (session.getAttribute("user") != null) {
////			return "listLobbies";
////		}
//		return "index";
//	}

	@GetMapping("/evalExam")
	public String listExam(HttpSession session, Model model) {
		return "listExamEval";
	}

	@GetMapping("/evaluatedExam")
	public String listExamEvaluated(HttpSession session, Model model) {
		return "listExamEvaluated";
	}

	@GetMapping("/checkExam")
	public String checkExam(HttpSession session, Model model, @RequestParam int idExam) {
		User user = (User) session.getAttribute("aUser");
		for (Student_Exam exam : testService.getProfsExamsEval(user, false)) {
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
		Student_Exam sExam = testService.getExam(idExam);
		float multipleScore = sExam.getStudent_score();
		sExam.setStudent_score(totalScore + multipleScore);
		sExam.setCorrect(true);
		testService.updateStudent_Exam(sExam);
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

	@PostMapping("/listExams")
	@ResponseBody
	public String professorViewTest(HttpSession session, Model model, @RequestParam boolean evaluate) {
		User user = (User) session.getAttribute("aUser");
		JSONArray lob = listTests(user, evaluate);

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
			if (question.getQuestion().getType() == Question_Type.OPEN_ANSWER) {
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
		}
		examJSON.put("questions", questionArrayJSON);
		return examJSON;

	}

	@SuppressWarnings("unchecked")
	private JSONArray listTests(User user, boolean correct) {

		JSONArray examList = new JSONArray();
		List<Student_Exam> exams = testService.getProfsExamsEval(user, correct);
//		Integer exami = (Integer) session.getAttribute("exam");

//		System.out.println("SIZE " + exami);
		if (exams != null) {
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
		}
		return examList;
	}
}
