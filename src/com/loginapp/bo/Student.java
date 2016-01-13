package com.loginapp.bo;

import java.util.Date;

public class Student {

	private int contactNo = 0;
	private String firstName = null;
	private String lastName = null;
	private Date dateOfBirth = null;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int contactNo, String firstName, String lastName,
			Date dateOfBirth) {
		super();
		this.contactNo = contactNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateOfBirth = dateOfBirth;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
