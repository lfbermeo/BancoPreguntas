package com.example.bancopreguntasweb.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancopreguntasweb.models.dao.IBancoPreguntasRepository;

import com.example.bancopreguntasweb.models.entities.BancoPreguntas;
import com.example.bancopreguntasweb.models.entities.Usuario;
import com.example.bancopreguntasweb.models.services.interfaces.IBancoPreguntasService;

@Service
public class BancoPreguntasServiceImpl implements IBancoPreguntasService  {
	
	@Autowired
	private IBancoPreguntasRepository repo;

	@Override
	public List<BancoPreguntas> listAll() {

		return repo.findAll();
	}

	@Override
	public void save(BancoPreguntas bancopreguntas) {
		repo.save(bancopreguntas);
		
	}

	@Override
	public BancoPreguntas get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}
	
	@Override
	public BancoPreguntas findByCodigo(String codigo) {
		return repo.findByCodigo(codigo);
		
	}
	
	@Override
	public List<BancoPreguntas> findByUsuario(Usuario usuario){
		return repo.findByUsuario(usuario);
		
	}

	

}
