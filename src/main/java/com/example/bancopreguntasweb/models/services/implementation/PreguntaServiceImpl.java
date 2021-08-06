package com.example.bancopreguntasweb.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.bancopreguntasweb.models.dao.IPreguntaRepository;
import com.example.bancopreguntasweb.models.entities.Pregunta;
import com.example.bancopreguntasweb.models.services.interfaces.IPreguntaService;

@Service
public class PreguntaServiceImpl implements IPreguntaService {

	
	@Autowired
	private IPreguntaRepository repo;

	@Override
	public List<Pregunta> listAll() {

		return repo.findAll();
	}

	@Override
	public void save(Pregunta pregunta) {
		repo.save(pregunta);
		
	}

	@Override
	public Pregunta get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}
}
