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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.example.mentorweb.dto.MonitoriaDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Monitoria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String Local;
	private String Data;
	private String Horario;
	
	//Associações com outras classes

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="disciplina_id")
	private Disciplina disciplina;
	
	
	 
	@JsonManagedReference
	@ManyToMany  //tipo de associação
	@JoinTable(name="MONITORIA_ALUNO", // cria uma nova tabela no banco de dados
	joinColumns= @JoinColumn(name= "monitoria_id"), 
	inverseJoinColumns= @JoinColumn(name= "aluno_id")) // adiciona coluna na tabela
	private List<Aluno> alunos = new  ArrayList<>();
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name="monitor_id")
	private Monitor monitor;


	
	
	public Monitoria() {
		super();
	}

	public Monitoria(Integer id, String local, String data, String horario, Disciplina disciplina,
			Monitor monitor) {
		super();
		
	}
	

	public Monitoria(MonitoriaDTO objDTO)  {
		super();
		this.id = objDTO.getId();
		Local = objDTO.getLocal();
		Data = objDTO.getData();
		Horario = objDTO.getHorario();
			}
		
	

	



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLocal() {
		return Local;
	}

	public void setLocal(String local) {
		Local = local;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getHorario() {
		return Horario;
	}

	public void setHorario(String horario) {
		Horario = horario;
	}
	
	
	



	public List<Aluno> getAlunos() {
		return alunos;
	}




	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}




	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}


	public Monitor getMonitor() {
		return monitor;
	}


	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
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
		Monitoria other = (Monitoria) obj;
		return Objects.equals(id, other.id);
	}

		
	
	
	
	
	
}
