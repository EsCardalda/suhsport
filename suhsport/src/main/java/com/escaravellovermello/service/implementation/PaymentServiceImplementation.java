package com.escaravellovermello.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.escaravellovermello.converter.PaymentConverter;
import com.escaravellovermello.entity.Client;
import com.escaravellovermello.entity.Payment;
import com.escaravellovermello.model.PaymentModel;
import com.escaravellovermello.repository.PaymentRepository;
import com.escaravellovermello.service.PaymentService;

@Service("paymentServiceImplementation")
public class PaymentServiceImplementation implements PaymentService{

	@Autowired
	@Qualifier("paymentRepository")
	private PaymentRepository paymentRepository;
	
	@Autowired
	@Qualifier("paymentConverter")
	private PaymentConverter paymentConverter;
	
	
	@Override
	public PaymentModel addPayment(PaymentModel paymentModel) {
		Payment payment = paymentRepository.save(paymentConverter.model2entity(paymentModel));
		return paymentConverter.entity2model(payment);
	}

	@Override
	public List<PaymentModel> listAllPayments() {
		List<Payment> paymentList = paymentRepository.findAll();
		List<PaymentModel> paymentModelList = new ArrayList<>();		
		for (Payment payment : paymentList) {
			paymentModelList.add(paymentConverter.entity2model(payment));				
		}	
		return paymentModelList;	
	}

	@Override
	public List<PaymentModel> listAllPaymentsByClientOrderByDate(Client client) {
		List<Payment> paymentList = paymentRepository.findByClientOrderByDateDesc(client);
		List<PaymentModel> paymentModelList = new ArrayList<>();		
		for (Payment payment : paymentList) {
			paymentModelList.add(paymentConverter.entity2model(payment));				
		}	
		return paymentModelList;		
	}

	@Override
	public Payment getPaymentById(Integer id) {
		return paymentRepository.findById(id);
	}

	@Override
	public PaymentModel getPaymentModelById(Integer id) {
		return paymentConverter.entity2model(paymentRepository.findById(id));
	}

	@Override
	public boolean removePayment(Integer id) {
		Payment payment = getPaymentById(id);
		if (payment != null) {
			paymentRepository.delete(payment);
			return true;
		}	
		return false;
	}
}
