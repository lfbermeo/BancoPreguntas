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
@Table(name = "carrera")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idcarrera", scope = Carrera.class)
public class Carrera implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idcarrera", unique = true, nullable = false)
	private Integer idcarrera;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idarea", referencedColumnName = "idarea")
	private Area area;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carrera")
	private Set<BancoPreguntas> bancopreguntas = new HashSet<BancoPreguntas>(0);
	
	
	public Carrera() {
	}
	
	public Carrera(Integer idcarrera, String nombre, Area area, Set<BancoPreguntas> bancopreguntas) {
		super();
		this.idcarrera = idcarrera;
		this.nombre = nombre;
		this.area = area;
		this.bancopreguntas = bancopreguntas;
	}

	
	
	public Area getArea() {
		return area;
	}


	public void setArea(Area area) {
		this.area = area;
	}


	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdcarrera() {
		return idcarrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setIdcarrera(Integer idcarrera) {
		this.idcarrera = idcarrera;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<BancoPreguntas> getBancopreguntas() {
		return bancopreguntas;
	}

	public void setBancopreguntas(Set<BancoPreguntas> bancopreguntas) {
		this.bancopreguntas = bancopreguntas;
	}
	
	
	
	

}
