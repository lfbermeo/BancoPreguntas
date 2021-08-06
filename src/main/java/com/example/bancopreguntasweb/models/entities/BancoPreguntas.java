package com.example.bancopreguntasweb.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "bancopreguntas")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idbancopreguntas", scope = BancoPreguntas.class)

public class BancoPreguntas implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idbancopreguntas", unique = true, nullable = false)
	private Integer idbancopreguntas;
	
	@Column(name = "codigo", nullable = false, length = 5)
	private String codigo;
	
	@Column(name = "tema", nullable = false, length = 45)
	private String tema;
	
	@Column(name = "asignatura", nullable = false, length = 45)
	private String asignatura;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idusuario", referencedColumnName = "idusuario")
	private Usuario usuario;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idcarrera", referencedColumnName = "idcarrera")
	private Carrera carrera;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bancopreguntas")
	private Set<Pregunta> preguntas = new HashSet<Pregunta>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bancopreguntas")
	private Set<Respuestas> respuestas = new HashSet<Respuestas>(0);
	
	public BancoPreguntas() {
	
	}
	

	public BancoPreguntas(Integer idbancopreguntas, String codigo, 
			String tema, String asignatura, Usuario usuario, Carrera carrera,
			Set<Pregunta> preguntas, Set<Respuestas> respuestas) {
		super();
		this.idbancopreguntas = idbancopreguntas;
		this.codigo = codigo;
		this.tema = tema;
		this.asignatura = asignatura;
		this.usuario = usuario;
		this.carrera = carrera;
		this.preguntas = preguntas;
		this.respuestas = respuestas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdbancopreguntas() {
		return idbancopreguntas;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTema() {
		return tema;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setIdbancopreguntas(Integer idbancopreguntas) {
		this.idbancopreguntas = idbancopreguntas;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Carrera getCarrera() {
		return carrera;
	}


	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}


	public Set<Pregunta> getPreguntas() {
		return preguntas;
	}


	public void setPreguntas(Set<Pregunta> preguntas) {
		this.preguntas = preguntas;
	}


	public Set<Respuestas> getRespuestas() {
		return respuestas;
	}


	public void setRespuestas(Set<Respuestas> respuestas) {
		this.respuestas = respuestas;
	}
	
	
	
	
}
