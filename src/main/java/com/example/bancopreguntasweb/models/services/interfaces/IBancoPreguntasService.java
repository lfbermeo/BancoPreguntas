package com.example.bancopreguntasweb.models.services.interfaces;

import java.util.List;

import com.example.bancopreguntasweb.models.entities.BancoPreguntas;
import com.example.bancopreguntasweb.models.entities.Usuario;

public interface IBancoPreguntasService {
	
	public List<BancoPreguntas> listAll();

	public void save(BancoPreguntas area);

	public BancoPreguntas get(Integer id);

	public void delete(Integer id);
	
	public BancoPreguntas findByCodigo(String codigo);
	
	public List<BancoPreguntas> findByUsuario(Usuario usuario);

}
