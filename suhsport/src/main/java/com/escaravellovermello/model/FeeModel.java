package com.escaravellovermello.model;

import javax.validation.constraints.NotNull;

public class FeeModel {
	private Integer id;
	@NotNull
	private String name;
	
	@NotNull
	private Double price;
	
	@NotNull
	private String morning_afternoon;
	
	@NotNull
	private Integer days;
	
	private boolean isActive;
	
	private boolean children;

	public FeeModel() {
		super();
	}

	public FeeModel(Integer id, String name, Double price, String morning_afternoon, Integer days, boolean isActive,
			boolean children) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.morning_afternoon = morning_afternoon;
		this.days = days;
		this.isActive = isActive;
		this.children = children;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getMorning_afternoon() {
		return morning_afternoon;
	}

	public void setMorning_afternoon(String morning_afternoon) {
		this.morning_afternoon = morning_afternoon;
	}

	public Integer getDays() {
		return days;
	}

	public void setDays(Integer days) {
		this.days = days;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public boolean isChildren() {
		return children;
	}

	public void setChildren(boolean children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "FeeModel [id=" + id + ", name=" + name + ", price=" + price + ", morning_afternoon=" + morning_afternoon
				+ ", days=" + days + ", isActive=" + isActive + ", children=" + children + "]";
	}

}
