package com.example.bancopreguntasweb.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancopreguntasweb.models.dao.IAreaRepository;
import com.example.bancopreguntasweb.models.entities.Area;
import com.example.bancopreguntasweb.models.services.interfaces.IAreaService;


@Service
public class AreaServiceImpl implements IAreaService {
	
	@Autowired
	private IAreaRepository repo;

	@Override
	public List<Area> listAll() {

		return repo.findAll();
	}

	@Override
	public void save(Area area) {
		repo.save(area);
		
	}

	@Override
	public Area get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}

}
