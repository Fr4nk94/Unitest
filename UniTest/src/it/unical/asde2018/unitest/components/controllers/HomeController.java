package it.unical.asde2018.unitest.components.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.unical.asde2018.unitest.components.services.ExamsService;


@Controller
public class HomeController {

	@Autowired
	ExamsService examsService;

	@GetMapping("/")
	public String getExamsList(Model model) {
		int numExams = examsService.getExams().size();
		int numberOfPages = 0;
		
		if(numExams%5==0) {
			numberOfPages=numExams/5;
		}else
		{
			numberOfPages = (numExams/5)+1;
		}

		model.addAttribute("numberOfPages", numberOfPages);
		model.addAttribute("page",examsService.getPage(1));
		System.out.println("Robe");
		return "index";
	}

	@GetMapping("paging")
	public String getPage(Model model,@RequestParam Integer pageNumber) {
		model.addAttribute("page",examsService.getPage(pageNumber));
		return "index";
	}


}
