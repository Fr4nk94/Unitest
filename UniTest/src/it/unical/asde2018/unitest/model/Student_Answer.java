package it.unical.asde2018.unitest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Student_Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_answerID")
	private long student_answerID;

	@Column(nullable = false)
	private String answer_given;

	public Student_Answer() {
	}

	public Student_Answer(long id, String answer) {
		answer_given = answer;
	}

	public String getAnswer_given() {
		return answer_given;
	}

	public void setAnswer_given(String answer_given) {
		this.answer_given = answer_given;
	}

	public long getStudent_answerID() {
		return student_answerID;
	}

	public void setStudent_answerID(long student_answerID) {
		this.student_answerID = student_answerID;
	}

}
