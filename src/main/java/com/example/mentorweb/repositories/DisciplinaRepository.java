package com.example.mentorweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mentorweb.domain.Disciplina;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

}
