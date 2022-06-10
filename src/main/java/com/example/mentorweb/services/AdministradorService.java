package com.example.mentorweb.services;



import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mentorweb.domain.Administrador;
import com.example.mentorweb.domain.Orientador;
import com.example.mentorweb.dto.AdministradorDTO;
import com.example.mentorweb.dto.AdministradorNewDTO;
import com.example.mentorweb.repositories.AdministradorRepository;
import com.example.mentorweb.repositories.OrientadorRepository;
import com.example.mentorweb.services.exception.DateIntegrityException;
import com.example.mentorweb.services.exception.ObjectNotFoundException;

@Service
public class AdministradorService {
	
	@Autowired
	private AdministradorRepository repo;
	@Autowired
	private OrientadorRepository orienrepo;
	@Autowired
	private BCryptPasswordEncoder pe;
	
	
					
	public Administrador find(Integer id){
		Optional<Administrador> obj = repo.findById(id);
		return obj.orElseThrow(() ->  new ObjectNotFoundException(
				"Objeto não encontrado! Id: "  + id + ",  Tipo: "  + Administrador.class.getName()));
		//mostra msg de erro se o id não existir
}
	

	//  criação de metodo para utilizar o post, implementa um novo id automaticamente
	@Transactional
	public Administrador insert(Administrador obj) {
		obj.setId(null);
		obj = repo.save(obj);
		orienrepo.saveAll(obj.getOrientadores());
		return obj;
	}
	
	
	
	// IMPLEMENTAÇÃO PUT, ATUALIZA AS INFORMAÇÕES
	public Administrador update(Administrador obj){
		find(obj.getId());
			return repo.save(obj);
	}
	
	
	//IMPLEMENTAÇÃO METODO DELETE
	public void delete(Integer id) {
		find(id);
		try {
		 repo.deleteById(id);
		}
		// COLOQUEI UMA MSG PARA AVISAR QUE O ADMINISTRADOR NÃO PODE SER EXCLUIDO
		catch (DataIntegrityViolationException e ) {
			throw new DateIntegrityException("Não é possivel excluir o Administrador");
			
		}
	}
	// LISTA TODOS OS ADMINISTRADORES
	public List<Administrador> findAll(){
		return repo.findAll();
	}
	public Administrador fromDTO(@Valid AdministradorDTO objDto) {
		return new Administrador(objDto.getId(), objDto.getNomeCompleto(),objDto.getEmail(),objDto.getSenha());
	}
	
	
public Administrador fromDTO( AdministradorNewDTO objDto) {
		Administrador cli = new Administrador(null, objDto.getNomeCompleto(), objDto.getEmail(),pe.encode(objDto.getSenha()));
		Orientador ori = new Orientador(null, objDto.getNomeCompleto(),objDto.getEmail(),pe.encode(objDto.getSiape()),pe.encode(objDto.getSenha()));
		
		cli.getOrientadores().add(ori);	
		if(objDto.getOrienid()!=null) {
			
		}
		return cli;
	} 
	
	
}
	

