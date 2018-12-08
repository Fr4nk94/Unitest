package it.unical.asde2018.unitest.components.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AvailableController {

	
	//This methods return all the available exams made, it is called by a Student
	@GetMapping("/availableExams")
	public String getAvailableExams(Model model, HttpSession session)
	{
		return "examsAvailable";
	}
}
