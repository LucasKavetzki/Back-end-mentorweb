package com.example.mentorweb.dto;

import javax.validation.constraints.NotNull;

public class MonitoriaDTO  {
	
	
	private Integer id;
	
	@NotNull(message="Preenchimento obrigatório!")
	private String local;
	
	@NotNull(message="Preenchimento obrigatório!")
	private String data;
	
	@NotNull(message="Preenchimento obrigatório!")
	private String horario;
	

	
	public MonitoriaDTO() {
		super();
		
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getLocal() {
		return local;
	}



	public void setLocal(String local) {
		this.local = local;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public String getHorario() {
		return horario;
	}



	public void setHorario(String horario) {
		this.horario = horario;
	}



	





	
}




