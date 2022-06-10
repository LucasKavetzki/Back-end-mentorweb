package com.example.mentorweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="curso_id")
	private Curso curso;
	
	@JsonBackReference
	@OneToMany(mappedBy="disciplina")
	private List<Monitoria> monitorias = new ArrayList<>();
	
		
	
	
	
	public Disciplina(){
		
	}
	
	public Disciplina(Integer id, String nome, Curso curso) {
		super();
		this.id = id;
		this.nome = nome;
		this.curso = curso;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}







	public List<Monitoria> getMonitorias() {
		return monitorias;
	}







	public void setMonitorias(List<Monitoria> monitorias) {
		this.monitorias = monitorias;
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
		Disciplina other = (Disciplina) obj;
		return Objects.equals(id, other.id);
	}


	

	
}
