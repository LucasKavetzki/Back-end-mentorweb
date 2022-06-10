package com.example.mentorweb.services;

import java.util.List;
import  java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mentorweb.domain.Administrador;
import com.example.mentorweb.domain.Orientador;
import com.example.mentorweb.dto.OrientadorDTO;
import com.example.mentorweb.dto.OrientadorNewDTO;
import com.example.mentorweb.repositories.AdministradorRepository;
import com.example.mentorweb.repositories.OrientadorRepository;
import com.example.mentorweb.services.exception.ObjectNotFoundException;

@Service
public class OrientadorService {
	
	
	@Autowired
	private OrientadorRepository repo;
	@Autowired
	private AdministradorRepository admrepo;
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
	
public Orientador find(Integer id){
	Optional<Orientador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Orientador.class.getName()));
	
//mostra mensagem de erro se o id não existir
	
	
}



//criação de metodo para utilizar o post, implementa um novo id automaticamente

@Transactional
public Orientador insert(Orientador obj) {
	obj.setId(null);
	obj = repo.save(obj);
	admrepo.saveAll(obj.getAdministrador());
	return obj;
	
}
//IMPLEMENTAÇÃO PUT, ATUALIZA AS INFORMAÇÕES
	public Orientador update(Orientador obj){
		find(obj.getId());
			return repo.save(obj);
	}
	
		
	
	//IMPLEMENTAÇÃO METODO DELETE
		public void delete(Integer id) {
			find(id);
			 repo.deleteById(id);
			}
	
		public Orientador fromDTO(OrientadorDTO objDto) {
			return new Orientador(objDto.getId(), objDto.getNomeCompleto(),objDto.getEmail(),null, null);
		}
		
		public List<Orientador> findAll(){
			return repo.findAll();
		}

		public Orientador fromDTO(OrientadorNewDTO objDto) {
			Orientador orien = new Orientador(null, objDto.getNomeCompleto(), objDto.getEmail(),pe.encode(objDto.getSiape()),pe.encode(objDto.getSenha()));
			Administrador ccc = new Administrador(null, objDto.getNomeCompleto(), objDto.getEmail(),pe.encode(objDto.getSenha()));
			
			orien.getAdministrador().add(ccc);
			if(objDto.getAdmiId()!=null) {
				
			}
			return orien;
		}


}
		
		
		


