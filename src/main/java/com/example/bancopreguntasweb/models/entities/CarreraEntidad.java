package com.example.bancopreguntasweb.models.entities;

import java.io.Serializable;

public class CarreraEntidad implements Serializable{
	private int idcarrera;
	private String nombre;
	private int area;
	
	public CarreraEntidad() {
	}
	
	public CarreraEntidad(int idcarrera, String nombre) {
		this.idcarrera = idcarrera;
		this.nombre = nombre;
	}
	
	public CarreraEntidad(int idcarrera, String nombre, int area) {
		this.idcarrera = idcarrera;
		this.nombre = nombre;
		this.area = area;
	}
	
	public int getIdcarrera() {
		return idcarrera;
	}
	
	public void setIdcarrera(int idcarrera) {
		this.idcarrera = idcarrera;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	private static final long serialVersionUID = 1L;
}
