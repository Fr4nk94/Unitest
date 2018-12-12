package it.unical.asde2018.unitest.components.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.asde2018.unitest.components.services.ExamService;

@Controller
public class ExamController {

	@Autowired
	private ExamService examService;

	private String username;

	@RequestMapping("/courseList")
	public String courseList(HttpSession session, Model model) {
		// session.setAttribute("users", loginService.getUsers());

		model.addAttribute("courses", examService.getExams());
		return "courseList";
	}

	@RequestMapping({ "/joinCourse" })
	public String listCourseHandler(HttpServletRequest request, Model model, HttpSession session,
			@RequestParam(value = "courseName", defaultValue = "") String courseName,
			@RequestParam(value = "courseCode", defaultValue = "") String courseCode,
			@RequestParam(value = "courseCredits", defaultValue = "") String courseCredits) {
		username = (String) session.getAttribute("username");
		if (username == null) {
			model.addAttribute("logged", "You are not logged!");
			return "login";
		}
		System.out.println(courseName + courseCode + courseCredits);

		// loginService.addCourse(username, courseName, courseCode, courseCredits);
		// model.addAttribute("courseCode", courseCode);

		// model.addAttribute("myCourses", loginService.getJoinedCourses(username));

		// System.out.println(loginService.getJoinedCourses(username));

		// model.addAttribute("posts", blogService.getAllPosts());

		// model.addAttribute("courseName", courseName);
		// model.addAttribute("courseCredits", courseCredits);

		return "myCourses";
	}

	@RequestMapping({ "/leaveCourse" })
	public String removeProductHandler(HttpServletRequest request, Model model,
			@RequestParam(value = "code", defaultValue = "") String code) {
		return "courseList";
	}

}
