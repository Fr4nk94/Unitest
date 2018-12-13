package it.unical.asde2018.unitest.components.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.model.Exam;
import it.unical.asde2018.unitest.model.Exam_Type;


@Service
public class ExamsService {

	List<Exam> exams;

	@PostConstruct
	public void init() {
		exams = new ArrayList<>();

		Exam e1 = new Exam(0, "Analisi", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Cianciaruso");
		Exam e2 = new Exam(1, "Basi di Dati", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Rullo");
		Exam e3 = new Exam(2, "Fondamenti", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Perri");
		Exam e4 = new Exam(3, "Ingegneria", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Ricca");

		Exam e5 = new Exam(4, "Analisi", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Cianciaruso");
		Exam e6 = new Exam(5, "Basi di Dati", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Rullo");
		Exam e7 = new Exam(6, "Fondamenti", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Perri");
		Exam e8 = new Exam(7, "Ingegneria", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Ricca");

		Exam e9 = new Exam(8, "Analisi", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Cianciaruso");
		Exam e10 = new Exam(9, "Basi di Dati", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Rullo");
		Exam e11 = new Exam(10, "Fondamenti", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Perri");
		Exam e12 = new Exam(11, "Ingegneria", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Ricca");

		Exam e13 = new Exam(12, "Analisi", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Cianciaruso");
		Exam e14 = new Exam(13, "Basi di Dati", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Rullo");
		Exam e15 = new Exam(14, "Fondamenti", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Perri");
		Exam e16 = new Exam(15, "Ingegneria", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Ricca");

		Exam e17 = new Exam(16, "Analisi", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Cianciaruso");
		Exam e18 = new Exam(17, "Basi di Dati", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Rullo");
		Exam e19 = new Exam(18, "Fondamenti", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Perri");
		Exam e20 = new Exam(19, "Ingegneria", Exam_Type.MIXED, Date.valueOf(LocalDate.now()), true, "Ricca");

		exams.add(e1);
		exams.add(e2);
		exams.add(e3);
		exams.add(e4);
		exams.add(e5);
		exams.add(e6);
		exams.add(e7);
		exams.add(e8);
		exams.add(e9);
		exams.add(e10);
		exams.add(e11);
		exams.add(e12);
		exams.add(e13);
		exams.add(e14);
		exams.add(e15);
		exams.add(e16);
		exams.add(e17);
		exams.add(e18);
		exams.add(e19);
		exams.add(e20);
	}

	public List<Exam> getExams() {
		return exams;
	}

	
	//Ritorna una lista con gli esami presenti in una pagina.
	//Da migliorare magari rendendo parametrico il numero di esami nella pagina.
	public List<Exam> getPage(int pageNumber) {
		int start = (pageNumber - 1) * 5;
		int end = ((pageNumber - 1) * 5) + 5;
		return exams.subList(start, end);
	}

}
