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
import it.unical.asde2018.unitest.model.Question_Type;
import it.unical.asde2018.unitest.model.User;
import it.unical.asde2018.unitest.model.security.UserPrincipal;

@Controller
public class HomeController {

	@Autowired
	ExamService examService;

	@GetMapping("/")
	public String index(Model model, Principal principal, Authentication authentication, HttpSession session) {
		if (authentication != null) {
			authentication.getAuthorities().forEach(grant -> {
				session.setAttribute("role", grant.getAuthority());
			});
			session.setAttribute("aUser", ((UserPrincipal) authentication.getPrincipal()).getUser());
		}
		if (model != null && principal != null) {
			model.addAttribute("message",
					"You are logged in as " + ((UserPrincipal) authentication.getPrincipal()).getUser().getUsername());
		}
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "accessDenied";
	}

	@GetMapping("/saveExam")
	@ResponseBody
	public String saveExam(HttpSession session, Model model) {
		System.out.println("saveExam CONTROLLER");
	
		return "OK";
	}
}
