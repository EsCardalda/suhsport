package com.escaravellovermello.repository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escaravellovermello.entity.Fee;
@Repository("feeRepository")
public interface FeeRepository extends JpaRepository<Fee, Serializable> {
	
}
