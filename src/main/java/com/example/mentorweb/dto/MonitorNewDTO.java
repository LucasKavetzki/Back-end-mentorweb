package com.example.mentorweb.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.example.mentorweb.domain.Monitoria;


public class MonitorNewDTO  implements Serializable {
	private static final long serialVersionUID = 1L;
 
	
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String NomeCompleto;
	
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Disciplina;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String ra;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Email(message="Email inválido")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Local;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Data;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Horario;
	
	
	private Monitoria monitoId ;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String Senha;


	
public MonitorNewDTO() {
		
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
	return Senha;
}


public void setSenha(String senha) {
	Senha = senha;
}
	
	public String getRa() {
		return ra;
	}


	public void setRa(String ra) {
		this.ra = ra;
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

