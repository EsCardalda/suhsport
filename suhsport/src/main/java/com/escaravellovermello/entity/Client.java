package com.escaravellovermello.entity;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue
	@Column(name = "id_client")
	private Integer id;

	@Column(name = "first_name", nullable = false)
	@Max(value = 50)
	private String fisrtName;

	@Column(name = "last_name_1", nullable = false)
	@Max(value = 50)
	private String lastName_1;

	@Column(name = "last_name_2")
	@Max(value = 50)
	private String lastName2;

	@Column(name = "registration_date")
	private Timestamp registrationDate;

	@Column(name = "modification_date")
	private Timestamp modificationDate;

	@Column(name = "town")
	@Max(value = 50)
	private String town;

	@Column(name = "phone", nullable = false)
	@Pattern(regexp = "\\d{9}")
	private String phone;

	@Column(name = "email")
	@Pattern(regexp = "(([^<>()\\[\\]\\.,;:\\s@\\\"]+(\\.[^<>()\\[\\]\\.,;:\\s@\\\"]+)*)|(\\\".+\\\"))@(([^<>()[\\]\\.,;:\\s@\\\"]+\\.)+[^<>()[\\]\\.,;:\\s@\\\"]{2,})")
	private String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
	private Set<Payment> payment = new HashSet<Payment>();
	
	public Client() {
		super();
	}

	public Client(Integer id, String fisrtName, String lastName_1, String lastName2, Timestamp registrationDate,
			Timestamp modificationDate, String town, String phone, String email) {
		super();
		this.id = id;
		this.fisrtName = fisrtName;
		this.lastName_1 = lastName_1;
		this.lastName2 = lastName2;
		this.registrationDate = registrationDate;
		this.modificationDate = modificationDate;
		this.town = town;
		this.phone = phone;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFisrtName() {
		return fisrtName;
	}

	public void setFisrtName(String fisrtName) {
		this.fisrtName = fisrtName;
	}

	public String getLastName_1() {
		return lastName_1;
	}

	public void setLastName_1(String lastName_1) {
		this.lastName_1 = lastName_1;
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

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
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
		return "Client [id=" + id + ", fisrtName=" + fisrtName + ", lastName_1=" + lastName_1 + ", lastName2="
				+ lastName2 + ", registrationDate=" + registrationDate + ", modificationDate=" + modificationDate
				+ ", town=" + town + ", phone=" + phone + ", email=" + email + "]";
	}

}
