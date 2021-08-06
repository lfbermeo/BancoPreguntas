package com.example.bancopreguntasweb.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bancopreguntasweb.models.entities.BancoPreguntas;
import com.example.bancopreguntasweb.models.entities.Usuario;



@Repository("bancopreguntasRepository")
public interface IBancoPreguntasRepository extends JpaRepository<BancoPreguntas, Integer> {
	
	public BancoPreguntas findByCodigo(String codigo);
	
	
	public List<BancoPreguntas> findByUsuario(Usuario usuario);

}
