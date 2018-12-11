package it.unical.asde2018.unitest.components.controllers;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/")
	public String index(Model model, Principal principal, Authentication authentication) {
		if (authentication != null) {
			authentication.getAuthorities().forEach(grant -> {
				System.out.println(grant.getAuthority());
			});
		}
		if(model!=null && principal!=null) {
			model.addAttribute("message", "You are logged in as " + principal.getName());
		}
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	// First Commit
}
