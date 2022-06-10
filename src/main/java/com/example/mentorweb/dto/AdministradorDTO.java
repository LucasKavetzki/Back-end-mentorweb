package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.mentorweb.domain.Administrador;

public class AdministradorDTO implements Serializable {
	private static final long serialVersionUID = 1L; 
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=8,max=90, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String NomeCompleto;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Senha;
	
	
	
	public AdministradorDTO() {
		
	}


	public AdministradorDTO(Administrador obj) {
		// vai instanciar a partir do Administrador
		
		id = obj.getId();
		NomeCompleto = obj.getNomeCompleto();
		email = obj.getEmail();
		Senha = obj.getSenha();
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getNomeCompleto() {
		return NomeCompleto;
	}



	public void setNomeCompleto(String nomeCompleto) {
		NomeCompleto = nomeCompleto;
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

	
}
