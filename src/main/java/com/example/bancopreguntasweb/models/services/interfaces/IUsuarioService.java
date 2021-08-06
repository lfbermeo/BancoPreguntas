package com.example.bancopreguntasweb.models.services.interfaces;

import java.util.List;

import com.example.bancopreguntasweb.models.entities.Usuario;

public interface IUsuarioService {
	
	
	public List<Usuario> listAll();

	public void save(Usuario area);

	public Usuario get(Integer id);

	public void delete(Integer id);
	
	public Usuario findByUsuario(String usuario);

}
