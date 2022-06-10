package com.example.mentorweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mentorweb.domain.Monitor;

@Repository
public interface MonitorRepository extends JpaRepository<Monitor, Integer> {
	
	@Transactional(readOnly=true)
	Monitor findByEmail( String email);


	

}
