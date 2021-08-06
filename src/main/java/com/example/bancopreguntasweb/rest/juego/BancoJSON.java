package com.example.bancopreguntasweb.rest.juego;

import java.util.List;

public class BancoJSON {
	
	private int idbancopreguntas;
	private String codigo;
	private String tema;
	private String area;
	private String carrera;
	private List<PreguntaJSON> lspreguntas;
	
	
	public BancoJSON() {

	}
	
	public BancoJSON(int idbancopreguntas,String codigo, String tema, String area, String carrera, List<PreguntaJSON> lspreguntas) {
		super();
		this.idbancopreguntas = idbancopreguntas;
		this.codigo = codigo;
		this.tema = tema;
		this.area = area;
		this.carrera = carrera;
		this.lspreguntas = lspreguntas;
	}
	
	public int getIdbancopreguntas() {
		return idbancopreguntas;
	}

	public void setIdbancopreguntas(int idbancopreguntas) {
		this.idbancopreguntas = idbancopreguntas;
	}

	public String getCodigo() {
		return codigo;
	}
	public String getTema() {
		return tema;
	}
	public String getArea() {
		return area;
	}
	public String getCarrera() {
		return carrera;
	}
	public List<PreguntaJSON> getLspreguntas() {
		return lspreguntas;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setTema(String tema) {
		this.tema = tema;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public void setLspreguntas(List<PreguntaJSON> lspreguntas) {
		this.lspreguntas = lspreguntas;
	}
	
	
	

}
