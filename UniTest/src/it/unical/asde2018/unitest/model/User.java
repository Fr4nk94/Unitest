package it.unical.asde2018.unitest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
//@DiscriminatorValue(value = "user") implements Serializable
public class User {

	// private static final long serialVersionUID = -4619651034034731538L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "first_name", length = 255, nullable = false)
	private String firstName;

	@Column(name = "last_name", length = 255, nullable = false)
	private String lastName;

	@Column(name = "email", length = 255, nullable = false, unique = true)
	private String email;

	@Column(name = "username", length = 255, nullable = false, unique = true)
	private String username;

	@Column(name = "password", length = 255, nullable = false)
	private String password;

	@Column(name = "role", length = 255, nullable = false)
	private String role;

	public User() {
		id = 0;
		firstName = "";
		lastName = "";
		email = "";
		username = "";
		password = "";
		role = "";
	}

	public User(Integer id, String firstName, String lastName, String email, String username, String password,
			String role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public User(String firstName, String lastName, String email, String username, String password, String role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return id + ": " + firstName + " - " + lastName;
	}

	public String getUsername() {
		return this.username;
	}

	public String getPassword() {
		return this.password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}