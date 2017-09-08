package com.escaravellovermello.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escaravellovermello.entity.Discount;

@Repository("discountRepository")
public interface DiscountRepository extends JpaRepository<Discount, Serializable>{
}
