package it.unical.asde2018.unitest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
	@Column(name = "examID")
	private long ExamID;

	@Column(nullable = false)
	private String name;

	@Temporal(TemporalType.DATE)
	private Date creation_date;

	@Transient
	private boolean available = false;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "examID")
	private List<Question> questions;

	public Exam() {
		// TODO Auto-generated constructor stub
	}

	public Exam(long ID, String name, Date date) {
		ExamID = ID;
		this.name = name;
		creation_date = date;
		questions = new ArrayList<>();
	}

	public long getExamID() {
		return ExamID;
	}

	public void setExamID(long examID) {
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
