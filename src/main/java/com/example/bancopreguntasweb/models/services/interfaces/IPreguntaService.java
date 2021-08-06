package com.example.bancopreguntasweb.models.services.interfaces;

import java.util.List;

import com.example.bancopreguntasweb.models.entities.Pregunta;

public interface IPreguntaService {
	
	public List<Pregunta> listAll();

	public void save(Pregunta area);

	public Pregunta get(Integer id);

	public void delete(Integer id);

}
