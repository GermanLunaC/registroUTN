package com.app.web.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="estudiantes")
public class Estudiante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name",nullable =false, length=150)
	private String nombre;

	@Column(name = "matricula",nullable =false, length=9, unique = true)
	private int matricula;
	
	@Column(name = "carrera",nullable =false, length=70)
	private String carrera;
	
	@Column(name = "actividad",nullable =false, length=50)
	private String actividad;
	
	@Column(name = "fechaI",nullable =false, length=50)
	private String fechaI;
	
	@Column(name = "sexo",nullable =false, length=10)
	private String sexo;
	
	@Column(name = "cre_hobb",nullable =false, length=50)
	private String cre_hobb;
	
	@Column(name = "categoria",nullable =false, length=50)
	private String categoria;

	@Column(name = "grupo",nullable =false, length=50)
	private String grupo;
	
	@Column(name = "situacion",nullable =false, length=150)
	private String situacion="No";
	
	@Column(name = "a1",nullable =false, length=2)
	private int a1;
	
	@Column(name = "a2",nullable =false, length=2)
	private int a2;
	
	@Column(name = "a3",nullable =false, length=2)
	private int a3;
	
	@Column(name = "a4",nullable =false, length=2)
	private int a4;
	
	@Column(name = "p1",nullable =false, length=2)
	private int p1;
	
	@Column(name = "t1",nullable =false, length=2)
	private int t1;
	
	@Column(name = "e1",nullable =false, length=2)
	private int e1;
	
	@Column(name = "to1",nullable =false, length=10)
	private int to1;
	
	@Column(name = "to2",nullable =false, length=10)
	private int to2;
	
	@Column(name = "to3",nullable =false, length=10)
	private int to3;
	
	@Column(name = "to4",nullable =false, length=10)
	private int to4;
	
	@Column(name = "tt",nullable =false, length=10)
	private int tt;
	
	@Column(name = "to5",nullable =false, length=10)
	private int to5;
	
	public Estudiante() {
	}

	public Estudiante(Long id, String nombre, int matricula, String carrera, String actividad, String fechaI,
			String sexo, String cre_hobb, String categoria, String grupo, int a1, int a2, int a3, int a4, int p1,
			int t1, int e1, int to1, int to2, int to3, int to4, int tt, int to5, String situacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.matricula = matricula;
		this.carrera = carrera;
		this.actividad = actividad;
		this.fechaI = fechaI;
		this.sexo = sexo;
		this.cre_hobb = cre_hobb;
		this.categoria = categoria;
		this.grupo = grupo;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.a4 = a4;
		this.p1 = p1;
		this.t1 = t1;
		this.e1 = e1;
		this.to1 = to1;
		this.to2 = to2;
		this.to3 = to3;
		this.to4 = to4;
		this.tt = tt;
		this.to5 = to5;
		this.situacion = situacion;
	}

	public Estudiante(String nombre, int matricula, String carrera, String actividad, String fechaI, String sexo,
			String cre_hobb, String categoria, String grupo, int a1, int a2, int a3, int a4, int p1, int t1, int e1,
			int to1, int to2, int to3, int to4, int tt, int to5, String situacion) {
		super();
		this.nombre = nombre;
		this.matricula = matricula;
		this.carrera = carrera;
		this.actividad = actividad;
		this.fechaI = fechaI;
		this.sexo = sexo;
		this.cre_hobb = cre_hobb;
		this.categoria = categoria;
		this.grupo = grupo;
		this.a1 = a1;
		this.a2 = a2;
		this.a3 = a3;
		this.a4 = a4;
		this.p1 = p1;
		this.t1 = t1;
		this.e1 = e1;
		this.to1 = to1;
		this.to2 = to2;
		this.to3 = to3;
		this.to4 = to4;
		this.tt = tt;
		this.to5 = to5;
		this.situacion = situacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long i) {
		this.id = i;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getFechaI() {
		return fechaI;
	}

	public void setFechaI(String fechaI) {
		this.fechaI = fechaI;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCre_hobb() {
		return cre_hobb;
	}

	public void setCre_hobb(String cre_hobb) {
		this.cre_hobb = cre_hobb;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public int getA1() {
		return a1;
	}

	public void setA1(int a1) {
		this.a1 = a1;
	}

	public int getA2() {
		return a2;
	}

	public void setA2(int a2) {
		this.a2 = a2;
	}

	public int getA3() {
		return a3;
	}

	public void setA3(int a3) {
		this.a3 = a3;
	}

	public int getA4() {
		return a4;
	}

	public void setA4(int a4) {
		this.a4 = a4;
	}

	public int getP1() {
		return p1;
	}

	public void setP1(int p1) {
		this.p1 = p1;
	}

	public int getT1() {
		return t1;
	}

	public void setT1(int t1) {
		this.t1 = t1;
	}

	public int getE1() {
		return e1;
	}

	public void setE1(int e1) {
		this.e1 = e1;
	}

	public int getTo1() {
		return to1;
	}

	public void setTo1(int to1) {
		this.to1 = to1;
	}

	public int getTo2() {
		return to2;
	}

	public void setTo2(int to2) {
		this.to2 = to2;
	}

	public int getTo3() {
		return to3;
	}

	public void setTo3(int to3) {
		this.to3 = to3;
	}

	public int getTo4() {
		return to4;
	}

	public void setTo4(int to4) {
		this.to4 = to4;
	}

	public int getTt() {
		return tt;
	}

	public void setTt(int tt) {
		this.tt = tt;
	}

	public int getTo5() {
		return to5;
	}

	public void setTo5(int to5) {
		this.to5 = to5;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", matricula=" + matricula + ", carrera=" + carrera
				+ ", actividad=" + actividad + ", fechaI=" + fechaI + ", sexo=" + sexo + ", cre_hobb=" + cre_hobb
				+ ", categoria=" + categoria + ", grupo=" + grupo + ", a1=" + a1 + ", a2=" + a2 + ", a3=" + a3 + ", a4="
				+ a4 + ", p1=" + p1 + ", t1=" + t1 + ", e1=" + e1 + ", to1=" + to1 + ", to2=" + to2 + ", to3=" + to3
				+ ", to4=" + to4 + ", tt=" + tt + ", to5=" + to5 + "]";
	}
	
	
	
}
