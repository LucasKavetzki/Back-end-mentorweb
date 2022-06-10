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

import com.example.mentorweb.domain.Monitor;
import com.example.mentorweb.dto.MonitorDTO;
import com.example.mentorweb.services.MonitorService;
 
@RestController
@RequestMapping(value="/monitor")
public class MonitorResource {
	
	
	
	@Autowired
	private MonitorService service;
	
	//buscar monitor por id
	
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<Monitor> find(@PathVariable Integer id) {
		Monitor obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}	
	
	
	//ADICINA MONITOR
	
			@RequestMapping(method=RequestMethod.POST)
			public ResponseEntity<Void> insert(@Valid @RequestBody MonitorDTO objDto) {
				Monitor obj = service.fromDTO(objDto);
				obj = service.insert(obj);
				URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
						.path("/{id}").buildAndExpand(obj.getId()).toUri();
				return ResponseEntity.created(uri).build();
				
			}	
			
			// ATUALIZA O ID COM NOVAS INFORMAÇÕES
			
			@RequestMapping(value="/{id}",method=RequestMethod.PUT)
			public ResponseEntity<Void> update(@Valid @RequestBody MonitorDTO objDto, @PathVariable Integer id  ){
				Monitor obj = service.fromDTO(objDto);
				obj.setId(id);
				obj = service.update(obj);
					return ResponseEntity.noContent().build();	
			}
	
		
					
		//DELETA MONITOR
			
		@RequestMapping(value="{id}",method=RequestMethod.DELETE)
		public ResponseEntity<Void> delete( @PathVariable Integer id  ){
			service.delete(id);
			return ResponseEntity.noContent().build();	
			
		}
		
		//BUSCA GERAL
		
				@RequestMapping(method=RequestMethod.GET)
				public ResponseEntity<List<Monitor>>  findAll() {
					List<Monitor> list  = service.findAll();
					 return ResponseEntity.ok().body(list);	
					}
				
				
				
}
