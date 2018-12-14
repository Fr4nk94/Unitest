package it.unical.asde2018.unitest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "answerID")
	private long answerID;

	@Column(nullable = false)
	private String answer_body;

	@Column(nullable = false)
	private boolean correct;

//	public Answer(int id, boolean isCorrect, String answer_content) {
//		super();
////			this.questionID = questionID;
//		this.id = id;
//		this.isCorrect = isCorrect;
//		this.answer_content = answer_content;
//	}
	/*
	 * @ManyToOne private Question question;
	 */

	public Answer() {
	}

	public Answer(String text, boolean correct) {
		super();
		this.answer_body = text;
		this.correct = correct;
	}

	public long getAnswerID() {
		return answerID;
	}

	public void setAnswerID(long answerID) {
		this.answerID = answerID;
	}

	public String getAnswer_body() {
		return answer_body;
	}

	public void setAnswer_body(String answer_body) {
		this.answer_body = answer_body;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	@Override
	public String toString() {
		return "Answer [answerID=" + answerID + ", answer_body=" + answer_body + ", correct=" + correct + "]";
	}

}
