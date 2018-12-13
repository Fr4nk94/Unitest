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
import javax.persistence.Transient;

@Entity
@Table
public class Student_Exam {

//	Auto-generated ID for DB
	@Id
	@Column(name = "Student_ExamID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long Student_ExamID;

//	ID of the Exam created by a Professor
	@OneToOne
	@JoinColumn(name = "examID")
	private long ExamID;

//	Date of the taken Exam
	@Column(nullable = false)
	private Date submission_date;

//	Student that submits the Exam
	@Transient // Temporary annotation
	private User user;

//	List of the Question given by the Student
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "examID")
	private List<Student_Question> given_question;

	public Student_Exam() {
	}

	public Student_Exam(long examID, Date submission_date, User user) {
		super();
		ExamID = examID;
		this.submission_date = submission_date;
		this.user = user;
		this.given_question = new ArrayList<>();
	}

	public long getExamID() {
		return ExamID;
	}

	public void setExamID(long examID) {
		ExamID = examID;
	}

	public Date getSubmission_date() {
		return submission_date;
	}

	public void setSubmission_date(Date submission_date) {
		this.submission_date = submission_date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Student_Question> getGiven_question() {
		return given_question;
	}

	public void setGiven_question(List<Student_Question> given_question) {
		this.given_question = given_question;
	}

	public void addQuestion(Student_Question question) {
		this.given_question.add(question);
	}
}
