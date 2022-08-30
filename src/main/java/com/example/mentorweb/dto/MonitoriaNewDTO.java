package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.example.mentorweb.domain.Disciplina;
import com.example.mentorweb.domain.Monitor;

public class MonitoriaNewDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
		
	private Monitor monid;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String local;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String data;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String horario;
	
	private Disciplina disciplina;
	
	private String Nome;
	private String email;
	private String senha;	

	
	public MonitoriaNewDTO() {
		
		
	}




	public Monitor getMonid() {
		return monid;
	}



	public void setMonid(Monitor monid) {
		this.monid = monid;
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



	public Disciplina getDisciplina() {
		return disciplina;
	}



	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}




	public String getNome() {
		return Nome;
	}




	public void setNome(String nome) {
		Nome = nome;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getSenha() {
		return senha;
	}




	public void setSenha(String senha) {
		this.senha = senha;
	}



	
	
}




