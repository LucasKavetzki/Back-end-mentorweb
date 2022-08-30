package com.example.mentorweb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.mentorweb.domain.Administrador;
import com.example.mentorweb.dto.AdministradorDTO;
import com.example.mentorweb.dto.AdministradorNewDTO;
import com.example.mentorweb.services.AdministradorService;
 
@RestController
@RequestMapping(value="/administrador")
public class AdministradorResource {
	
	@Autowired
	private AdministradorService  service;
	
	
	// BUSCA POR ID
	
		@RequestMapping(value="/{id}", method=RequestMethod.GET)
		public ResponseEntity<Administrador> find(@PathVariable Integer id) {
			Administrador obj = service.find(id);
			return ResponseEntity.ok().body(obj);	
		}	
		
		// ADICIONA UM NOVO ADMINISTRADOR
		
		@RequestMapping(method=RequestMethod.POST)
		public ResponseEntity<Void> insert(@Valid @RequestBody AdministradorNewDTO objDto) {
			Administrador obj = service.fromDTO(objDto);
			obj = service.insert(obj);
					URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
			
		}	

	
		// ATUALIZA O ID COM NOVAS INFORMAÇÕES
			@RequestMapping(value="/{id}",method=RequestMethod.PUT)
			public ResponseEntity<Void> update(@RequestBody Administrador obj, @PathVariable Integer id  ){
				obj.setId(id);
				obj = service.update(obj);
					return ResponseEntity.noContent().build();				
				
			}
		//DELETA ADMINISTRADOR
			@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
			public ResponseEntity<Void> delete( @PathVariable Integer id  ){
				service.delete(id);
				return ResponseEntity.noContent().build();	
				
			}	
		//PUXA TODOS OS ADMINISTRADORES CADASTRADOS
			@RequestMapping( method=RequestMethod.GET)
			public ResponseEntity<List<AdministradorDTO>> findAll() {
				List<Administrador> list  = service.findAll();
				// METODO DTO PUXA SÓ OBJETOS DA CLASSE EM QUSTÃO E NADA MAIS
				List<AdministradorDTO> listDto = list.stream().map(obj -> new AdministradorDTO(obj)).collect(Collectors.toList());
				return ResponseEntity.ok().body(listDto);	
			}	
			
	
		   }  
