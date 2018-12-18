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
	private long examID;

//	Name of the Exam
	@Column(nullable = false)
	private String name;

//  The max score that is possible to obtain in the exam
	@Column(name = "max_score")
	private float max_score;

//	Date of creation
	@Temporal(TemporalType.DATE)
	private Date creation_date;

//	An Exam is available whether it can be choosed by students
	@Column(name = "available")
	private boolean available = false;
	
//	An exam has a time in which it must be submitted
	@Column(name = "timeAvailable")
	private float timeAvailable;

//	The professor that creates the Exam
	@OneToOne
	@JoinColumn(name="id")
//	@Transient
	private User user;

	public float getMax_score() {
		return max_score;
	}

	public void setMax_score(float max_score) {
		this.max_score = max_score;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	// An internal ID for managing the exams in the services
	@Transient
	private int internalID;

//	An Exam contains a list of Questions
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "examID")
	private List<Question> questions;

	public Exam() {
	}

	public Exam(User user, String name, Date date, float timeAvailable) {
		this.user = user;
		this.name = name;
		creation_date = date;
		questions = new ArrayList<>();
		this.max_score = 0;
		this.timeAvailable = timeAvailable;
	}

	public int getInternalID() {
		return internalID;
	}

	public void setInternalID(int internalID) {
		this.internalID = internalID;
	}

	public long getExamID() {
		return examID;
	}

	public void setExamID(long examID) {
		examID = examID;
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

	public void setMaxScore(float score) {
		this.max_score += score;
	}

	@Override
	public String toString() {
		return "Exam [ExamID=" + examID + ", name=" + name + ", max_score=" + max_score + ", creation_date="
				+ creation_date + ", available=" + available + ", user=" + user + ", internalID=" + internalID
				+ ", questions=" + questions + "]";
	}

}
