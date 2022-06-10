package com.example.mentorweb.enums;

public enum Perfil {
	
	ADMIN(1,"ROLE_ADMIN"),
	ORIENTADORES(2,"ROLE_ORIENTADORES"),
	MONITORES(3,"ROLE_MONITORES"),
	ALUNOS(4,"ROLE_ALUNOS");

	//MONITORIA(5,"ROLE_MONITORIA");
	
	
	private int cod;
	private String descricao;
	
	
	
	
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}



	public int getCod() {
		return cod;
	}


	public String getDescricao() {
		return descricao;
	}

	
	public static Perfil toEnum(Integer cod) {
		
		
		if(cod == null) {
			return null;
		}
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
			
		}
		throw new IllegalArgumentException("Id inválido:  "  +cod);
			
	}
}
