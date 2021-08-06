package com.example.bancopreguntasweb.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancopreguntasweb.models.dao.IRespuestasRepository;

import com.example.bancopreguntasweb.models.entities.Respuestas;
import com.example.bancopreguntasweb.models.services.interfaces.IRespuestasService;

@Service
public class RespuestasServiceImpl implements IRespuestasService {
	
	@Autowired
	private IRespuestasRepository repo;

	@Override
	public List<Respuestas> listAll() {

		return repo.findAll();
	}

	@Override
	public void save(Respuestas respuestas) {
		repo.save(respuestas);
		
	}

	@Override
	public Respuestas get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}

}
