package it.unical.asde2018.unitest.model;

import java.util.ArrayList;
import java.util.List;

public class Student {

	private String name;
	private String surname;
	private String email;
	private String address;
	private String phone;
	private String username;
	private String password;
	private List<Course> joinedCourses;

	public Student(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.joinedCourses = new ArrayList<>();
	}

	public Student(String name, String surname, String email, String address, String phone, String username,
			String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.joinedCourses = new ArrayList<>();

	}

	public Student(String name, String surname, String email, String address, String phone, String username,
			String password, List<Course> joinedCourses) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.joinedCourses = joinedCourses;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Course> getJoinedCourses() {
		return joinedCourses;
	}

	public void setJoinedCourses(List<Course> joinedCourses) {
		this.joinedCourses = joinedCourses;
	}

	public void addCourse(Course course) {
		joinedCourses.add(course);
	}

}
