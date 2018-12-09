package it.unical.asde2018.unitest.components.services;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.model.Course;

@Service
public class CourseService {

	public Set<Course> courses = new HashSet<>();

	@PostConstruct
	public void init() {
		courses.add(new Course("1", "Fondamenti", "10"));
		courses.add(new Course("2", "Oggetti", "10"));
		courses.add(new Course("3", "Analisi", "10"));
		courses.add(new Course("4", "SIW", "5"));
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public String getName(String code) {
		String name = null;
		for (Course inserted : courses) {
			if (inserted.getCode() == code) {
				name = inserted.getName();
			}
		}
		return name;
	}

	public void addCourse(Course course) {
		courses.add(course);

	}

}