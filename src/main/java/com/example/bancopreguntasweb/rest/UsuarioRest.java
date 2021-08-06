package com.example.bancopreguntasweb.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.bancopreguntasweb.models.entities.Usuario;
import com.example.bancopreguntasweb.models.services.implementation.UsuarioServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class UsuarioRest {
	
	
	@Autowired
	private UsuarioServiceImpl service;
	
	// Listar 
		@RequestMapping("/listarusuarios")
		public List<Usuario> get() {
			List<Usuario> objEnlazado = service.listAll();
			return objEnlazado;
		}
		
	// Obtener por id
	@RequestMapping("/usuario/{id}")
	public ResponseEntity<Usuario> getById(@PathVariable(value = "id") Integer id) {
		Usuario objP = service.get(id);
		if (objP == null) {
			return new ResponseEntity<Usuario>(objP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Usuario>(objP, HttpStatus.OK);
	}
	
	// Guardar y actualizar
		@PostMapping("/guardarusuario")
		public void guardar(@RequestBody Usuario usuario) {
			service.save(usuario);
		}

		// Eliminar registro 
		@GetMapping("/eliminarusuario/{id}")
		public void eliminar(@PathVariable Integer id) {
			Usuario obj = service.get(id);
			if (obj != null) {
				service.delete(id);
			}
		}

}
