package it.unical.asde2018.unitest.components.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.model.Course;
import it.unical.asde2018.unitest.model.Professor;
import it.unical.asde2018.unitest.model.Student;

@Service
public class LoginService {

	public Set<Student> students = new HashSet<>();
	public Set<Professor> professors = new HashSet<>();

	@PostConstruct
	public void init() {
		students.add(new Student("Ciccio", "Pasticcio", "pasticcio@tiscali.it", "Via del Pasticcio, 8", "3333456367",
				"past", "123"));
		students.add(new Student("Jack", "Sparrow", "sparrow@tiscali.it", "Via del Pirata, 10", "3333335857", "jack",
				"123"));
		students.add(new Student("alex", "123"));
		professors.add(new Professor("ricca", "123"));
	}

	public String login(String username, String password) {
		if (students.contains(new Student(username, password)))
			return "student";
		if (professors.contains(new Professor(username, password)))
			return "professor";
		return null;
	}

	public String getSudentName(String username) {
		String name = null;
		for (Student student : students) {
			if (student.getUsername().equals(username))
				name = student.getName();
		}
		return name;
	}

	public void setStudentName(String username, String name) {
		for (Student student : students) {
			if (student.getUsername().equals(username))
				student.setName(name);
		}
	}

	public String getStudentSurname(String username) {
		String surname = null;
		for (Student student : students) {
			if (student.getUsername().equals(username))
				surname = student.getSurname();
		}
		return surname;
	}

	public void setStudentSurname(String username, String surname) {
		for (Student student : students) {
			if (student.getUsername().equals(username))
				student.setSurname(surname);
		}
	}

	public String getStudentEmail(String username) {
		String email = null;
		for (Student student : students) {
			if (student.getUsername().equals(username))
				email = student.getEmail();
		}
		return email;
	}

	public void setStudentEmail(String username, String email) {
		for (Student student : students) {
			if (student.getUsername().equals(username))
				student.setEmail(email);
		}
	}

	public String getStudentAddress(String username) {
		String address = null;
		for (Student student : students) {
			if (student.getUsername().equals(username))
				address = student.getAddress();
		}
		return address;
	}

	public void setStudentAddress(String username, String address) {
		for (Student student : students) {
			if (student.getUsername().equals(username))
				student.setAddress(address);
		}
	}

	public String getStudentPhone(String username) {
		String phone = null;
		for (Student student : students) {
			if (student.getUsername().equals(username))
				phone = student.getPhone();
		}
		return phone;
	}

	public void setStudentPhone(String username, String phone) {
		for (Student student : students) {
			if (student.getUsername().equals(username))
				student.setPhone(phone);
		}
	}

	public List<Course> getJoinedCourses(String username) {
		List<Course> courses = new ArrayList<>();
		for (Student student : students) {
			if (student.getUsername().equals(username))
				student.getJoinedCourses();
		}
		return courses;
	}

	public void setJoinedCourses(String username, List<Course> joinedCourses) {
		for (Student student : students) {
			if (student.getUsername().equals(username))
				student.setJoinedCourses(joinedCourses);
		}
	}

	public void addCourse(String username, Course course) {
		for (Student student : students) {
			if (student.getUsername().equals(username))
				student.addCourse(course);
		}

	}

	public void addCourse(String username, String courseName, String courseCode, String courseCredits) {
		for (Student student : students) {
			if (student.getUsername().equals(username))
				student.addCourse(new Course(courseCode, courseName, courseCredits));
		}

	}

}