package it.unical.asde2018.unitest.components.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@GetMapping("/")
	public String getHome(Model model,HttpSession session)
	{
		return "waiting";
	}
	
	@PostMapping("checkStartExam")
	@ResponseBody
	public String checkStartExam(Model model,HttpSession session, @RequestParam String exam)
	{
		//check the bool of exam
		System.out.println("OLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLE");
		return "false";
	}
}
