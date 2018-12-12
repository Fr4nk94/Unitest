package it.unical.asde2018.unitest.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "question")
public class Question {

	@Id
	@Column(name = "questionID")
	private long questionID;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Question_Type type;

	@Column(name = "question_body")
	private String question_body;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "questionID")
	private List<Answer> answers;

/*	@ManyToOne
	private Exam exam;*/
	
	public Question() {
		super();
	}

	public Question(long id, String question_body, Question_Type type) {
		super();
		this.answers = new ArrayList<>();
		this.questionID = id;
		this.question_body = question_body;
		this.type = type;
	}

	public long getId() {
		return questionID;
	}

	public void setId(long id) {
		this.questionID = id;
	}

	public Question_Type getType() {
		return type;
	}

	public void setType(Question_Type type) {
		this.type = type;
	}

	public String getQuestion_body() {
		return question_body;
	}

	public void setQuestion_body(String question_body) {
		this.question_body = question_body;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void addAnswer(Answer answer) {
		this.answers.add(answer);
	}

}
