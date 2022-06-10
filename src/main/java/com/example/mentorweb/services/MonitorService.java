package com.example.mentorweb.services;

import java.util.List;
import  java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mentorweb.domain.Monitor;
import com.example.mentorweb.domain.Monitoria;
import com.example.mentorweb.dto.MonitorDTO;
import com.example.mentorweb.dto.MonitorNewDTO;
import com.example.mentorweb.repositories.MonitorRepository;
import com.example.mentorweb.repositories.MonitoriaRepository;
import com.example.mentorweb.services.exception.ObjectNotFoundException;

@Service
public class MonitorService {
	
	
	@Autowired
	private MonitorRepository repo;
	
	@Autowired
	private MonitoriaRepository monirepo;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	
	
public Monitor find(Integer id){
	Optional<Monitor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Monitor.class.getName()));
	
//mostra mensagem de erro se o id não existir
	
	
}


//criação de metodo para utilizar o post, implementa um novo id automaticamente
@Transactional
public Monitor insert(Monitor obj) {
	obj.setId(null);
	obj = repo.save(obj);
	monirepo.saveAll(obj.getMonitorias());
	return obj;
	
}


//IMPLEMENTAÇÃO PUT, ATUALIZA AS INFORMAÇÕES
	public Monitor update(Monitor obj){
		find(obj.getId());
			return repo.save(obj);
	}
	
		
	
	//IMPLEMENTAÇÃO METODO DELETE
		public void delete(Integer id) {
			find(id);
			 repo.deleteById(id);
			}
		
	
		public Monitor fromDTO(MonitorDTO objDto) {
			return new Monitor(objDto.getId(), objDto.getNomeCompleto(),objDto.getDisciplina(),objDto.getEmail(),null,null);
		}
		
		
		public List<Monitor> findAll(){
			return repo.findAll();
		}

		
		
		
		public Monitor fromDTO(MonitorNewDTO objDto) {
			Monitor mtr1 = new Monitor(null, objDto.getNomeCompleto(),objDto.getDisciplina(),objDto.getEmail(),objDto.getRA(),pe.encode(objDto.getSenha()));
			Monitoria moni = new Monitoria(null, objDto.getLocal(),objDto.getData(),objDto.getHorario(), null, mtr1);
			
			mtr1.getMonitorias().add(moni);
			if(objDto.getMonitoId()!=null) {
				
			}
			return mtr1;
		}

		
		
		
		
}

