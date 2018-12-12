package it.unical.asde2018.unitest.components.persistence;

import java.util.List;

import it.unical.asde2018.unitest.components.persistence.global.BaseDAO;
import it.unical.asde2018.unitest.model.Exam;

public interface ExamDAO extends BaseDAO<Exam, Long> {
	
	public List<Exam> getAllExams();
	
}
