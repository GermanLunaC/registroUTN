package com.app.web.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="criterios")
public class Criterio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "asistencia",nullable =false, length=2)
	private int asistencia;
	
	@Column(name = "practica",nullable =false, length=2)
	private int practica;
	
	@Column(name = "trabajo",nullable =false, length=2)
	private int trabajo;
	
	@Column(name = "evento",nullable =false, length=2)
	private int evento;
	
	public Criterio() {
	}
	
	public Criterio(int asistencia, int practica, int trabajo, int evento) {
		super();
		this.asistencia = asistencia;
		this.practica = practica;
		this.trabajo = trabajo;
		this.evento = evento;
	}
	
	public Criterio(Long id, int asistencia, int practica, int trabajo, int evento) {
		super();
		this.id = id;
		this.asistencia = asistencia;
		this.practica = practica;
		this.trabajo = trabajo;
		this.evento = evento;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(int asistencia) {
		this.asistencia = asistencia;
	}

	public int getPractica() {
		return practica;
	}

	public void setPractica(int practica) {
		this.practica = practica;
	}

	public int getTrabajo() {
		return trabajo;
	}

	public void setTrabajo(int trabajo) {
		this.trabajo = trabajo;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	@Override
	public String toString() {
		return "Criterio [asistencia=" + asistencia + ", practica=" + practica + ", trabajo=" + trabajo + ", evento="
				+ evento + "]";
	}

	
	
	
	
}
