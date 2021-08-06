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


import com.example.bancopreguntasweb.models.entities.BancoPreguntas;
import com.example.bancopreguntasweb.models.services.implementation.BancoPreguntasServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class BancoPreguntasRest {
	
	
	@Autowired
	private BancoPreguntasServiceImpl service;
	
	// Listar 
		@RequestMapping("/listarbancopreguntas")
		public List<BancoPreguntas> get() {
			List<BancoPreguntas> objEnlazado = service.listAll();
			return objEnlazado;
		}
		
	// Obtener por id
	@RequestMapping("/bancopreguntas/{id}")
	public ResponseEntity<BancoPreguntas> getById(@PathVariable(value = "id") Integer id) {
		BancoPreguntas objP = service.get(id);
		if (objP == null) {
			return new ResponseEntity<BancoPreguntas>(objP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<BancoPreguntas>(objP, HttpStatus.OK);
	}
	
	// Guardar y actualizar
		@PostMapping("/guardarbancopreguntas")
		public void guardar(@RequestBody BancoPreguntas banco) {
			service.save(banco);
		}

		// Eliminar registro 
		@GetMapping("/eliminarbancopreguntas/{id}")
		public void eliminar(@PathVariable Integer id) {
			BancoPreguntas obj = service.get(id);
			if (obj != null) {
				service.delete(id);
			}
		}

}
