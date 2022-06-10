package com.example.mentorweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.mentorweb.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;
	

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String Nome;
	
	@Column(unique=true)
	private String email;
	
	@JsonIgnore
	private String Senha;
	
	
	@JsonBackReference
	@ManyToMany(mappedBy="alunos")
	private List<Monitoria> monitorias = new ArrayList<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS_ALUNO")
	private Set<Integer> perfis = new HashSet<>();

	
	
	public Aluno() {
		addPerfil(Perfil.ALUNOS);
		
	
}



public Aluno(Integer id, String nome, String email, String senha) {
	super();
	this.id = id;
	Nome = nome;
	this.email = email;
	Senha = senha;
	addPerfil(Perfil.ALUNOS);

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


public Set<Perfil>getPerfis(){
	return perfis.stream().map( x -> Perfil.toEnum(x)).collect(Collectors.toSet());
}
public void  addPerfil(Perfil perfil) {
	perfis.add(perfil.getCod());
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
	Aluno other = (Aluno) obj;
	return Objects.equals(id, other.id);
}
















	

}
