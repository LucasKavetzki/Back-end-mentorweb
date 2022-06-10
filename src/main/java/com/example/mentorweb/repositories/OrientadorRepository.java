package com.example.mentorweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.mentorweb.domain.Orientador;

@Repository
public interface OrientadorRepository extends JpaRepository<Orientador, Integer> {
	
	@Transactional(readOnly=true)
	Orientador findByEmail( String email);
	
}
