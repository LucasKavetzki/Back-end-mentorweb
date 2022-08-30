package com.example.mentorweb.services;

import java.util.List;
import  java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.mentorweb.domain.Monitoria;
import com.example.mentorweb.dto.MonitoriaDTO;
import com.example.mentorweb.repositories.MonitoriaRepository;
import com.example.mentorweb.services.exception.ObjectNotFoundException;

@Service
public class MonitoriaService {
	
	@Autowired
	private MonitoriaRepository repo;
	
		
public Monitoria find(Integer id){
	Optional<Monitoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Monitoria.class.getName()));
	//mostra msg de erro se o id não existir	
	
}

public List<Monitoria> findAll(){
	return repo.findAll();
}

public Page<Monitoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
	PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
}


	public Monitoria create(MonitoriaDTO obj) {
		obj.setId(null);
		Monitoria newObj = new Monitoria(obj);
		return  repo.save(newObj);	
		
	}
	
	
	
	public void delete(Integer id) {
		find(id);
		 repo.deleteById(id);
		}
	


	
}
