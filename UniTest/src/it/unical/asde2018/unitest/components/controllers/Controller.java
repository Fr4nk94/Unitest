package it.unical.asde2018.unitest.components.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/")
	public String getHome(Model model,HttpSession session)
	{
		return "index";
	}
}
