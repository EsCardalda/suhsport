package com.escaravellovermello.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotNull;

import com.escaravellovermello.entity.Activity;
import com.escaravellovermello.entity.Client;
import com.escaravellovermello.entity.Fee;

public class PaymentModel {

	private Integer id;

	@NotNull
	private Double price;

	@NotNull
	private Timestamp date;

	@NotNull
	private Client client;

	@NotNull
	private Activity activity;

	@NotNull
	private Fee fee;

	public PaymentModel() {
	}

	public PaymentModel(Integer id, Double price, Timestamp date, Client client, Activity activity, Fee fee) {
		super();
		this.id = id;
		this.price = price;
		this.date = date;
		this.client = client;
		this.activity = activity;
		this.fee = fee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	@Override
	public String toString() {
		return "PaymentModel [id=" + id + ", price=" + price + ", date=" + date + ", client=" + client + ", activity="
				+ activity + ", fee=" + fee + "]";
	}

}
