package com.example.bancopreguntasweb.models.services.interfaces;

import java.util.List;

import com.example.bancopreguntasweb.models.entities.Respuestas;

public interface IRespuestasService {
	
	public List<Respuestas> listAll();

	public void save(Respuestas area);

	public Respuestas get(Integer id);

	public void delete(Integer id);

}
