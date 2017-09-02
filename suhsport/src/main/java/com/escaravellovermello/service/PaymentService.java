package com.escaravellovermello.service;

import java.util.List;

import com.escaravellovermello.entity.Client;
import com.escaravellovermello.entity.Payment;
import com.escaravellovermello.model.PaymentModel;

public interface PaymentService {	
	public abstract PaymentModel addPayment(PaymentModel paymentModel);
	public abstract List<PaymentModel> listAllPayments();
	public abstract List<PaymentModel> listAllPaymentsByClientOrderByDate(Client client);
	public abstract Payment getPaymentById(Integer id);
	public abstract PaymentModel getPaymentModelById(Integer id);
	public abstract boolean removePayment(Integer id);	
}
