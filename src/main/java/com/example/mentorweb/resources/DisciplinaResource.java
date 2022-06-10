package com.example.mentorweb.resources;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mentorweb.domain.Disciplina;
import com.example.mentorweb.dto.DisciplinaDTO;
import com.example.mentorweb.services.DisciplinaService;
 
@RestController
@RequestMapping(value="/disciplina")
public class DisciplinaResource {
	
	
	
	@Autowired
	private DisciplinaService service;
	
	//buscar  por id
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Disciplina> find(@PathVariable Integer id) {
		Disciplina obj = service.find(id);
		return ResponseEntity.ok().body(obj);	
	}

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Disciplina>> findAll() {
		List<Disciplina> list  = service.findAll();
			return ResponseEntity.ok().body(list);	
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<DisciplinaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0")Integer page,
			@RequestParam(value="linesPerPage", defaultValue="24")Integer linesPerPage,
			@RequestParam(value="orderBy", defaultValue="nome")String orderBy,
			@RequestParam(value="direction", defaultValue="ASC")String direction) {
			Page<Disciplina> list  = service.findPage(page, linesPerPage, orderBy, direction);			
			Page<DisciplinaDTO> listDto = list.map(obj -> new DisciplinaDTO(obj));
						return ResponseEntity.ok().body(listDto);	
	}	
	
}
