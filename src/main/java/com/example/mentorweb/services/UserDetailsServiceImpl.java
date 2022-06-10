package com.example.mentorweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mentorweb.Security.UserSS;
import com.example.mentorweb.domain.Administrador;
import com.example.mentorweb.domain.Aluno;
import com.example.mentorweb.domain.Monitor;
import com.example.mentorweb.domain.Orientador;
import com.example.mentorweb.repositories.AdministradorRepository;
import com.example.mentorweb.repositories.AlunoRepository;
import com.example.mentorweb.repositories.MonitorRepository;
import com.example.mentorweb.repositories.OrientadorRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private AdministradorRepository admrepo;
	
	@Autowired
	private OrientadorRepository repo;
	@Autowired
	private MonitorRepository mtrrepo;
	@Autowired
	private  AlunoRepository alurepo;
	
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	Orientador orien  = repo.findByEmail(email);
    	Administrador adm1 = admrepo.findByEmail(email);
    	Monitor mtr = mtrrepo.findByEmail(email); 
    	Aluno alu = alurepo.findByEmail(email);
    	
    	
    				if (adm1 == null) {
    					if (orien == null) {
    					 if(mtr == null) {
    						 if(alu == null) {
    							 
     				    		throw new UsernameNotFoundException(email);
 
    							 
    							 
    						 }
    						 
     			    		return new UserSS(alu.getId(),alu.getEmail(),alu.getSenha(),alu.getPerfis());
 
 
    						 
    					 }	
        	
    			    		return new UserSS(mtr.getId(),mtr.getEmail(),mtr.getSenha(),mtr.getPerfis());


    		//throw new UsernameNotFoundException(email);
    	}
    		return new UserSS(orien.getId(),orien.getEmail(),orien.getSenha(),orien.getPerfis());
    				}       
    	        

    	
        
        return new UserSS(adm1.getId(), adm1.getEmail(), adm1.getSenha(), adm1.getPerfis());
        	
        
    }


	
}

