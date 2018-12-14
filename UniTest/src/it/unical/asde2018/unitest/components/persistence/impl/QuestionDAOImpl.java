package it.unical.asde2018.unitest.components.persistence.impl;

import org.springframework.stereotype.Repository;

import it.unical.asde2018.unitest.components.persistence.global.AbstractBaseDAO;
import it.unical.asde2018.unitest.model.Question;

@Repository
public class QuestionDAOImpl extends AbstractBaseDAO<Question, Long>{

	public QuestionDAOImpl() {
		super(Question.class);
	}

}
