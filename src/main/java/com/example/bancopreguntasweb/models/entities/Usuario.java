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
@Table(name = "usuario")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idusuario", scope = Usuario.class)
public class Usuario implements java.io.Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Generar ID's de objetos automaticamente para objetos
	@Column(name = "idusuario", unique = true, nullable = false)
	private Integer idusuario;
	
	@Column(name = "nombres", nullable = false, length = 45)
	private String nombres;
	
	@Column(name = "apellidos", nullable = false, length = 45)
	private String apellidos;
	
	@Column(name = "email", unique = true, nullable = false, length = 45)
	private String email;
	
	@Column(name = "usuario", unique = true, nullable = false, length = 45)
	private String usuario;
	
	@Column(name = "pass", nullable = false, length = 100)
	private String pass;
	
	@Column(name = "rol", nullable = false, length = 45)
	private String rol;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private Set<BancoPreguntas> bancopreguntas = new HashSet<BancoPreguntas>(0);
	
	
	public Usuario() {
		
	}
	
	public Usuario(Integer idusuario, String nombres, String apellidos, String email, String usuario, String pass,
			String rol, Set<BancoPreguntas> bancopreguntas) {
		super();
		this.idusuario = idusuario;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.usuario = usuario;
		this.pass = pass;
		this.rol = rol;
		this.bancopreguntas = bancopreguntas;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Integer getIdusuario() {
		return idusuario;
	}
	public String getNombres() {
		return nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public String getEmail() {
		return email;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getPass() {
		return pass;
	}
	public String getRol() {
		return rol;
	}
	public void setIdusuario(Integer idusuario) {
		this.idusuario = idusuario;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
}
