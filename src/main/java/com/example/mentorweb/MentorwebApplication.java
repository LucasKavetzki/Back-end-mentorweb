package com.example.mentorweb;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.mentorweb.domain.Administrador;
import com.example.mentorweb.domain.Aluno;
import com.example.mentorweb.domain.Curso;
import com.example.mentorweb.domain.Disciplina;
import com.example.mentorweb.domain.Monitor;
import com.example.mentorweb.domain.Monitoria;
import com.example.mentorweb.domain.Orientador;
import com.example.mentorweb.enums.Perfil;
import com.example.mentorweb.repositories.AdministradorRepository;
import com.example.mentorweb.repositories.AlunoRepository;
import com.example.mentorweb.repositories.CursosRepository;
import com.example.mentorweb.repositories.DisciplinaRepository;
import com.example.mentorweb.repositories.MonitorRepository;
import com.example.mentorweb.repositories.MonitoriaRepository;
import com.example.mentorweb.repositories.OrientadorRepository;

@SpringBootApplication
public class MentorwebApplication implements CommandLineRunner {

	

	@Autowired
	private BCryptPasswordEncoder pe;
	@Autowired
	private AdministradorRepository administradorRepository;
	@Autowired
	private OrientadorRepository orientadorRepository;
	@Autowired
	private DisciplinaRepository diciplinasRepository;
	@Autowired
	private CursosRepository cursosRepository;

	@Autowired
	private MonitorRepository monitorRepository;
	@Autowired
	private AlunoRepository alunoRepository; 
	@Autowired
	private MonitoriaRepository monitoriaRepository;


	
	
	


	public static void  main(String[] args) {
		SpringApplication.run(MentorwebApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		
		
		// estancia um objeto
																												//ENCODAR A SENHA
		Administrador adm1 = new Administrador(null, "Douglas Francisquini Toledo", "douglas.toledo@ifms.edu.br", pe.encode("123456") );
		adm1.addPerfil(Perfil.ADMIN);
		
		Administrador adm2 = new Administrador(null, "Walterisio Junior", "walterisio.junior@ifms.edu.br", pe.encode("805541") );		
		adm2.addPerfil(Perfil.ADMIN);

		
		Orientador ORIEN1 = new Orientador(null," Alan Antunes", "alan.antunes@ifms.edu.br",pe.encode("1234"), "701");
		ORIEN1.addPerfil(Perfil.ORIENTADORES);
		Orientador ORIEN2 = new Orientador(null," Angelo Perinotto ", "angelo.perinotto@ifms.edu.br",pe.encode ("8520"), pe.encode("702"));
		ORIEN2.addPerfil(Perfil.ORIENTADORES);

		Orientador ORIEN3 = new Orientador(null," Diogo Ramalho de Oliveira", "diogo.ramalho@ifms.edu.br",pe.encode ("7410"),pe.encode ("705"));
		ORIEN3.addPerfil(Perfil.ORIENTADORES);

		Orientador ORIEN4 = new Orientador(null," Eduardo Hiroshi Nakamura", "eduardo.nakamura@ifms.edu.br",pe.encode ("9523"), pe.encode("703"));
		ORIEN4.addPerfil(Perfil.ORIENTADORES);

		Orientador ORIEN5 = new Orientador(null," Estélio da Silva Amorim", "estelio.amorim@ifms.edu.br",pe.encode ("78356"),pe.encode ("704"));
		ORIEN5.addPerfil(Perfil.ORIENTADORES);

		Orientador ORIEN6 = new Orientador(null,"Hudson Martins ", "hudson.martins@ifms.edu.br",pe.encode ("585883"),pe.encode ("706"));
		ORIEN6.addPerfil(Perfil.ORIENTADORES);

		Orientador ORIEN7 = new Orientador(null," José Henrique Galeti", "jose.galeti@ifms.edu.br",pe.encode ("87583"),pe.encode ("707"));
		ORIEN7.addPerfil(Perfil.ORIENTADORES);

		Orientador ORIEN8 = new Orientador(null," Maraisa da Silva Guerra", "maraisa.guerra@ifms.edu.br",pe.encode ("68696"),pe.encode( "708"));
		ORIEN8.addPerfil(Perfil.ORIENTADORES);

		Orientador ORIEN9 = new Orientador(null," Nair Rodrigues", "nair.souza@ifms.edu.br",pe.encode("925352"),pe.encode ("709"));		
		ORIEN9.addPerfil(Perfil.ORIENTADORES); 

		
		adm1.getOrientadores().addAll(Arrays.asList(ORIEN1, ORIEN2, ORIEN3, ORIEN4, ORIEN5, ORIEN6, ORIEN7, ORIEN8, ORIEN9));
		
		ORIEN1.getAdministrador().addAll(Arrays.asList(adm1));
		ORIEN2.getAdministrador().addAll(Arrays.asList(adm1));
		ORIEN3.getAdministrador().addAll(Arrays.asList(adm1));
		ORIEN4.getAdministrador().addAll(Arrays.asList(adm1));
		ORIEN5.getAdministrador().addAll(Arrays.asList(adm1));
		ORIEN6.getAdministrador().addAll(Arrays.asList(adm1));
		ORIEN7.getAdministrador().addAll(Arrays.asList(adm1));
		ORIEN8.getAdministrador().addAll(Arrays.asList(adm1));
		ORIEN9.getAdministrador().addAll(Arrays.asList(adm1));
		

		
		
		
				
		Curso c1 = new Curso(null, "Técnico Integrado em Informática");
		Curso c2 = new Curso(null, "Técnico Integrado em Eletrotécnica"); 
		cursosRepository.saveAll(Arrays.asList(c1,c2));
	
		
		//associação da diciplina com o curso
		
		Disciplina d1 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 1", c1);
		Disciplina d2 = new Disciplina(null,  "Matemática 1", c1);
		Disciplina d3 = new Disciplina(null,  "Física 1" , c1);
		Disciplina d4 = new Disciplina(null,  "Educação Física 1", c1);	
	    Disciplina d5 = new Disciplina(null,  " Ling. Estrang.Moderna Inglês 1", c1);
		Disciplina d6 = new Disciplina(null,  "Geografia 1",c1);
		Disciplina d7 = new Disciplina(null,  "Filosofia 1" , c1);
		Disciplina d8 = new Disciplina(null,  "Sociologia 1", c1);
		Disciplina d9 = new Disciplina(null,  "Informática Aplicada",c1);
		Disciplina d10 = new Disciplina(null,  "Desenvolvimento web 1", c1);
		Disciplina d11 = new Disciplina(null,  "Algoritmos 1", c1);
		Disciplina d12 = new Disciplina(null,  "Instalação e Manutenção de Computadores 1", c1);
		Disciplina d13 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 2",c1);
		Disciplina d14 = new Disciplina(null,  "Matemática 2", c1);
		Disciplina d15 = new Disciplina(null,  "Física 2", c1);
		Disciplina d16 = new Disciplina(null,  "Educação Física 2", c1);
		Disciplina d17 = new Disciplina(null,  " Ling. Estrang.Moderna Inglês 2", c1);
		Disciplina d18 = new Disciplina(null,  "Geografia 2", c1);
		Disciplina d19 = new Disciplina(null,  "Filosofia 2", c1);
		Disciplina d20 = new Disciplina(null,  "Sociologia 2", c1);
		Disciplina d21 = new Disciplina(null,  "Biologia 1", c1);
		Disciplina d22 = new Disciplina(null,  "Quimica 1", c1);
		Disciplina d23 = new Disciplina(null,  "Desenvolvimento web 2", c1);
		Disciplina d24 = new Disciplina(null,  "Algoritmos 2", c1);
		Disciplina d25 = new Disciplina(null,  "Instalação e Manutenção de Computadores 2", c1);
		Disciplina d26 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 3", c1);
		Disciplina d27 = new Disciplina(null,  "Matemática 3", c1);
		Disciplina d28 = new Disciplina	(null,  "Física 3", c1);
		Disciplina d29 = new Disciplina(null,  "Educação Física 3",c1);
	    Disciplina d30 = new Disciplina(null,  " Ling. Estrang.Moderna Inglês 3", c1);
	    Disciplina d31 = new Disciplina(null,  "Geografia 3", c1);
		Disciplina d32 = new Disciplina(null,  "Filosofia 3", c1);
		Disciplina d33 = new Disciplina(null,  "Sociologia 3", c1);
		Disciplina d34 = new Disciplina(null,  "Biologia 2", c1);
		Disciplina d35 = new Disciplina(null,  "Quimica 2", c1);
	    Disciplina d36 = new Disciplina(null,  "Desenvolvimento web 3", c1);
	    Disciplina d37 = new Disciplina (null,  "Arte 1", c1);
		Disciplina d38 = new Disciplina(null,  "História 1", c1);
	    Disciplina d39 = new Disciplina(null,  "Banco de Dados 1", c1);
		Disciplina d40 = new Disciplina(null,  "Sistemas Operacionais 1", c1);
		Disciplina d41 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 4", c1);
		Disciplina d42 = new Disciplina(null,  "Matemática 4",c1);	
		Disciplina d43 = new Disciplina(null,  "Física 4",c1);
		Disciplina d44 = new Disciplina(null,  "Educação Física 4", c1);
		Disciplina d45 = new Disciplina(null,  " Ling. Estrang.Moderna Inglês 4", c1);
		Disciplina d46 = new Disciplina(null,  "Geografia 4", c1);
		Disciplina d47 = new Disciplina(null,  "Filosofia 4", c1);
		Disciplina d48 = new Disciplina(null,  "Sociologia 4", c1);
		Disciplina d49 = new Disciplina(null,  "Biologia 3", c1);
		Disciplina d50 = new Disciplina(null,  "Quimica 3", c1);
		Disciplina d51 = new Disciplina(null,  "Desenvolvimento web 4", c1);
		Disciplina d52 = new Disciplina(null,  "Arte 2", c1);
		Disciplina d53 = new Disciplina(null,  "História 2", c1);
		Disciplina d54 = new Disciplina(null,  "Banco de Dados 2", c1);
		Disciplina d55 = new Disciplina(null,  "Sistemas Operacionais 2", c1);
		Disciplina d56 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 5", c1);
		Disciplina d57 = new Disciplina(null,  "Matemática 5", c1);
		Disciplina d58 = new Disciplina(null,  "Física 5", c1);
		Disciplina d59 = new Disciplina(null,  "Educação Física 5", c1);
		Disciplina d60 = new Disciplina(null,  " Programação para Dispositivos Moveis 1", c1);
		Disciplina d61 = new Disciplina(null,  "Redes de Computadores 1",c1);
		Disciplina d62 = new Disciplina(null,  "Empreendedorismo e inovação 1",c1);
		Disciplina d63 = new Disciplina(null,  "Frameworks", c1);
		Disciplina d64 = new Disciplina(null,  "Biologia 4", c1);
		Disciplina d65 = new Disciplina(null,  "Quimica 4",c1);
		Disciplina d66 = new Disciplina(null,  "História 3",c1);
		Disciplina d67 = new Disciplina(null,  "Metodologia de Pesquisa", c1);
		Disciplina d68 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 6", c1);
		Disciplina d69 = new Disciplina(null,  "Matemática 6", c1);
		Disciplina d70 = new Disciplina(null,  "Física 6",c1);
		Disciplina d71 = new Disciplina(null,  "Tópicos Especiais em Tecnologia da Informação",c1);
		Disciplina d72 = new Disciplina(null,  " Programação para Dispositivos Moveis 2",c1);
		Disciplina d73 = new Disciplina(null,  "Redes de Computadores 2",c1);
		Disciplina d74 = new Disciplina(null,  "Empreendedorismo e inovação 2",c1);
	    Disciplina d75 = new Disciplina(null,  "Gerenciamento e configuração de Serviços de Internet",c1);
		Disciplina d76 = new Disciplina(null,  "Produção Técnica e Cientifica",c1);
		Disciplina d77 = new Disciplina(null,  "Comunicação Técnica",c1);
		Disciplina d78 = new Disciplina(null,  "História 4",c1);
		Disciplina d79 = new Disciplina(null,  "Computador, Ética e Sociedade",c1);
		Disciplina e1 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 1",c2);
		Disciplina e2 = new Disciplina(null,  "Matemática 1",c2);
		Disciplina e3 = new Disciplina(null,  "Física 1",c2);
		Disciplina e4 = new Disciplina(null,  "Educação Física 1",c2);
		Disciplina e5 = new Disciplina(null,  " Ling. Estrang.Moderna Inglês 1",c2);
		Disciplina e6 = new Disciplina(null,  "Geografia 1",c2);
		Disciplina e7 = new Disciplina(null,  "Filosofia 1",c2);
		Disciplina e8 = new Disciplina(null,  "Sociologia 1",c2);
		Disciplina e9 = new Disciplina(null,  "Eletricidade CC",c2);
		Disciplina e10 = new Disciplina(null,  "Desenho Técnico e CAD",c2);
		Disciplina e11 = new Disciplina(null,  "Informática Aplicada",c2);
		Disciplina e12 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 2",c2);
		Disciplina e13 = new Disciplina(null,  "Matemática 2",c2);
		Disciplina e14 = new Disciplina(null,  "Física 2",c2);
		Disciplina e15 = new Disciplina(null,  "Educação Física 2",c2);
		Disciplina e16 = new Disciplina(null,  " Ling. Estrang.Moderna Inglês 2",c2);
		Disciplina e17 = new Disciplina(null,  "Geografia 2",c2);
		Disciplina e18 = new Disciplina(null,  "Filosofia 2",c2);
		Disciplina e19 = new Disciplina(null,  "Sociologia 2",c2);
		Disciplina e20 = new Disciplina(null,  "Biologia 1",c2);
		Disciplina e21 = new Disciplina(null,  "Quimica 1",c2);
		Disciplina e22 = new Disciplina(null,  "Eletricidade CA",c2);
		Disciplina e23 = new Disciplina(null,  "Instalações Elétricas Prediais",c2);
		Disciplina e24 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 3",c2);
		Disciplina e25 = new Disciplina(null,  "Matemática 3",c2);
		Disciplina e26 = new Disciplina(null,  "Física 3",c2);
		Disciplina e27 = new Disciplina(null,  "Educação Física 3",c2);
		Disciplina e28 = new Disciplina(null,  " Ling. Estrang.Moderna Inglês 3",c2);
		Disciplina e29 = new Disciplina(null,  "Geografia 3",c2);
		Disciplina e30 = new Disciplina(null,  "Filosofia 3",c2);
		Disciplina e31 = new Disciplina(null,  "Sociologia 3",c2);
		Disciplina e32 = new Disciplina(null,  "Biologia 2",c2);
		Disciplina e33 = new Disciplina(null,  "Quimica 2",c2);
		Disciplina e34 = new Disciplina(null,  "História 1",c2);
		Disciplina e35 = new Disciplina(null,  "Arte 1",c2);
		Disciplina e36 = new Disciplina(null,  "Eletrônica Geral 1",c2);
		Disciplina e37 = new Disciplina(null,  "Conversão de Energia",c2);
		Disciplina e38 = new Disciplina(null,  "Eletrônica Digital",c2);
		Disciplina e39 = new Disciplina(null,  "Redação e Metodologias Científicas",c2);
		Disciplina e40 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 4",c2);
		Disciplina e41 = new Disciplina(null,  "Matemática 4",c2);
		Disciplina e42 = new Disciplina(null,  "Física 4",c2);
		Disciplina e43 = new Disciplina(null,  "Educação Física 4",c2);
		Disciplina e44 = new Disciplina(null,  " Ling. Estrang.Moderna Inglês 4",c2);
		Disciplina e45 = new Disciplina(null,  "Geografia 4",c2);
		Disciplina e46 = new Disciplina(null,  "Filosofia 4",c2);
		Disciplina e47 = new Disciplina(null,  "Sociologia 4",c2);
		Disciplina e48 = new Disciplina(null,  "Biologia 3",c2);
		Disciplina e49 = new Disciplina(null,  "Quimica 3",c2);
		Disciplina e50 = new Disciplina(null,  "História 2",c2);
		Disciplina e51 = new Disciplina(null,  "Arte 2",c2);
		Disciplina e52 = new Disciplina(null,  "Eletrônica Geral 2",c2);
		Disciplina e53 = new Disciplina(null, "Máquinas Elétricas e Acionamentos 1",c2);
		Disciplina e54 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 5",c2);
		Disciplina e55 = new Disciplina(null,  "Matemática 5",c2);
		Disciplina e56 = new Disciplina(null,  "Física 5",c2);
		Disciplina e57 = new Disciplina(null,  "Educação Física 5",c2);
		Disciplina e58 = new Disciplina(null,  "Biologia 4",c2);
		Disciplina e59 = new Disciplina(null,  "Quimica 4",c2);
		Disciplina e60 = new Disciplina(null,  "História 3",c2);
		Disciplina e61 = new Disciplina(null,  "Comandos Elétricos",c2);
		Disciplina e62 = new Disciplina(null,  "Máquinas Elétricas e Acionamentos 2",c2);
		Disciplina e63 = new Disciplina(null,  "Elétronica de Potência ",c2);
		Disciplina e64 = new Disciplina(null,  "Sistemas Microcontrolados",c2);
		Disciplina e65 = new Disciplina(null,  "Pneumática e Hidráulica",c2);
		Disciplina e66 = new Disciplina(null,  "Empreendedorismo e inovação ",c2);
		Disciplina e67 = new Disciplina(null,  "Lingua Portuguesa e literatura Brasileira 6",c2);
		Disciplina e68 = new Disciplina(null,  "Matemática 6",c2);
		Disciplina e69 = new Disciplina(null,  "Física 6",c2);
		Disciplina e70 = new Disciplina(null,  "História 4",c2);
		Disciplina e71 = new Disciplina(null,  "Instalações Elétricas Industriais",c2);
		Disciplina e72 = new Disciplina(null,  "Geração, Transmissão e Distribuição Elétrica",c2);
		Disciplina e73 = new Disciplina(null,  "Instrumentação e Controle",c2);
		Disciplina e74 = new Disciplina(null,  "Acionamentos Especiais",c2);
		Disciplina e75 = new Disciplina(null,  "Acionamento  Eletropneumático e Eletrohidráulico",c2);
		Disciplina e76 = new Disciplina(null,  "Automação Industrial ",c2);
		Disciplina e77 = new Disciplina(null,  "Estátistica",c2);
		Disciplina e78 = new Disciplina(null,  "Segurança do Trabalho",c2);
		Disciplina e79 = new Disciplina(null,  "Meio Ambiente e Energias Renováveis",c2);

		
		// salva os objetos estanciados
		diciplinasRepository.saveAll(Arrays.asList(d1,d2,d3,d4,d5,d6,d7,d8,d9,d10,d11,d12,d13,d14,d15,d16,d17,d18,d19,d20,d21,d22,d23,d24,d25,d26,
				d27,d28,d29,d30,d31,d32,d33,d34,d35,d36,d37,d38,d39,d40,d41,d42,d43,d44,d45,d46,d47,d48,d49,d50,d51,d52,d53,d54,d55,d56,d57,d58,d59,
				d60,d61,d62,d63,d64,d65,d66,d67,d68,d69,d70,d71,d72,d73,d74,d75,d76,d77,d78,d79,e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12,e13,e14,e15,e16,
				e17,e18,e19,e20,e21,e22,e23,e24,e25,e26,e27,e28,e29,e30,e31,e32,e33,e34,e35,e36,e37,e38,e39,e40,e41,e42,e43,e44,e45,e46,e47,e48,e49,e50,e51,e52,e53,
				e54,e55,e56,e57,e58,e59,e60,e61,e62,e63,e64,e65,e66,e67,e68,e69,e70,e71,e72,e73,e74,e75,e76,e77,e78,e79));
		
		
		
		//associação do curso com a diciplina
		
		c1.getDiciplinas().addAll(Arrays.asList(d1));
		c1.getDiciplinas().addAll(Arrays.asList(d2));
		c1.getDiciplinas().addAll(Arrays.asList(d3));
		c1.getDiciplinas().addAll(Arrays.asList(d4));
		c1.getDiciplinas().addAll(Arrays.asList(d5));
		c1.getDiciplinas().addAll(Arrays.asList(d6));
		c1.getDiciplinas().addAll(Arrays.asList(d7));
		c1.getDiciplinas().addAll(Arrays.asList(d8));
		c1.getDiciplinas().addAll(Arrays.asList(d9));
		c1.getDiciplinas().addAll(Arrays.asList(d10));
		c1.getDiciplinas().addAll(Arrays.asList(d11));
		c1.getDiciplinas().addAll(Arrays.asList(d12));
		c1.getDiciplinas().addAll(Arrays.asList(d13));
		c1.getDiciplinas().addAll(Arrays.asList(d14));
		c1.getDiciplinas().addAll(Arrays.asList(d15));
		c1.getDiciplinas().addAll(Arrays.asList(d16));
		c1.getDiciplinas().addAll(Arrays.asList(d17));
		c1.getDiciplinas().addAll(Arrays.asList(d18));
		c1.getDiciplinas().addAll(Arrays.asList(d19));
		c1.getDiciplinas().addAll(Arrays.asList(d20));
		c1.getDiciplinas().addAll(Arrays.asList(d21));
		c1.getDiciplinas().addAll(Arrays.asList(d22));
		c1.getDiciplinas().addAll(Arrays.asList(d23));
		c1.getDiciplinas().addAll(Arrays.asList(d24));
		c1.getDiciplinas().addAll(Arrays.asList(d25));
		c1.getDiciplinas().addAll(Arrays.asList(d26));
		c1.getDiciplinas().addAll(Arrays.asList(d27));
		c1.getDiciplinas().addAll(Arrays.asList(d28));
		c1.getDiciplinas().addAll(Arrays.asList(d29));
		c1.getDiciplinas().addAll(Arrays.asList(d30));
		c1.getDiciplinas().addAll(Arrays.asList(d31));
		c1.getDiciplinas().addAll(Arrays.asList(d32));
		c1.getDiciplinas().addAll(Arrays.asList(d33));
		c1.getDiciplinas().addAll(Arrays.asList(d34));
		c1.getDiciplinas().addAll(Arrays.asList(d35));
		c1.getDiciplinas().addAll(Arrays.asList(d36));
		c1.getDiciplinas().addAll(Arrays.asList(d37));
		c1.getDiciplinas().addAll(Arrays.asList(d38));
		c1.getDiciplinas().addAll(Arrays.asList(d39));
		c1.getDiciplinas().addAll(Arrays.asList(d40));
		c1.getDiciplinas().addAll(Arrays.asList(d41));
		c1.getDiciplinas().addAll(Arrays.asList(d42));
		c1.getDiciplinas().addAll(Arrays.asList(d43));
		c1.getDiciplinas().addAll(Arrays.asList(d44));
		c1.getDiciplinas().addAll(Arrays.asList(d45));
		c1.getDiciplinas().addAll(Arrays.asList(d46));
		c1.getDiciplinas().addAll(Arrays.asList(d47));
		c1.getDiciplinas().addAll(Arrays.asList(d48));
		c1.getDiciplinas().addAll(Arrays.asList(d49));
		c1.getDiciplinas().addAll(Arrays.asList(d50));
		c1.getDiciplinas().addAll(Arrays.asList(d51));
		c1.getDiciplinas().addAll(Arrays.asList(d52));
		c1.getDiciplinas().addAll(Arrays.asList(d53));
		c1.getDiciplinas().addAll(Arrays.asList(d54));
		c1.getDiciplinas().addAll(Arrays.asList(d55));
		c1.getDiciplinas().addAll(Arrays.asList(d56));
		c1.getDiciplinas().addAll(Arrays.asList(d57));
		c1.getDiciplinas().addAll(Arrays.asList(d58));
		c1.getDiciplinas().addAll(Arrays.asList(d59));
		c1.getDiciplinas().addAll(Arrays.asList(d60));
		c1.getDiciplinas().addAll(Arrays.asList(d61));
		c1.getDiciplinas().addAll(Arrays.asList(d62));
		c1.getDiciplinas().addAll(Arrays.asList(d63));
		c1.getDiciplinas().addAll(Arrays.asList(d64));
		c1.getDiciplinas().addAll(Arrays.asList(d65));
		c1.getDiciplinas().addAll(Arrays.asList(d66));
		c1.getDiciplinas().addAll(Arrays.asList(d67));
		c1.getDiciplinas().addAll(Arrays.asList(d67));
		c1.getDiciplinas().addAll(Arrays.asList(d68));
		c1.getDiciplinas().addAll(Arrays.asList(d69));
		c1.getDiciplinas().addAll(Arrays.asList(d70));
		c1.getDiciplinas().addAll(Arrays.asList(d71));
		c1.getDiciplinas().addAll(Arrays.asList(d72));
		c1.getDiciplinas().addAll(Arrays.asList(d73));
		c1.getDiciplinas().addAll(Arrays.asList(d74));
		c1.getDiciplinas().addAll(Arrays.asList(d75));
		c1.getDiciplinas().addAll(Arrays.asList(d76));
		c1.getDiciplinas().addAll(Arrays.asList(d77));
		c1.getDiciplinas().addAll(Arrays.asList(d78));
		c1.getDiciplinas().addAll(Arrays.asList(d79));
		
		c2.getDiciplinas().addAll(Arrays.asList(e1));
		c2.getDiciplinas().addAll(Arrays.asList(e2));
		c2.getDiciplinas().addAll(Arrays.asList(e3));
		c2.getDiciplinas().addAll(Arrays.asList(e4));
		c2.getDiciplinas().addAll(Arrays.asList(e5));
		c2.getDiciplinas().addAll(Arrays.asList(e6));
		c2.getDiciplinas().addAll(Arrays.asList(e7));
		c2.getDiciplinas().addAll(Arrays.asList(e8));
		c2.getDiciplinas().addAll(Arrays.asList(e9));
		c2.getDiciplinas().addAll(Arrays.asList(e10));
		c2.getDiciplinas().addAll(Arrays.asList(e11));
		c2.getDiciplinas().addAll(Arrays.asList(e12));
		c2.getDiciplinas().addAll(Arrays.asList(e13));
		c2.getDiciplinas().addAll(Arrays.asList(e14));
		c2.getDiciplinas().addAll(Arrays.asList(e15));
		c2.getDiciplinas().addAll(Arrays.asList(e16));
		c2.getDiciplinas().addAll(Arrays.asList(e17));
		c2.getDiciplinas().addAll(Arrays.asList(e18));
		c2.getDiciplinas().addAll(Arrays.asList(e19));
		c2.getDiciplinas().addAll(Arrays.asList(e20));
		c2.getDiciplinas().addAll(Arrays.asList(e22));
		c2.getDiciplinas().addAll(Arrays.asList(e23));
		c2.getDiciplinas().addAll(Arrays.asList(e24));
		c2.getDiciplinas().addAll(Arrays.asList(e25));
		c2.getDiciplinas().addAll(Arrays.asList(e26));
		c2.getDiciplinas().addAll(Arrays.asList(e27));
		c2.getDiciplinas().addAll(Arrays.asList(e28));
		c2.getDiciplinas().addAll(Arrays.asList(e29));
		c2.getDiciplinas().addAll(Arrays.asList(e30));
		c2.getDiciplinas().addAll(Arrays.asList(e31));
		c2.getDiciplinas().addAll(Arrays.asList(e32));
		c2.getDiciplinas().addAll(Arrays.asList(e33));
		c2.getDiciplinas().addAll(Arrays.asList(e34));
		c2.getDiciplinas().addAll(Arrays.asList(e35));
		c2.getDiciplinas().addAll(Arrays.asList(e36));
		c2.getDiciplinas().addAll(Arrays.asList(e37));
		c2.getDiciplinas().addAll(Arrays.asList(e38));
		c2.getDiciplinas().addAll(Arrays.asList(e39));
		c2.getDiciplinas().addAll(Arrays.asList(e40));
		c2.getDiciplinas().addAll(Arrays.asList(e41));
		c2.getDiciplinas().addAll(Arrays.asList(e42));
		c2.getDiciplinas().addAll(Arrays.asList(e43));
		c2.getDiciplinas().addAll(Arrays.asList(e44));
		c2.getDiciplinas().addAll(Arrays.asList(e45));
		c2.getDiciplinas().addAll(Arrays.asList(e46));
		c2.getDiciplinas().addAll(Arrays.asList(e47));
		c2.getDiciplinas().addAll(Arrays.asList(e48));
		c2.getDiciplinas().addAll(Arrays.asList(e49));
		c2.getDiciplinas().addAll(Arrays.asList(e50));
		c2.getDiciplinas().addAll(Arrays.asList(e51));
		c2.getDiciplinas().addAll(Arrays.asList(e52));
		c2.getDiciplinas().addAll(Arrays.asList(e53));
		c2.getDiciplinas().addAll(Arrays.asList(e54));
		c2.getDiciplinas().addAll(Arrays.asList(e55));
		c2.getDiciplinas().addAll(Arrays.asList(e56));
		c2.getDiciplinas().addAll(Arrays.asList(e57));
		c2.getDiciplinas().addAll(Arrays.asList(e58));
		c2.getDiciplinas().addAll(Arrays.asList(e59));
		c2.getDiciplinas().addAll(Arrays.asList(e60));
		c2.getDiciplinas().addAll(Arrays.asList(e61));
		c2.getDiciplinas().addAll(Arrays.asList(e62));
		c2.getDiciplinas().addAll(Arrays.asList(e63));
		c2.getDiciplinas().addAll(Arrays.asList(e64));
		c2.getDiciplinas().addAll(Arrays.asList(e65));
		c2.getDiciplinas().addAll(Arrays.asList(e66));
		c2.getDiciplinas().addAll(Arrays.asList(e67));
		c2.getDiciplinas().addAll(Arrays.asList(e68));
		c2.getDiciplinas().addAll(Arrays.asList(e69));
		c2.getDiciplinas().addAll(Arrays.asList(e70));
		c2.getDiciplinas().addAll(Arrays.asList(e71));
		c2.getDiciplinas().addAll(Arrays.asList(e72));
		c2.getDiciplinas().addAll(Arrays.asList(e73));
		c2.getDiciplinas().addAll(Arrays.asList(e74));
		c2.getDiciplinas().addAll(Arrays.asList(e75));
		c2.getDiciplinas().addAll(Arrays.asList(e76));
		c2.getDiciplinas().addAll(Arrays.asList(e77));
		c2.getDiciplinas().addAll(Arrays.asList(e78));
		c2.getDiciplinas().addAll(Arrays.asList(e79)); 
		
		
	
		Monitor b1 = new Monitor(null, "Cristian Nantes", "Matemática1","nantes@me.com",pe.encode("77888"), pe.encode("896245") );
		Monitor b2 = new Monitor(null, "Raquel Silveira", "Comandos Eletricos","raquel@outlook.com",pe.encode("2569"),pe.encode("896245") );
		Monitor b3 = new Monitor(null, "Silvio Costa Souza", "Desenvolvimento Web 4","costa@gmail.com",pe.encode("624531"),pe.encode("896245") ); 


		b1.addPerfil(Perfil.MONITORES);
		b2.addPerfil(Perfil.MONITORES);
		b3.addPerfil(Perfil.MONITORES);
		monitorRepository.saveAll(Arrays.asList(b1,b2,b3));

		
		Monitoria m1 = new Monitoria(null, "Biblioteca Sala7", "17/05/2022" , "16:45:00", d2, b1);
		Monitoria m2 = new Monitoria(null, "Biblioteca Sala 4", "11/05/2022" , "13:45:00", d51, b2);
		Monitoria m3 = new Monitoria(null, "Sala 1", "14/06/2022" , "07:45:00", e61, b3); 

		
		monitoriaRepository.saveAll(Arrays.asList(m1,m2,m3));
		
		
		Aluno a1 = new Aluno(null,"Sebatião Silveira","silveira@outlook.com",pe.encode("42688"));
		Aluno a2 = new Aluno(null," Ana Nery","nery@outlook.com",pe.encode("58630"));
		Aluno a3 = new Aluno(null,"Sheila Carvalho","carvalho@gmail.com",pe.encode("5396"));
		Aluno a4 = new Aluno(null,"Maria Catarina Oliveira","maria@me.com",pe.encode("5282"));
		Aluno a5 = new Aluno(null,"Henrique Junior Lopes","junior@gmail.com",pe.encode("5290"));
		
		a1.addPerfil(Perfil.ALUNOS);
		a2.addPerfil(Perfil.ALUNOS);
		a3.addPerfil(Perfil.ALUNOS);
		a4.addPerfil(Perfil.ALUNOS);
		a5.addPerfil(Perfil.ALUNOS);

		alunoRepository.saveAll(Arrays.asList(a1,a2,a3,a4,a5));  

		
		
		
		orientadorRepository.saveAll(Arrays.asList(ORIEN1, ORIEN2, ORIEN3, ORIEN4, ORIEN5, ORIEN6, ORIEN7, ORIEN8, ORIEN9));

		administradorRepository.saveAll(Arrays.asList(adm1,adm2));


	
	
	}
}


