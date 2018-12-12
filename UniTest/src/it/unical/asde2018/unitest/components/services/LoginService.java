package it.unical.asde2018.unitest.components.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.unical.asde2018.unitest.components.persistence.UserDAO;
import it.unical.asde2018.unitest.model.User;

@Service
public class LoginService {

	@Autowired
	private UserDAO userDAO;

	// public Set<Student> students = new HashSet<>();
	// public Set<Professor> professors = new HashSet<>();

	@PostConstruct
	public void init() {
	}

	public boolean login(String username, String password) {
		return userDAO.exists(new User(username, password));
	}

	public List<User> getUsers() {
		return userDAO.getAllExistentUsers();
	}

	public User getUser(String username) {
		return userDAO.getUser(username);
	}

	/*
	 * public void setStudentName(String username, String name) { for (Student
	 * student : students) { if (student.getUsername().equals(username))
	 * student.setName(name); } }
	 * 
	 * public String getStudentSurname(String username) { String surname = null; for
	 * (Student student : students) { if (student.getUsername().equals(username))
	 * surname = student.getSurname(); } return surname; }
	 * 
	 * public void setStudentSurname(String username, String surname) { for (Student
	 * student : students) { if (student.getUsername().equals(username))
	 * student.setSurname(surname); } }
	 * 
	 * public String getStudentEmail(String username) { String email = null; for
	 * (Student student : students) { if (student.getUsername().equals(username))
	 * email = student.getEmail(); } return email; }
	 * 
	 * public void setStudentEmail(String username, String email) { for (Student
	 * student : students) { if (student.getUsername().equals(username))
	 * student.setEmail(email); } }
	 * 
	 * public String getStudentAddress(String username) { String address = null; for
	 * (Student student : students) { if (student.getUsername().equals(username))
	 * address = student.getAddress(); } return address; }
	 * 
	 * public void setStudentAddress(String username, String address) { for (Student
	 * student : students) { if (student.getUsername().equals(username))
	 * student.setAddress(address); } }
	 * 
	 * public String getStudentPhone(String username) { String phone = null; for
	 * (Student student : students) { if (student.getUsername().equals(username))
	 * phone = student.getPhone(); } return phone; }
	 * 
	 * public void setStudentPhone(String username, String phone) { for (Student
	 * student : students) { if (student.getUsername().equals(username))
	 * student.setPhone(phone); } }
	 * 
	 * public List<Course> getJoinedCourses(String username) { List<Course> courses
	 * = new ArrayList<>(); for (Student student : students) { if
	 * (student.getUsername().equals(username)) student.getJoinedCourses(); } return
	 * courses; }
	 * 
	 * public void setJoinedCourses(String username, List<Course> joinedCourses) {
	 * for (Student student : students) { if
	 * (student.getUsername().equals(username))
	 * student.setJoinedCourses(joinedCourses); } }
	 * 
	 * public void addCourse(String username, Course course) { for (Student student
	 * : students) { if (student.getUsername().equals(username))
	 * student.addCourse(course); }
	 * 
	 * }
	 * 
	 * public void addCourse(String username, String courseName, String courseCode,
	 * String courseCredits) { for (Student student : students) { if
	 * (student.getUsername().equals(username)) student.addCourse(new
	 * Course(courseCode, courseName, courseCredits)); }
	 * 
	 * }
	 */

}