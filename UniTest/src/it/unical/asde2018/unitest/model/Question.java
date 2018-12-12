package it.unical.asde2018.unitest.model;

import java.util.List;

public class Question {

	private int id;						//The id to identify the question
	private String question_title;   	//The question
	Question_Type questionType;			//The Type of the answer I expected
	float correct_score;				//The value I assign to a correct answer to this question
	float wrong_score;					//The value I assign to a wrong answer to this question
	private List<Answer> answers;
	
	public Question(int id, String question_title, Question_Type questionType, float correct_score, float wrong_score, List<Answer> answers) {
		super();
		this.id = id;
		this.question_title = question_title;
		this.questionType = questionType;
		this.correct_score = correct_score;
		this.wrong_score = wrong_score;
		this.answers = answers;
	}
	
	public Question() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion_title() {
		return question_title;
	}

	public void setQuestion_title(String question_title) {
		this.question_title = question_title;
	}

	public Question_Type getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Question_Type questionType) {
		this.questionType = questionType;
	}

	public float getCorrect_score() {
		return correct_score;
	}

	public void setCorrect_score(float correct_score) {
		this.correct_score = correct_score;
	}

	public float getWrong_score() {
		return wrong_score;
	}

	public void setWrong_score(float wrong_score) {
		this.wrong_score = wrong_score;
	}
	
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public List<Answer> getAnswers(){
		return answers;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question_title=" + question_title + ", questionType=" + questionType
				+ getAnswers()+", correct_score=" + correct_score + ", wrong_score=" + wrong_score + "]";
	}
	
	
	
}
