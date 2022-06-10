package com.example.mentorweb.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.example.mentorweb.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Orientador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String NomeCompleto;
	
	@Column(unique=true)
	private String email;
	
	@JsonIgnore
	private String Senha;
	
	@JsonIgnore
	private String Siape;
	
	
	@JsonBackReference
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable (name="ADMINISTRADOR_ORIENTADOR",
	joinColumns = @JoinColumn(name= "orientador_id"),
	inverseJoinColumns = @JoinColumn(name= "administrador_id"))
	private List<Administrador> administrador = new ArrayList <>();
	/* Criando tabelas para fazer associações de muitos para muitos
	 * Mapeamento da lista adm, informando quem vai ser a tabela do banco de dados
	 * que vai intermediar as outras 2 tabelas
	*/
	
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS_ORIEN")
	private Set<Integer> perfis = new HashSet<>(); 
	
	
	
	
 public Orientador (){
	 
	addPerfil(Perfil.ORIENTADORES);
	 
 }


public Orientador( Integer id, String nomeCompleto, String email, String senha, String siape) {
	super();
	this.id = id;
	NomeCompleto = nomeCompleto;
	this.email = email;
	Senha = senha;
	Siape = siape;
	addPerfil(Perfil.ORIENTADORES);
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


public String getSiape() {
	return Siape;
}


public void setSiape(String siape) {
	Siape = siape;
}

public Set<Perfil>getPerfis(){
	return perfis.stream().map( x -> Perfil.toEnum(x)).collect(Collectors.toSet());
}

public void  addPerfil(Perfil perfil) {
	perfis.add(perfil.getCod());
}
public List<Administrador> getAdministrador() {
	return administrador;
}


public void setAdministrador(List<Administrador> administrador) {
	this.administrador = administrador;
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
	Orientador other = (Orientador) obj;
	return Objects.equals(id, other.id);
}
}