package com.example.bancopreguntasweb.models.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancopreguntasweb.models.dao.IUsuarioRepository;

import com.example.bancopreguntasweb.models.entities.Usuario;
import com.example.bancopreguntasweb.models.services.interfaces.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	private IUsuarioRepository repo;

	@Override
	public List<Usuario> listAll() {

		return repo.findAll();
	}

	@Override
	public void save(Usuario usuario) {
		repo.save(usuario);
		
	}

	@Override
	public Usuario get(Integer id) {
		return repo.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		repo.deleteById(id);
		
	}
	
	@Override
	public Usuario findByUsuario(String usuario) {
		return repo.findByUsuario(usuario);
	}

}
