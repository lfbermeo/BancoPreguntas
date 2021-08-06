package com.example.bancopreguntasweb.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bancopreguntasweb.models.entities.Usuario;


@Repository("usuarioRepository")
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	
	public Usuario findByUsuario(String usuario);

}
