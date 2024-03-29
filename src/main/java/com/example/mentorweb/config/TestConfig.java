package com.example.mentorweb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.mentorweb.services.DBService;


@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;
	
	
	
	@Bean
	public void instanciaDB() {
		this.dbService.instanciaDB();
	}

}


//FAZ O TEST SUBIR O TESTE DE FORMA AUTOMATICA 