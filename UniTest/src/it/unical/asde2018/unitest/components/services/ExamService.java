package it.unical.asde2018.unitest.components.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.components.persistence.ExamDAO;
import it.unical.asde2018.unitest.model.Exam;

@Service
public class ExamService {

	@Autowired
	private ExamDAO examDAO;

	@PostConstruct
	public void init() {
	}

	public List<Exam> getExams() {
		return examDAO.getAllExams();
	}
}