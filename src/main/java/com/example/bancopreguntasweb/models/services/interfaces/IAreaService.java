package com.example.bancopreguntasweb.models.services.interfaces;

import java.util.List;

import com.example.bancopreguntasweb.models.entities.Area;


public interface IAreaService {
	
	public List<Area> listAll();

	public void save(Area area);

	public Area get(Integer id);

	public void delete(Integer id);

}
