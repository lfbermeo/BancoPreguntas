package com.example.bancopreguntasweb.models.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@Table(name = "area")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idarea", scope = Area.class)
public class Area implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idarea", unique = true, nullable = false)
	private Integer idarea;
	
	@Column(name = "nombre", nullable = false, length = 100)
	private String nombre;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "area")
	private Set<Carrera> carreras = new HashSet<Carrera>(0);
	
	
	public Area() {
	
	}
	public Area(Integer idarea, String nombre, Set<Carrera> carreras) {
		super();
		this.idarea = idarea;
		this.nombre = nombre;
		this.carreras = carreras;
	}

	public Set<Carrera> getCarreras() {
		return carreras;
	}

	public void setCarreras(Set<Carrera> carreras) {
		this.carreras = carreras;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdarea() {
		return idarea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setIdarea(Integer idarea) {
		this.idarea = idarea;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	

}
