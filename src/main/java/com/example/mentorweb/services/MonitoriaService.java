package com.example.mentorweb.services;

import java.util.List;
import  java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.mentorweb.domain.Monitoria;
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


//IMPLEMENTAÇÃO PUT, ATUALIZA AS INFORMAÇÕES
	public Monitoria update(Monitoria obj){
		find(obj.getId());
			return repo.save(obj);
	}


}
