package it.unical.asde2018.unitest.components.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.asde2018.unitest.components.services.LoginService;

@Controller
public class AdminController {

	@Autowired
	private LoginService loginService;

	// private String usr;

	// GET: Show Login Page
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping("/loginAttempt")
	public String loginAttempt(@RequestParam String userName, @RequestParam String password, HttpSession session,
			Model model) {
		if (loginService.login(userName, password) == "student") {
			session.setAttribute("username", userName);
			session.setAttribute("role", "Student");

			model.addAttribute("name", loginService.getSudentName(userName));
			model.addAttribute("surname", loginService.getStudentSurname(userName));
			model.addAttribute("email", loginService.getStudentEmail(userName));
			model.addAttribute("address", loginService.getStudentAddress(userName));
			model.addAttribute("phone", loginService.getStudentPhone(userName));
			System.out.println("login");

			return "accountInfo";
		}
		if (loginService.login(userName, password) == "professor") {
			session.setAttribute("username", userName);
			session.setAttribute("role", "Professor");
			/*
			 * model.addAttribute("name", loginService.getSudentName(userName));
			 * model.addAttribute("surname", loginService.getStudentSurname(userName));
			 * model.addAttribute("email", loginService.getStudentEmail(userName));
			 * model.addAttribute("address", loginService.getStudentAddress(userName));
			 * model.addAttribute("phone", loginService.getStudentPhone(userName));
			 * System.out.println("login");
			 */
			return "accountInfo";
		}
		// session.setAttribute("user", userName);
		model.addAttribute("error", "Wrong credentials!");
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session, Model model) {
		// System.out.println("logout");
		session.invalidate();
		return "login";
	}

	// GET: Enter customer information.
	@RequestMapping(value = { "/editInfo" }, method = RequestMethod.GET)
	public String shoppingCartCustomerForm(HttpServletRequest request, Model model) {
		// Redirect to edit page. "redirect:/edit"
		return "edit";
	}

	// GET: Show Login Page
	@RequestMapping("/edit")
	public String editInformation(@RequestParam String name, @RequestParam String surname, @RequestParam String email,
			@RequestParam String address, @RequestParam String phone, HttpSession session, Model model) {

		String username = (String) session.getAttribute("username");
		System.out.println(username);
		loginService.setStudentName(username, name);
		loginService.setStudentSurname(username, surname);
		loginService.setStudentEmail(username, email);
		loginService.setStudentAddress(username, address);
		loginService.setStudentPhone(username, phone);

		model.addAttribute("name", loginService.getSudentName(username));
		model.addAttribute("surname", loginService.getStudentSurname(username));
		model.addAttribute("email", loginService.getStudentEmail(username));
		model.addAttribute("address", loginService.getStudentAddress(username));
		model.addAttribute("phone", loginService.getStudentPhone(username));
		/*
		 * model.addAttribute("name", loginService.getSudentName(username));
		 * model.addAttribute("surname", loginService.getStudentSurname(username));
		 * model.addAttribute("email", loginService.getStudentEmail(username));
		 * model.addAttribute("address", loginService.getStudentAddress(username));
		 * model.addAttribute("phone", loginService.getStudentPhone(username));
		 */
		return "accountInfo";
	}

	@RequestMapping("/myCourses")
	public String shoppingChart(HttpSession session, Model model) {
		String username = (String) session.getAttribute("username");
		if (username == null) {
			model.addAttribute("logged", "You are not logged!");
			return "login";
		}
		return "myCourses";
	}

}
