package com.escaravellovermello.converter;

import org.springframework.stereotype.Component;

import com.escaravellovermello.entity.Payment;
import com.escaravellovermello.model.PaymentModel;

@Component("paymentConverter")
public class PaymentConverter {
	
	public PaymentModel entity2model(Payment payment) {
		PaymentModel paymentModel = new  PaymentModel();
		paymentModel.setActivity(payment.getActivity());
		paymentModel.setClient(payment.getClient());
		paymentModel.setDate(payment.getDate());
		paymentModel.setFee(payment.getFee());
		paymentModel.setId(payment.getId());
		paymentModel.setPrice(payment.getPrice());
		return paymentModel;
	}
	
	public Payment model2entity(PaymentModel paymentModel) {
		Payment payment = new  Payment();
		payment.setActivity(paymentModel.getActivity());
		payment.setClient(paymentModel.getClient());
		payment.setDate(paymentModel.getDate());
		payment.setFee(paymentModel.getFee());
		payment.setId(paymentModel.getId());
		payment.setPrice(paymentModel.getPrice());
		return payment;
	}


}
