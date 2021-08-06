package com.example.bancopreguntasweb.rest.juego;

public class PreguntaJSON {
	
	private String enunciado;
	private String res1;
	private String res2;
	private String res3;
	private String rescorrecta;
	private String retroalimentacion;
	
	
	
	
	public PreguntaJSON() {
	
	}
	
	
	public PreguntaJSON(String enunciado, String res1, String res2, String res3, String rescorrecta,
			String retroalimentacion) {
		super();
		this.enunciado = enunciado;
		this.res1 = res1;
		this.res2 = res2;
		this.res3 = res3;
		this.rescorrecta = rescorrecta;
		this.retroalimentacion = retroalimentacion;
	}
	public String getEnunciado() {
		return enunciado;
	}
	public String getRes1() {
		return res1;
	}
	public String getRes2() {
		return res2;
	}
	public String getRes3() {
		return res3;
	}
	public String getRescorrecta() {
		return rescorrecta;
	}
	public String getRetroalimentacion() {
		return retroalimentacion;
	}
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
	public void setRes1(String res1) {
		this.res1 = res1;
	}
	public void setRes2(String res2) {
		this.res2 = res2;
	}
	public void setRes3(String res3) {
		this.res3 = res3;
	}
	public void setRescorrecta(String rescorrecta) {
		this.rescorrecta = rescorrecta;
	}
	public void setRetroalimentacion(String retroalimentacion) {
		this.retroalimentacion = retroalimentacion;
	}
	
	
	
	

}
