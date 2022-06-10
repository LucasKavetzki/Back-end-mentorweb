package com.example.mentorweb.resources;



import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.mentorweb.domain.Aluno;
import com.example.mentorweb.dto.AlunoDTO;
import com.example.mentorweb.services.AlunoService;
 
@RestController
@RequestMapping(value="/aluno")
public class AlunoResource {
	
	
	
	@Autowired
	private AlunoService service;
	
	
	
	
	//buscar orientador por id
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Aluno> find(@PathVariable Integer id) {
		Aluno obj = service.find(id);
		return ResponseEntity.ok().body(obj);	
	}
	
	//BUSCA GERAL
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Aluno>>  findAll() {
		List<Aluno> list  = service.findAll();
		 return ResponseEntity.ok().body(list);	
		}
	
	
	// ATUALIZA O ID COM NOVAS INFORMAÇÕES
		@RequestMapping(value="/{id}",method=RequestMethod.PUT)
			public ResponseEntity<Void> update(@RequestBody Aluno obj, @PathVariable Integer id  ){
					obj.setId(id);
					 obj = service.update(obj);
						return ResponseEntity.noContent().build();				
					
				}
	
//ADICIONAR ALUNO
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AlunoDTO objDto) {
		Aluno obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}	

	//DELETA ALUNO
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete( @PathVariable Integer id  ){
		service.delete(id);
		return ResponseEntity.noContent().build();	
		
	}	
}
