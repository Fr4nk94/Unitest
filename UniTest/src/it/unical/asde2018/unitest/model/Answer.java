package it.unical.asde2018.unitest.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {

	@Id
	@Column(name = "id")
	private int id; // The id of the current answer

	@ManyToOne(cascade = CascadeType.ALL)
	private Question question; // The id of the question associated to this answer

	private boolean isCorrect; // This value shows if this answer is correct or not

	private String answer_content; // This is the content of the answer, showed to the student

	// TODO done for testing purposes
//	public Answer(int id, boolean isCorrect, String answer_content) {
//		super();
//		this.id = id;
//		this.isCorrect = isCorrect;
//		this.answer_content = answer_content;
//	}

	public Answer(int id, boolean isCorrect, String answer_content) {
		super();
		this.id = id;
		this.isCorrect = isCorrect;
		this.answer_content = answer_content;
	}

	public Answer() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public String getAnswer_content() {
		return answer_content;
	}

	public void setAnswer_content(String answer_content) {
		this.answer_content = answer_content;
	}
//
//	@Override
//	public String toString() {
//		return "Answer [questionID=" + questionID + ", id=" + id + ", isCorrect=" + isCorrect + ", answer_content="
//				+ answer_content + "]";
//	}

}