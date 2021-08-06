package com.example.bancopreguntasweb.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.bancopreguntasweb.models.dao.ICarreraRepository;

import com.example.bancopreguntasweb.models.entities.Carrera;
import com.example.bancopreguntasweb.models.entities.CarreraEntidad;
import com.example.bancopreguntasweb.models.services.interfaces.ICarreraService;

@Service
public class CarreraServiceImpl implements ICarreraService{
	
	@Autowired
	private ICarreraRepository repo;

	@Override
	public List<Carrera> listAll() {

		return repo.findAll();
	}

	@Override
	public void save(Carrera carrera) {
		repo.save(carrera);
		
	}

	@Override
	public Carrera get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<CarreraEntidad> findByArea(int id) {
		return repo.findByArea(id);
	}


}
