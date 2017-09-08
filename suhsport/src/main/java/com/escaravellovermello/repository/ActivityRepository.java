package com.escaravellovermello.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.escaravellovermello.entity.Activity;
@Repository("activityRepository")
public interface ActivityRepository extends JpaRepository<Activity, Serializable>{
	
	

}
