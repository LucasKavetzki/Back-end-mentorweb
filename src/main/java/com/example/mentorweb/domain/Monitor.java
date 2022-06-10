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
import javax.persistence.OneToMany;

import com.example.mentorweb.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Monitor implements Serializable {
	private static final long serialVersionUID = 1L;
	

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String NomeCompleto;
	private String Disciplina;
	
	@Column(unique=true)
	private String email;
	
	@JsonIgnore
	private String RA;
	
	private String senha;
	
	
	@JsonBackReference
	@OneToMany(mappedBy="monitor")
	private List<Monitoria> monitorias = new ArrayList<>();
	
	

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS_MTR")
	private Set<Integer> perfis = new HashSet<>();
	

	
	

	public Monitor() {

		
		 addPerfil(Perfil.MONITORES);
	}


	 public Monitor(Integer id, String nomeCompleto, String disciplina, String email, String rA, String senha) {
		super();
		this.id = id;
		NomeCompleto = nomeCompleto;
		Disciplina = disciplina;
		this.email = email;
		RA = rA;
		this.senha =senha;
		addPerfil(Perfil.MONITORES);

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
		return RA;
	}


	public void setRA(String rA) {
		RA = rA;
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
		Monitor other = (Monitor) obj;
		return Objects.equals(id, other.id);
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}



}
