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
@Table(name = "discount")
public class Discount {

	@Id
	@GeneratedValue
	@Column(name = "id_discount")
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "type")
	private String type;

	@Column(name = "quantity")
	private Integer quantity;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "discount")
	private Set<Payment> payment = new HashSet<Payment>();

	public Discount() {
		super();
	}

	public Discount(Integer id, String name, String type, Integer quantity) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Discount [id=" + id + ", name=" + name + ", type=" + type + ", quantity=" + quantity + "]";
	}

}
