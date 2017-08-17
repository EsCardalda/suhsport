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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "client")
public class Client {

	@Id
	@GeneratedValue
	@Column(name = "id_client")
	private Integer id;

	@NotNull
	@NotEmpty(message="No puede estar vacío")
	@Size(max = 50, message="Máximo 50 caracteres")
	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@NotNull
	@NotEmpty(message="No puede estar vacío")
	@Size(max = 50 , message="Máximo 50 caracteres")
	@Column(name = "last_name_1", nullable = false, length = 50)
	private String lastName1;

	@Size(max = 50, message="Máximo 50 caracteres")
	@Column(name = "last_name_2", length = 50)
	private String lastName2;

	@Column(name = "registration_date")
	private Timestamp registrationDate;

	@Column(name = "modification_date")
	private Timestamp modificationDate;

	@Column(name = "zip_code", length = 5)
	private Integer zipCode;
		
	@Column(name = "phone", length=9)
	private String phone;

	@Column(name = "email")
	private String email;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "client")
	private Set<Payment> payment = new HashSet<Payment>();

	public Client() {
		super();
	}

	public Client(Integer id, String firstName, String lastName1, String lastName2, Timestamp registrationDate,
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
				+ ", registrationDate=" + registrationDate + ", modificationDate=" + modificationDate + ", zipCode="
				+ zipCode + ", phone=" + phone + ", email=" + email + "]";
	}

}
