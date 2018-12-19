package it.unical.asde2018.unitest.components.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import it.unical.asde2018.unitest.components.services.ExamService;
import it.unical.asde2018.unitest.components.services.QuestionService;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Student_Exam;
import it.unical.asde2018.unitest.model.User;

@Controller
public class QuestionController {

	@Autowired
	public QuestionService questionService;

	@Autowired
	public ExamService examService;

//	@GetMapping("/")
//	public String goToIndex() {
//		return "index";
//	}

	@PostMapping("/goToExamDario")
	@ResponseBody
	public String goToExam(@RequestParam String examID, @RequestParam String startingDate, Model model,
			HttpSession session) {
//		Exam examTmp = examService.getExamByID(Integer.parseInt(examID));
//		Exam examTmp = examService.retriveStoredExam(examID);
//		model.addAttribute("questions", examTmp.getQuestions());
//		model.addAttribute("totQuestions", examTmp.getQuestions().size());
		session.setAttribute("examID", examID);
//		SimpleDateFormat sdf = new SimpleDateFormat("MM dd, yyyy hh:mm:ss aa");
//		Date newDate = new Date();
////		model.addAttribute("timer", sdf.format(newDate));
//		model.addAttribute("timer", startingDate);
		session.setAttribute("timer", startingDate);

		return "exam";
	}

	@GetMapping("/redirectExam")
	public String redirectExam(Model model, HttpSession session) {
		System.out.println("Session ExamID " + (String) session.getAttribute("examID"));

		Exam examTmp = examService.retriveStoredExam((Long.parseLong((String) session.getAttribute("examID"))));

		model.addAttribute("questions", examTmp.getQuestions());
		model.addAttribute("totQuestions", examTmp.getQuestions().size());
		model.addAttribute("timer", session.getAttribute("timer"));
		model.addAttribute("timeAvailable", examTmp.getTimeAvailable());

		return "exam";
	}

	@SuppressWarnings("unchecked")
	@PostMapping("/submitExam")
	@ResponseBody
	public boolean submitExam(HttpSession session, Model model, String json)
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		TypeFactory typeFactory = obj.getTypeFactory();
		MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Object.class);
//		Mappa contenente idQuestion ---> String risposta dello Studente
		HashMap<String, Object> map = obj.readValue(json, mapType);
		System.out.println("map size " + map.size());
		System.out.println("map val size " + map.values().size());
		User user = (User) session.getAttribute("aUser");
		long examID = Long.parseLong((String) session.getAttribute("examID"));
		for (String key : map.keySet()) {
			if (map.get(key) instanceof String) {
				System.out.println("Stringa");
				System.out.println(map.get(key));

			} else if (map.get(key) instanceof ArrayList) {
				System.out.println("Arraylist");
				ArrayList<String> list = (ArrayList<String>) map.get(key);
				for (String string : list) {
					System.out.println(string);
				}
			}
		}

		System.out.println(examService.automaticCorrectionAndSave(map, examID, user));

		return true;
	}

	private Student_Exam buildStudenExam(Map<String, Object> ans, Exam exam) {

		return null;
	}
}
