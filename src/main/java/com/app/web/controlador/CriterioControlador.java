package com.app.web.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.web.entidad.Criterio;
import com.app.web.servicio.EstudianteServicio;

@Controller
public class CriterioControlador {

	@Autowired
	private EstudianteServicio servicio;
	
	@GetMapping("/estudiantes/criterios")
	public String listarCriterios(Model modelo) {
		modelo.addAttribute("criterios", servicio.listarTodosLosCriterios());
		return "vistaCriterios";
	}
	
	@GetMapping("/estudiantes/criterios/editar/{id}")
	public String mostrarFormularioDeEditarCrit(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("criterio", servicio.obtenerCriterioPorId(id));
		return "criterios";
	}
	
	@PostMapping("/estudiantes/criterios/{id}")
	public String actualizarCriterios(@PathVariable Long id, @ModelAttribute("criterio") Criterio criterio, Model modelo) {
		Criterio criterioExistente = servicio.obtenerCriterioPorId(id);
		criterioExistente.setId(id);
		criterioExistente.setAsistencia(criterio.getAsistencia());
		criterioExistente.setEvento(criterio.getEvento());
		criterioExistente.setPractica(criterio.getPractica());
		criterioExistente.setTrabajo(criterio.getTrabajo());
		servicio.actualizarCriterio(criterioExistente);
		return "redirect:/estudiantes/criterios";
	}
	
}