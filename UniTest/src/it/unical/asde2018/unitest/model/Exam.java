package it.unical.asde2018.unitest.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "exam")
public class Exam {
	
//	Auto-generated ID of the Exam
	@Id
	@Column(name = "examID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long ExamID;

//	Name of the Exam
	@Column(nullable = false)
	private String name;

//	Date of creation
	@Temporal(TemporalType.DATE)
	private Date creation_date;

//	An Exam is available whether it can be choosed by students
	@Transient
	private boolean available = false;

//	The professor that creates the Exam
//	@OneToOne
//	@JoinColumn(name="id")
	@Transient
	private User user;

//	An internal ID for managing the exams in the services
	@Transient
	private int internalID;
	
//	An Exam contains a list of Questions
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "examID")
	private List<Question> questions;

	public Exam() {
	}

	public Exam(User user, String name, Date date) {
		this.user = user;
		this.name = name;
		creation_date = date;
		questions = new ArrayList<>();
	}

	public int getInternalID() {
		return internalID;
	}
	
	public void setInternalID(int internalID) {
		this.internalID = internalID;
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

	@Override
	public String toString() {
		return "Exam [ExamID=" + ExamID + ", name=" + name + ", creation_date=" + creation_date + ", available="
				+ available + ", user=" + user + ", internalID=" + internalID + ", questions=" + questions + "]";
	}

}
