package com.escaravellovermello.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.escaravellovermello.entity.Client;
import com.escaravellovermello.entity.Payment;

@Repository("paymentRepository")
public interface PaymentRepository extends JpaRepository<Payment, Serializable> {

	public abstract Payment findById(Integer id);

	public abstract List<Payment> findByClientOrderByDateDesc(@Param("client") Client client);

}
