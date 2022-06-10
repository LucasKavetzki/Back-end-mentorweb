package com.example.mentorweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mentorweb.domain.Monitoria;

@Repository
public interface MonitoriaRepository extends JpaRepository<Monitoria, Integer> {

}
