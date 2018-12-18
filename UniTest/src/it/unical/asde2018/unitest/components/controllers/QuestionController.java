package it.unical.asde2018.unitest.components.controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;

import it.unical.asde2018.unitest.components.services.ExamService;
import it.unical.asde2018.unitest.components.services.QuestionService;
import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Student_Answer;
import it.unical.asde2018.unitest.model.Student_Exam;
import it.unical.asde2018.unitest.model.Student_Question;
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

	@GetMapping("/exam")
	public String goToExam(Model model, HttpSession session) {
		Exam examTmp = examService.getAllExams().get(1);
		model.addAttribute("questions", examTmp.getQuestions());
		model.addAttribute("totQuestions", examTmp.getQuestions().size());
		session.setAttribute("exam", examTmp.getExamID());
		SimpleDateFormat sdf = new SimpleDateFormat("MM dd, yyyy hh:mm:ss aa");
		String data = "12 17, 2018 14:00:00 AM";
		Date newDate = new Date();
		try {
			newDate = sdf.parse(data);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("timer", sdf.format(newDate));
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
//		long examID = (long) session.getAttribute("exam");
//		Student_Exam exam_to_submit = new Student_Exam(new Date(), new User());
		for (String key : map.keySet()) {
//			Student_Question question = new Student_Question();
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
		/*
		 * Student_Exam exam_to_submit = new Student_Exam((long)
		 * session.getAttribute("exam"), new Date(),
		 * (User)session.getAttribute("aUser"));
		 * 
		 * 
		 * for (String key : map.keySet()) { System.out.println("key " + key + " " +
		 * map.get(key)); Student_Question question = new
		 * Student_Question(Long.parseLong(key));
		 * 
		 * }
		 */

		return true;
	}
}
