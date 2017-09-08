package com.escaravellovermello.model;

public class DiscountModel {
	private Integer id;
	private String name;
	private String type;
	private Integer quantity;
	

	public DiscountModel() {
		super();
	}

	public DiscountModel(Integer id, String name, String type, Integer quantity) {
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
		return "DiscountModel [id=" + id + ", name=" + name + ", type=" + type + ", quantity=" + quantity + "]";
	}

}
