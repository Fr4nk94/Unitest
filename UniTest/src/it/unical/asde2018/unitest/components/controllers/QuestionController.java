package it.unical.asde2018.unitest.components.controllers;

import java.io.IOException;
import java.util.HashMap;
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
import it.unical.asde2018.unitest.components.services.QuestionService;

@Controller
public class QuestionController {

	@Autowired
	public QuestionService questionService;

	@GetMapping("/")
	public String goToIndex() {
		return "index";
	}

	@GetMapping("/exam")
	public String goToExam(Model model) {
		model.addAttribute("totQuestions", questionService.getListQuestions().size());
		model.addAttribute("questions", questionService.getListQuestions());
		model.addAttribute("answers", questionService.getListQuestions().get(0).getAnswers());
		return "exam";
	}

	@PostMapping("/submitExam")
	@ResponseBody
	public boolean submitExam(String json) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper obj = new ObjectMapper();
		TypeFactory typeFactory = obj.getTypeFactory();
		MapType mapType = typeFactory.constructMapType(HashMap.class, String.class, Object.class);
		HashMap<String, Object> map = obj.readValue(json, mapType);
		for (String key : map.keySet()) {
			System.out.println("key " + key + " " + map.get(key));
		}
		return true;
	}
}
