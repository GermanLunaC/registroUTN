package com.app.web.servicio;

import java.util.List;
import com.app.web.entidad.Estudiante;
import com.app.web.entidad.Criterio;


public interface EstudianteServicio {
	
	public List<Estudiante> listarTodosLosEstudiantes();
	public Estudiante guardarEstudiante(Estudiante estudiante);
	public Estudiante actualizarEstudiante(Estudiante estudiante);
	public Estudiante obtenerEstudiantePorId(Long i);
	public void eliminarEstudiante(Long id);
	public Estudiante evaluarEstudiante(Estudiante estudiante);
	public List<Estudiante> mostrarTodosLosEstudiantes(String palabraClave);
	public List<Estudiante> mostrarTodosLosEstud(String palabraA);
	
	public List<Criterio> listarTodosLosCriterios();
	public Criterio guardarCriterio(Criterio criterio);
	public Criterio obtenerCriterioPorId(Long id);
	public Criterio actualizarCriterio(Criterio criterio);
}
