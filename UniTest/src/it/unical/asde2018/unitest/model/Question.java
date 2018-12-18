package it.unical.asde2018.unitest.model;

<<<<<<< HEAD
import java.util.List;

import java.util.ArrayList;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "question")
public class Question {
//	ID of the question
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "questionID")
	private long questionID;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Question_Type type;

//	The question body is the argument
	@Column(name = "question_body")
	private String question_body;

// 	The score given if the answer is correct 	
	@Column(name = "correct_score")
	private float correctScore;

//	The score given if the answer is wrong	
	@Column(name = "wrong_score")
	private float wrongScore;

//	A Question contains a list of Answers (handling of different answer is not supported yet)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "questionID")
	private List<Answer> answers;

	@Transient
	private int internalID;

	/*
	 * @ManyToOne private Exam exam;
	 */

	public Question() {
		super();
	}

	public Question(String question_body, Question_Type type, float correctScore, float wrongScore) {
		super();
		this.answers = new ArrayList<>();
		this.question_body = question_body;
		this.type = type;
		this.correctScore = correctScore;
		this.wrongScore = wrongScore;
	}

	public int getInternalID() {
		return internalID;
	}

	public void setInternalID(int internalID) {
		this.internalID = internalID;
	}

	public long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(long questionID) {
		this.questionID = questionID;
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

	public float getCorrectScore() {
		return correctScore;
	}

	public void setCorrectScore(float correctScore) {
		this.correctScore = correctScore;
	}

	public float getWrongScore() {
		return wrongScore;
	}

	public void setWrongScore(float wrongScore) {
		this.wrongScore = wrongScore;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", type=" + type + ", question_body=" + question_body
				+ ", correctScore=" + correctScore + ", wrongScore=" + wrongScore + ", internalID=" + internalID
				+ ", answers =" + answers + "]";
	}

}
=======
import java.util.ArrayList;
import java.util.List;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "question")
public class Question {

//	ID of the question
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "questionID")
	private long questionID;

	@Enumerated(EnumType.STRING)
	@Column(name = "type")
	private Question_Type type;

//	The question body is the argument
	@Column(name = "question_body")
	private String question_body;


// 	The score given if the answer is correct 	
	@Column(name = "correct_score")
	private float correctScore;

//	The score given if the answer is wrong	
	@Column(name = "wrong_score")
	private float wrongScore;

//	A Question contains a list of Answers (handling of different answer is not supported yet)
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "questionID")
	private List<Answer> answers;
	
	@Transient
	private int internalID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Exam exam;
	
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public Question() {
		super();
	}

	public Question(String question_body, Question_Type type, float correctScore, float wrongScore) {
		super();
		this.answers = new ArrayList<>();
		this.question_body = question_body;
		this.type = type;
		this.correctScore = correctScore;
		this.wrongScore = wrongScore;
	}

	public int getInternalID() {
		return internalID;
	}

	public void setInternalID(int internalID) {
		this.internalID = internalID;
	}

	public long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(long questionID) {
		this.questionID = questionID;
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

	public float getCorrectScore() {
		return correctScore;
	}

	public void setCorrectScore(float correctScore) {
		this.correctScore = correctScore;
	}

	public float getWrongScore() {
		return wrongScore;
	}

	public void setWrongScore(float wrongScore) {
		this.wrongScore = wrongScore;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", type=" + type + ", question_body=" + question_body
				+ ", correctScore=" + correctScore + ", wrongScore=" + wrongScore + ", internalID=" + internalID
				+ ", answers =" + answers + "]";
	}
	
}
>>>>>>> refs/remotes/origin/master
