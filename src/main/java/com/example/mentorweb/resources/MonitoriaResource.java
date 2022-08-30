package com.example.mentorweb.resources;



import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.mentorweb.domain.Monitoria;
import com.example.mentorweb.dto.MonitoriaDTO;
import com.example.mentorweb.services.MonitoriaService;


@RestController
@RequestMapping(value="/monitoria")
public class MonitoriaResource {
	
	
	
	@Autowired
	private MonitoriaService service;
	
	
	//buscar monitor por id
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Monitoria> find(@PathVariable Integer id) {
		Monitoria obj = service.find(id);
		return ResponseEntity.ok().body(obj);
		
		
		
	}

	
	//BUSCA GERAL
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Monitoria>>  findAll() {
		List<Monitoria> list  = service.findAll();
		 return ResponseEntity.ok().body(list);	
		}
	
	
	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> create( @RequestBody MonitoriaDTO objDTO){
		Monitoria newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		
	}


	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete( @PathVariable Integer id  ){
		service.delete(id);
		return ResponseEntity.noContent().build();	
		
	}	

	
	}
