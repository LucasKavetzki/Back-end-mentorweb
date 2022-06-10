package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.mentorweb.domain.Monitoria;

public class AlunoNewDTO implements Serializable {
	private static final long serialVersionUID = 1L;
 
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5,max=90, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String Nome;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Email(message="Email inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Senha;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Local;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Data;
	
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Horario;
	
	
	private Monitoria monitoId ;
	
	
	public AlunoNewDTO() {
		
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
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


	public Monitoria getMonitoId() {
		return monitoId;
	}


	public void setMonitoId(Monitoria monitoId) {
		this.monitoId = monitoId;
	}


}
