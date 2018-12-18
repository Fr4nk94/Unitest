package it.unical.asde2018.unitest.components.persistence.global;

import java.util.List;

import it.unical.asde2018.unitest.model.Exam;

public interface ExamDAO extends BaseDAO<Exam, Long> {
	
	public List<Exam> getAllExams();
	public List<Exam> getPage(int sPos,int nExams);
	
}
