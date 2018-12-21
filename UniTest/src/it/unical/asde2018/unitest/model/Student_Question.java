package it.unical.asde2018.unitest.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Student_Question {

//	ID of the question
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Student_QuestionID")
	private long Student_QuestionID;

//	Reference to Question given by the professor
	@OneToOne
	@JoinColumn(name = "questionID")
	private Question question;

//	Given answer for the Question
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Student_QuestionID")
	private Set<Student_Answer> answer_given;

	public Student_Question() {
	}

	public Student_Question(long questionID) {
		super();
		this.answer_given = new HashSet<>();
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public long getStudent_QuestionID() {
		return Student_QuestionID;
	}

	public void setStudent_QuestionID(long student_QuestionID) {
		Student_QuestionID = student_QuestionID;
	}

	public Set<Student_Answer> getAnswer_given() {
		return answer_given;
	}

	public void setAnswer_given(Set<Student_Answer> answer_given) {
		this.answer_given = answer_given;
	}

	public void addAnswer(Student_Answer answer) {
		this.answer_given.add(answer);
	}

}
