package com.app.web.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.web.entidad.Criterio;
import com.app.web.entidad.Estudiante;
import com.app.web.reporte.EstudianteExporter;
import com.app.web.servicio.EstudianteServicio;

@Controller
public class EstudianteControlador {

	@Autowired
	private EstudianteServicio servicio;
	
	@GetMapping("/")
	public String mostrar(Model modelo) {
		return "index";
	}
	
	@GetMapping("/estudiantes")
	public String listarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());
		return "estudiantes";
	}
	
	@GetMapping("/estudiantes/nuevo")
	public String crearEstudianteFormulario(Model modelo) { 
		Estudiante estudiante=new Estudiante();
		modelo.addAttribute("estudiante", estudiante);
		return "crear_estudiante";
	}
	
	@PostMapping("/estudiantes")
	public String guardarEstudiantes(@ModelAttribute("estudiante") Estudiante estudiante) {
		servicio.guardarEstudiante(estudiante);
		return "redirect:estudiantes";
	}
	
	
	@GetMapping("/estudiantes/editar/{id}")
	public String mostrarFormularioDeEditar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
		return "editar_estudiante";
	}
	
	@PostMapping("/estudiantes/{id}")
	public String actualizarEstudiantes(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo) {
		Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
		estudianteExistente.setId(id);
		estudianteExistente.setNombre(estudiante.getNombre());
		estudianteExistente.setActividad(estudiante.getActividad());
		estudianteExistente.setCarrera(estudiante.getCarrera());
		estudianteExistente.setCategoria(estudiante.getCategoria());
		estudianteExistente.setCre_hobb(estudiante.getCre_hobb());
		estudianteExistente.setFechaI(estudiante.getFechaI());
		estudianteExistente.setMatricula(estudiante.getMatricula());
		estudianteExistente.setSexo(estudiante.getSexo());
		estudianteExistente.setGrupo(estudiante.getGrupo());
		servicio.actualizarEstudiante(estudianteExistente);
		return "redirect:/estudiantes";
	}
	
	@GetMapping("/estudiantes/{id}")
	public String eliminarEstudiante(@PathVariable Long id, RedirectAttributes atributo) {
		atributo.addFlashAttribute("msg","¡La categoria se elimino con exito!");
		servicio.eliminarEstudiante(id);
		return "redirect:/estudiantes";
	}
	
	@GetMapping("/estudiantes/evaluar")
	public String mostrarEstudiantes(Model modelo) {
		modelo.addAttribute("estudiantes", servicio.listarTodosLosEstudiantes());
		return "evaluar";
	}
	
	@GetMapping("/estudiantes/evaluar/{id}")
	public String mostrarFormularioDeEvaluar(@PathVariable Long id, Model modelo) {
		modelo.addAttribute("estudiante", servicio.obtenerEstudiantePorId(id));
		return "evaluar_Estudiantes";
	}
	
	@PostMapping("/estudiantes/evaluar/{id}")
	public String evaluarEstudiantes(@PathVariable Long id, @ModelAttribute("estudiante") Estudiante estudiante, Model modelo) {
		Estudiante estudianteExistente = servicio.obtenerEstudiantePorId(id);
		for(Long i=(long) 1;i<2;i++) {
			Criterio criterioExistente = servicio.obtenerCriterioPorId(i);
			do {
				int asistencia=criterioExistente.getAsistencia();
				int practica=criterioExistente.getPractica();
				int trabajo=criterioExistente.getTrabajo();
				int evento=criterioExistente.getEvento();
				estudianteExistente.setId(id);
				estudianteExistente.setNombre(estudiante.getNombre());
				estudianteExistente.setActividad(estudiante.getActividad());
				estudianteExistente.setCarrera(estudiante.getCarrera());
				estudianteExistente.setCre_hobb(estudiante.getCre_hobb());
				estudianteExistente.setMatricula(estudiante.getMatricula());
				estudianteExistente.setA1(estudiante.getA1());
				estudianteExistente.setA2(estudiante.getA2());
				estudianteExistente.setA3(estudiante.getA3());
				estudianteExistente.setA4(estudiante.getA4());
				estudianteExistente.setE1(estudiante.getE1());
				estudianteExistente.setP1(estudiante.getP1());
				estudianteExistente.setT1(estudiante.getT1());
				int a=estudiante.getA1()+estudiante.getA2()+estudiante.getA3()+estudiante.getA4();
				estudianteExistente.setTo1(a);
				estudianteExistente.setTo2((a*25)/asistencia);
				estudianteExistente.setTo3((estudiante.getP1()*25)/practica);
				estudianteExistente.setTo4((estudiante.getT1()*25)/trabajo);
				estudianteExistente.setTo5((estudiante.getE1()*25)/evento);
				int b=((a*25)/asistencia)+((estudiante.getP1()*25)/practica)+((estudiante.getT1()*25)/trabajo)+((estudiante.getE1()*25)/evento);
				estudianteExistente.setTt(b);
				if(estudiante.getCre_hobb().equals("Hobby")) {
					estudianteExistente.setSituacion("No aplica");
				}else {
					if(b>=80) {
						estudianteExistente.setSituacion("Si");
					}else{
						estudianteExistente.setSituacion("No");
					}
				}
				servicio.evaluarEstudiante(estudianteExistente);
				return "redirect:/estudiantes/evaluar";
			}while(criterioExistente.getId()==1);
		}
		return "redirect:/estudiantes/evaluar";
	}
	
	@GetMapping({"/estudiantes/reporteC"})
	public String reportarCEstudiantes(Model modelo, @Param("palabraClave") String palabraClave) {
		modelo.addAttribute("estudiantes", servicio.mostrarTodosLosEstudiantes(palabraClave));
		modelo.addAttribute("palabraClave", palabraClave);
		return "reporteCarrera";
	}
	
	@GetMapping({"/estudiantes/reporteA"})
	public String reportarAEstudiantes(Model modelo, @Param("palabraA") String palabraA) {
		modelo.addAttribute("estudiantes", servicio.mostrarTodosLosEstud(palabraA));
		modelo.addAttribute("palabraA", palabraA);
		return "reporteActividad";
	}
	
	@GetMapping({"/estudiantes/exportarExcel"})
	public void exportarListadoDeEstudiantesExcel(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		
		String cabecera="Content-Disposition";
		String valor="attachment; filename=ReporteEstudiantes"+".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Estudiante> estudiantes=servicio.listarTodosLosEstudiantes();
		
		EstudianteExporter exporter=new EstudianteExporter(estudiantes);
		exporter.exportar(response);
	}
	

}
