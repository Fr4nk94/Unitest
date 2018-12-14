package it.unical.asde2018.unitest.components.persistence.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import it.unical.asde2018.unitest.components.persistence.global.AbstractBaseDAO;
import it.unical.asde2018.unitest.components.persistence.global.Student_ExamDAO;
import it.unical.asde2018.unitest.model.Student_Exam;

@Repository
public class StudentExamDAOImpl extends AbstractBaseDAO<Student_Exam, Long> implements Student_ExamDAO{

	public StudentExamDAOImpl() {
		super(Student_Exam.class);
	}

	@Override
	public List<Student_Exam> getAllStudentExam(long examID) {
		// TODO Auto-generated method stub
		return null;
	}

}
