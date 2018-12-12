package it.unical.asde2018.unitest.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "exam")
public class Exam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "code", length = 255, nullable = false, unique = true)
	private String code;

	@Column(name = "name", length = 255, nullable = false, unique = true)
	private String name;

	private Date creationDate; // The date of the creation of the exam

	private boolean isAvailable;

	private Exam_Type examType; // The type of exam
	// @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade =
	// CascadeType.ALL)
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "exam")
	private List<Question> questions; // A list of questions present in the exam

	public Exam() {
		id = 0;
		code = "";
		name = "";
		creationDate = null;
		isAvailable = false;
		examType = null;
	}

	public Exam(Integer id, String code, String name, Date creationDate, boolean isAvailable, Exam_Type examType) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.creationDate = creationDate;
		this.isAvailable = isAvailable;
		this.examType = examType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
