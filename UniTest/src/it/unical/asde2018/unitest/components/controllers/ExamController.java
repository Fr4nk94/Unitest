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

	// TODO method created only for testing purposes
	@GetMapping("/createExam")
	public String home() {

		return "createExam";
	}

	@PostMapping("examCreated")
	@ResponseBody
	public String examCreated(HttpSession session, Model model, @RequestParam String exam_ID) {

		Exam exam = examService.getExamByID(Integer.parseInt(exam_ID));

		System.err.println(exam.getQuestions().toString());
		examService.storeExam(exam);
		return "examCreated";
	}

	@PostMapping("createExam")
	@ResponseBody
	public boolean createGeneralExam(@RequestParam String examName, @RequestParam String isAvailable, @RequestParam String timeAvailable,
			HttpSession session, Model model) {

		List<Question> questions = new ArrayList<>();
		List<Answer> answers = new ArrayList<>();
		try {
			User professor = (User) session.getAttribute("aUser");

			Exam e = examService.createExam(professor, examName, questions, answers, Boolean.parseBoolean(isAvailable), Float.parseFloat(timeAvailable));

			session.setAttribute("currentExamID", e.getInternalID());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@PostMapping("insertQuestions")
	@ResponseBody
	public String insertQuestion(HttpSession session, @RequestParam String exam_ID, @RequestParam String questionTitle,
			@RequestParam String questionType, @RequestParam String correctScore, @RequestParam String wrongScore,
			@RequestParam String answers, @RequestParam String isCorrect) {

		System.out.println("INSERT QUESTION exam_ID =" + exam_ID + " question title = " + questionTitle
				+ " max score = " + correctScore);

		Exam e = examService.getExamByID(Integer.parseInt(exam_ID));
		Question question = new Question(questionTitle, Question_Type.valueOf(questionType),
				Float.parseFloat(correctScore), Float.parseFloat(wrongScore));
		question.setInternalID(e.getQuestions().size());

		if (Question_Type.valueOf(questionType).equals(Question_Type.SINGLE_CHOICE)) {

			String[] ans = answers.split(",");
			int idCorr = Integer.parseInt(isCorrect.split("-")[1]);
			int k = 0;
			for (String s : ans) {
				question.addAnswer(new Answer(s, (idCorr == k ? true : false)));
				k++;
			}

		}

		else if (Question_Type.valueOf(questionType).equals(Question_Type.MULTIPLE_CHOICE)) {

			String[] ans = answers.split(",");
			String[] tmp = isCorrect.split(",");
			List<Integer> idCorr = new ArrayList<>();
			int k = 0;

			for (String s : tmp) {
				idCorr.add(Integer.parseInt(s.split("-")[1]));
			}

			for (String s : ans) {
				question.addAnswer(new Answer(s, (idCorr.contains(k) ? true : false)));
				k++;
			}

		}

		e.setMaxScore(question.getCorrectScore());
		
		e.addQuestion(question);

		System.out.println(e.toString());

		return "addQuestions";
	}

	@GetMapping("addQuestions")
	public String addQuestions() {
		return "addQuestions";
	}
	
	@PostMapping("changeAvailability")
	@ResponseBody
	public String changeAvailability(String exam_ID) {
		return examService.changeAvailability(Long.parseLong(exam_ID));
	}

}
