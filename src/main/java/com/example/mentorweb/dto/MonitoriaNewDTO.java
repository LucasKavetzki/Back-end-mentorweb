package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.example.mentorweb.domain.Disciplina;
import com.example.mentorweb.domain.Monitor;

public class MonitoriaNewDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Local;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Data;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Horario;
	
	
	private Disciplina disciplina;
	
	
	private Monitor monitor;

	
	public MonitoriaNewDTO() {
		
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
	
	
	
	

}
