package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.example.mentorweb.domain.Monitor;

public class MonitorDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
 
	
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5,max=90, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String NomeCompleto;
	
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=4,max=90, message="O tamanho deve ser entre 8 e 90 caracteres")
	private String Disciplina;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String ra;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Email(message="Email inválido")
	private String email;
	
	private String senha;

	
	public MonitorDTO() {
		
	}
	
	
public MonitorDTO(Monitor obj) {
	
	id = obj.getId();
	NomeCompleto = obj.getNomeCompleto();
	Disciplina = obj.getDisciplina();
	ra = obj.getRA();
	email = obj.getEmail();
	senha = obj.getSenha();
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




public String getDisciplina() {
	return Disciplina;
}


public void setDisciplina(String disciplina) {
	Disciplina = disciplina;
}


public String getRA() {
	return ra;
}

public void setRA(String rA) {
	ra = rA;
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
