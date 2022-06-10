package com.example.mentorweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.mentorweb.domain.Curso;

@Repository
public interface CursosRepository extends JpaRepository<Curso, Integer> {

}
