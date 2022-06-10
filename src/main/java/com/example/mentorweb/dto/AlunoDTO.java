package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.mentorweb.domain.Aluno;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
 
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5,max=90, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String Nome;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Senha;
	
	public AlunoDTO() {
		
	}
	
	public AlunoDTO(Aluno obj) {
		
		id = obj.getId();
		Nome = obj.getNome();
		email = obj.getEmail();
		Senha = obj.getSenha();
		
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


}
