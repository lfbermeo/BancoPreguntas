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
@Table(name = "pregunta")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idpregunta", scope = Pregunta.class)
public class Pregunta implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idpregunta", unique = true, nullable = false)
	private Integer idpregunta;
	
	@Column(name = "enunciado", nullable = false, length = 45)
	private String enunciado;
	
	@Column(name = "res1", nullable = false, length = 45)
	private String res1;
	
	@Column(name = "res2", nullable = false, length = 45)
	private String res2;
	
	@Column(name = "res3", nullable = false, length = 45)
	private String res3;
	
	@Column(name = "rescorrecta", nullable = false, length = 45)
	private String rescorrecta;
	
	@Column(name = "retroalimentacion", nullable = false, length = 45)
	private String retroalimentacion;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idbancopreguntas", referencedColumnName = "idbancopreguntas")
	private BancoPreguntas bancopreguntas;


	
	public Pregunta() {
	}
	
	public Pregunta(Integer idpregunta, String enunciado, String res1, String res2, String res3, String rescorrecta,
			String retroalimentacion, BancoPreguntas bancopreguntas) {
		super();
		this.idpregunta = idpregunta;
		this.enunciado = enunciado;
		this.res1 = res1;
		this.res2 = res2;
		this.res3 = res3;
		this.rescorrecta = rescorrecta;
		this.retroalimentacion = retroalimentacion;
		this.bancopreguntas = bancopreguntas;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public Integer getIdpregunta() {
		return idpregunta;
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


	public BancoPreguntas getBancopreguntas() {
		return bancopreguntas;
	}


	public void setIdpregunta(Integer idpregunta) {
		this.idpregunta = idpregunta;
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


	public void setBancopreguntas(BancoPreguntas bancopreguntas) {
		this.bancopreguntas = bancopreguntas;
	}
	
	
	
	

}
