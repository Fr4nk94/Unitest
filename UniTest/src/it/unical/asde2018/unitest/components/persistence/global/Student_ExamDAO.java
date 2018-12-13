package it.unical.asde2018.unitest.components.persistence.global;

import java.util.List;

import it.unical.asde2018.unitest.model.Student_Exam;

public interface Student_ExamDAO extends BaseDAO<Student_Exam, Long> {
	
//	method for retrieve all submitted exam for a given ExamID
	public List<Student_Exam> getAllStudentExam(long examID);

}
