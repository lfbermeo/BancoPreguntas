package com.example.bancopreguntasweb.models.services.interfaces;

import java.util.List;

import com.example.bancopreguntasweb.models.entities.Carrera;
import com.example.bancopreguntasweb.models.entities.CarreraEntidad;

public interface ICarreraService {

	
	public List<Carrera> listAll();

	public void save(Carrera area);

	public Carrera get(Integer id);

	public void delete(Integer id);
	
	public List<CarreraEntidad> findByArea(int id);
}
