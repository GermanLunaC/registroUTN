package com.app.web.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.web.entidad.Criterio;

@Repository
public interface CriterioRepositorio extends JpaRepository<Criterio, Long>{

	
}
