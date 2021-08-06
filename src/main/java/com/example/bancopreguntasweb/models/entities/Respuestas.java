package com.example.bancopreguntasweb.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "respuestas")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idrespuestas", scope = Respuestas.class)
public class Respuestas implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idrespuestas", unique = true, nullable = false)
	private Integer idrespuestas;
	
	
	@Column(name = "nombreJugador", nullable = false, length = 45)
	private String nombreJugador;
	
	@Column(name = "puntaje", nullable = false)
	private double puntaje;
	
	@Column(name = "rescorrectas", nullable = false)
	private int rescorrectas;
	
	@Column(name = "resincorrectas", nullable = false)
	private int resincorrectas;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idbancopreguntas", referencedColumnName = "idbancopreguntas")
	private BancoPreguntas bancopreguntas;
	
	
	public Respuestas() {
	}

	public Respuestas(Integer idrespuestas, String nombreJugador, double puntaje, int rescorrectas, int resincorrectas,
			BancoPreguntas bancopreguntas) {
		super();
		this.idrespuestas = idrespuestas;
		this.nombreJugador = nombreJugador;
		this.puntaje = puntaje;
		this.rescorrectas = rescorrectas;
		this.resincorrectas = resincorrectas;
		this.bancopreguntas = bancopreguntas;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getIdrespuestas() {
		return idrespuestas;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public int getRescorrectas() {
		return rescorrectas;
	}

	public int getResincorrectas() {
		return resincorrectas;
	}

	public BancoPreguntas getBancopreguntas() {
		return bancopreguntas;
	}

	public void setIdrespuestas(Integer idrespuestas) {
		this.idrespuestas = idrespuestas;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public void setPuntaje(double puntaje) {
		this.puntaje = puntaje;
	}

	public void setRescorrectas(int rescorrectas) {
		this.rescorrectas = rescorrectas;
	}

	public void setResincorrectas(int resincorrectas) {
		this.resincorrectas = resincorrectas;
	}

	public void setBancopreguntas(BancoPreguntas bancopreguntas) {
		this.bancopreguntas = bancopreguntas;
	}
	
	
	
	

}
