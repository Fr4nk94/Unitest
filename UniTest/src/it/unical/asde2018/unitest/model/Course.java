package it.unical.asde2018.unitest.model;

public class Course {

	private String code;
	private String name;
	private String credits;
	/// /private byte[] image;

	public Course(String code, String name, String credits) {
		this.code = code;
		this.name = name;
		this.credits = credits;
	}

	public Course(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCredits() {
		return this.credits;
	}

	public void setCredits(String credits) {
		this.credits = credits;
	}
	/*
	 * public byte[] getImage() { return image; }
	 * 
	 * public void setImage(byte[] image) { this.image = image; }
	 */
}
