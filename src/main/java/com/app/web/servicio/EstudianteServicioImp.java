package com.app.web.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entidad.Estudiante;
import com.app.web.entidad.Criterio;
import com.app.web.repositorio.CriterioRepositorio;
import com.app.web.repositorio.EstudianteRepositorio;

@Service
public class EstudianteServicioImp implements EstudianteServicio{

	@Autowired
	private EstudianteRepositorio repositorio;
	
	@Autowired
	private CriterioRepositorio repositorio1;
	
	@Override
	public List<Estudiante> listarTodosLosEstudiantes() {
		return repositorio.findAll();
	}

	@Override
	public Estudiante guardarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}
	
	@Override
	public Estudiante actualizarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}

	@Override
	public Estudiante obtenerEstudiantePorId(Long id) {
		return repositorio.findById(id).get();
	}

	@Override
	public void eliminarEstudiante(Long id) {
		repositorio.deleteById(id);
	}

	@Override
	public Estudiante evaluarEstudiante(Estudiante estudiante) {
		return repositorio.save(estudiante);
	}
	
	@Override
	public List<Estudiante> mostrarTodosLosEstudiantes(String palabraClave) {
		if(palabraClave != null) {
			return repositorio.findAll(palabraClave);
		}
		return repositorio.findAll();
	}
	
	@Override
	public List<Estudiante> mostrarTodosLosEstud(String palabraA) {
		if(palabraA != null) {
			return repositorio.mostrarA(palabraA);
		}
		return repositorio.findAll();
	}

	@Override
	public Criterio guardarCriterio(Criterio criterio) {
		return repositorio1.save(criterio);
	}
	
	@Override
	public Criterio actualizarCriterio(Criterio criterio) {
		return repositorio1.save(criterio);
	}

	@Override
	public List<Criterio> listarTodosLosCriterios() {
		return repositorio1.findAll();
	}

	@Override
	public Criterio obtenerCriterioPorId(Long id) {
		return repositorio1.findById(id).get();
	}
}
	