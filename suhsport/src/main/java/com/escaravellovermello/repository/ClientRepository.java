package com.escaravellovermello.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escaravellovermello.entity.Client;
@Repository("clientRepository")
public interface ClientRepository extends JpaRepository<Client, Serializable>{
	public abstract Client findById(Integer id);
}
