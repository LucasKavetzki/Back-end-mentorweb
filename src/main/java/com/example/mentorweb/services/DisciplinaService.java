package com.example.mentorweb.services;

import java.util.List;
import  java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.mentorweb.domain.Disciplina;
import com.example.mentorweb.repositories.DisciplinaRepository;
import com.example.mentorweb.services.exception.ObjectNotFoundException;

@Service
public class DisciplinaService {
	
	
	@Autowired
	private DisciplinaRepository repo;
	
public Disciplina find(Integer id){
	Optional<Disciplina> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Disciplina.class.getName()));
	
//mostra mensagem de erro se o id não existir
	
	
}


public List<Disciplina> findAll(){
	return repo.findAll();	
}


	public Page<Disciplina> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
			return repo.findAll(pageRequest);
	}
	

			
}
