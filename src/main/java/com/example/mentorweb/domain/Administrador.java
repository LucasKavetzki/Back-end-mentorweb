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
import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity	
public class Administrador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String NomeCompleto;
	
	@Column(unique=true)
	private String email;
	//CAMPO IGNORADO
	
	@JsonIgnore
	private String Senha;
	
	

	
	@ManyToMany(mappedBy= "administrador")
	private List<Orientador> orientadores = new ArrayList<>();
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS_ADM")
	private Set<Integer> perfis = new HashSet<>();
	
	


public Administrador() {
	
	addPerfil(Perfil.ADMIN);
}

public Administrador(Integer id, String nomeCompleto, String email, String senha) {
	super();
	this.id = id;
	NomeCompleto = nomeCompleto;
	this.email = email;
	Senha = senha;
	addPerfil(Perfil.ADMIN);

	
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

//PERFIL CORRESPONDENTE A OS ADM
public Set<Perfil>getPerfis(){
	return perfis.stream().map( x -> Perfil.toEnum(x)).collect(Collectors.toSet());
}

//ADICIONA UM PERFIL AO ADM
public void  addPerfil(Perfil perfil) {
	perfis.add(perfil.getCod());
}

public List<Orientador> getOrientadores() {
	return orientadores;
}

public void setOrientadores(List<Orientador> orientadores) {
	this.orientadores = orientadores;
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
	Administrador other = (Administrador) obj;
	return Objects.equals(id, other.id);
}

}
