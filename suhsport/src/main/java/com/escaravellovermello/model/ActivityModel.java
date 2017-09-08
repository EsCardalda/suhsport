package com.escaravellovermello.model;


import javax.validation.constraints.NotNull;

public class ActivityModel {

	private Integer id;
	
	@NotNull
	private String name;

	private String despription;

	public ActivityModel() {
		super();
	}

	public ActivityModel(Integer id, String name, String despription) {
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
		return "ActivityModel [id=" + id + ", name=" + name + ", despription=" + despription + "]";
	}
	
	
}
