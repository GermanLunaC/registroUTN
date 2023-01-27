package com.app.web.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.app.web.entidad.Estudiante;

@Repository
public interface EstudianteRepositorio  extends JpaRepository<Estudiante, Long>{
	@Query("SELECT e FROM Estudiante e WHERE e.carrera LIKE %?1%")
	public List<Estudiante> findAll(String palabraClave);
	
	@Query("SELECT e FROM Estudiante e WHERE e.actividad LIKE %?1%")
	public List<Estudiante> mostrarA(String palabraA);
}
