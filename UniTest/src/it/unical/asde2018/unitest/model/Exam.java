package it.unical.asde2018.unitest.model;

import java.util.Date;
import java.util.List;

public class Exam {

	private int id;							//exam ID
	private String name;					//The name of the exam
	private Exam_Type examType;				//The type of exam
	private List<Question> questions;		//A list of questions present in the exam 
	private Date creationDate;				//The date of the creation of the exam
	private boolean isAvailable;			//This field shows if the exam is available to one student or not
	
	public Exam(int id, String name, Exam_Type examType, List<Question> questions, 
			Date creationDate, boolean isAvailable) {
		super();
		this.id = id;
		this.name = name;
		this.examType = examType;
		this.questions = questions;
		this.creationDate = creationDate;
		this.isAvailable = isAvailable;
	}

	public Exam() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Exam_Type getExamType() {
		return examType;
	}

	public void setExamType(Exam_Type examType) {
		this.examType = examType;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void addQuestion(Question q) {
		questions.add(q);
	}

	@Override
	public String toString() {
		return "Exam [id=" + id + ", name=" + name + ", examType=" + examType + ", questions=" + questions
				+ ", creationDate=" + creationDate + ", isAvailable=" + isAvailable + "]";
	}
	
}
