package com.escaravellovermello.model;

import java.sql.Timestamp;

public class ClientModel {

	private Integer id;
	private String firstName;
	private String lastName1;
	private String lastName2;
	private Timestamp registrationDate;
	private Timestamp modificationDate;
	private Integer zipCode;
	private String phone;
	private String email;

	public ClientModel() {
		super();
	}

	public ClientModel(Integer id, String firstName, String lastName1, String lastName2, Timestamp registrationDate,
			Timestamp modificationDate, Integer zipCode, String phone, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName1 = lastName1;
		this.lastName2 = lastName2;
		this.registrationDate = registrationDate;
		this.modificationDate = modificationDate;
		this.zipCode = zipCode;
		this.phone = phone;
		this.email = email;
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

	public String getLastName1() {
		return lastName1;
	}

	public void setLastName1(String lastName1) {
		this.lastName1 = lastName1;
	}

	public String getLastName2() {
		return lastName2;
	}

	public void setLastName2(String lastName2) {
		this.lastName2 = lastName2;
	}

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Timestamp getModificationDate() {
		return modificationDate;
	}

	public void setModificationDate(Timestamp modificationDate) {
		this.modificationDate = modificationDate;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", firstName=" + firstName + ", lastName1=" + lastName1 + ", lastName2=" + lastName2
				+ ", registrationDate=" + registrationDate + ", modificationDate=" + modificationDate + ", zipCode=" + zipCode
				+ ", phone=" + phone + ", email=" + email + "]";
	}

}
