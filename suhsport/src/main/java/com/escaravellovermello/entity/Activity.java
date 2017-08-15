package com.escaravellovermello.entity;

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

@Entity
@Table(name = "activity")
public class Activity {

	@Id
	@GeneratedValue
	@Column(name = "id_activity")
	private Integer id;

	@Column(name = "name")
	@Max(value = 50)
	private String name;

	@Column(name = "description")
	@Max(value = 150)
	private String despription;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "activity")
	private Set<Payment> payment = new HashSet<Payment>();
	
	public Activity() {
		super();
	}

	public Activity(Integer id, String name, String despription) {
		super();
		this.id = id;
		this.name = name;
		this.despription = despription;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDespription() {
		return despription;
	}

	public void setDespription(String despription) {
		this.despription = despription;
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", despription=" + despription + "]";
	}

}
