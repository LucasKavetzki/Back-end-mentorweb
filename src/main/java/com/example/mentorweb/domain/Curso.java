package com.example.mentorweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String Nome;
	
	@JsonBackReference
	@OneToMany(mappedBy= "curso")
	private List<Disciplina> diciplinas = new ArrayList <>();
	
	
	

	
	public Curso() {
		
	}


	



	public Curso(Integer id, String nome) {
		super();
		this.id = id;
		Nome = nome;
	}






	public String getNome() {
		return Nome;
	}






	public void setNome(String nome) {
		Nome = nome;
	}






	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	

	public List<Disciplina> getDiciplinas() {
		return diciplinas;
	}







	public void setMonitor(List<Disciplina> diciplinas) {
		this.diciplinas= diciplinas;
	}








	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}






	
	
	
	
	

}
