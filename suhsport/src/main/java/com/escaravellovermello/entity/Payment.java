package com.escaravellovermello.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	@Id
	@GeneratedValue
	@Column(name = "id_payment")
	private Integer id;

	@Column(name = "price")
	private Double price;

	@Column(name = "date")
	private Timestamp date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_client", nullable = false)
	private Client client;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_activity", nullable = false)
	private Activity activity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fee", nullable = false)
	private Fee fee;

	public Payment() {
		super();
	}

	public Payment(Integer id, Double price, Timestamp date, Client client, Activity activity, Fee fee) {
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
		return "Payment [id=" + id + ", price=" + price + ", date=" + date + ", client=" + client + ", activity="
				+ activity + ", fee=" + fee + "]";
	}

}