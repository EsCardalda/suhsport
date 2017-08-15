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

@Entity
@Table(name = "fee")
public class Fee {

	@Id
	@GeneratedValue
	@Column(name = "id_fee")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "price")
	private Double price;

	@Column(name = "morning_afternoon")
	private String morning_afternoon;

	@Column(name = "days")
	private Integer days;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "for_children")
	private boolean children;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "fee")
	private Set<Payment> payment = new HashSet<Payment>();

	public Fee() {
		super();
	}

	public Fee(Integer id, String name, Double price, String morning_afternoon, Integer days, boolean isActive,
			boolean children, Set<Payment> payment) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.morning_afternoon = morning_afternoon;
		this.days = days;
		this.isActive = isActive;
		this.children = children;
		this.payment = payment;
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

	public Set<Payment> getPayment() {
		return payment;
	}

	public void setPayment(Set<Payment> payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "Fee [id=" + id + ", name=" + name + ", price=" + price + ", morning_afternoon=" + morning_afternoon
				+ ", days=" + days + ", isActive=" + isActive + ", children=" + children + ", payment=" + payment + "]";
	}

}
