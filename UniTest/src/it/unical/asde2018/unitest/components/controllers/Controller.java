package it.unical.asde2018.unitest.components.controllers;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.unical.asde2018.unitest.model.security.UserPrincipal;

@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/")
	public String index(Model model, Principal principal, Authentication authentication, HttpSession session) {
		if (authentication != null) {
			authentication.getAuthorities().forEach(grant -> {
				System.out.println(grant.getAuthority());
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

	// First Commit
}
