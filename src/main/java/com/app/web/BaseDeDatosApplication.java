package com.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.app.web.entidad.Estudiante;
import com.app.web.repositorio.CriterioRepositorio;
import com.app.web.repositorio.EstudianteRepositorio;

@SpringBootApplication
public class BaseDeDatosApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BaseDeDatosApplication.class, args);
	}

	@Autowired
	private EstudianteRepositorio repositorio;
	
	@Autowired
	private CriterioRepositorio repositorio1;
	
	
	@Override
	public void run(String... args) throws Exception {
		/*Estudiante estudiante1=new Estudiante("German Luna Calvillo",203241039,"Ing. Sistemas Computacionales","Natacion","09/11/2022","Masculino","Hobby","Principiante","IC51M",0,0,0,0,0,0,0,0,0,0,0,0,0,"No");	
		repositorio.save(estudiante1);
		Estudiante estudiante2=new Estudiante("Felipe Torres Miranda",203241045,"Ing. Sistemas Computacionales","Danza","09/11/2022","Masculino","Credito","Principiante","IC51M",0,0,0,0,0,0,0,0,0,0,0,0,0,"No");	
		repositorio.save(estudiante2);*/
	}

}
