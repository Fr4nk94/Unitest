package it.unical.asde2018.unitest.model;

import java.util.List;

public class Question {

	private int id;
	private String type;
	private String text;
	private List<Answer> answers;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question(int id, String text, List<Answer> answers, String type) {
		super();
		this.id = id;
		this.text = text;
		this.type = type;
		this.answers = answers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Question() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

}
