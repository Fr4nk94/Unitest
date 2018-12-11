package it.unical.asde2018.unitest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Exam {

	private int ExamID;

	private String name;

	private Date creation_date;

	private boolean available = false;

	private List<Question> questions;
	
	public Exam() {
		// TODO Auto-generated constructor stub
	}

	public Exam(int ID, String name, Date date) {
		ExamID = ID;
		this.name = name;
		creation_date = date;
		questions = new ArrayList<>();
	}

	public int getExamID() {
		return ExamID;
	}

	public void setExamID(int examID) {
		ExamID = examID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Date getCreation_date() {
		return creation_date;
	}

	public void addQuestion(Question q) {
		questions.add(q);
	}
	
	public List<Question> getQuestions() {
		return questions;
	}

}
