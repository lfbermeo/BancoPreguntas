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

import com.example.bancopreguntasweb.models.entities.Pregunta;
import com.example.bancopreguntasweb.models.services.implementation.PreguntaServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class PreguntaRest {

	
	
	@Autowired
	private PreguntaServiceImpl service;
	
	// Listar 
		@RequestMapping("/listarpreguntas")
		public List<Pregunta> get() {
			List<Pregunta> objEnlazado = service.listAll();
			return objEnlazado;
		}
		
	// Obtener por id
	@RequestMapping("/pregunta/{id}")
	public ResponseEntity<Pregunta> getById(@PathVariable(value = "id") Integer id) {
		Pregunta objP = service.get(id);
		if (objP == null) {
			return new ResponseEntity<Pregunta>(objP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Pregunta>(objP, HttpStatus.OK);
	}
	
	// Guardar y actualizar
		@PostMapping("/guardarpregunta")
		public void guardar(@RequestBody Pregunta pregunta) {
			service.save(pregunta);
		}

		// Eliminar registro 
		@GetMapping("/eliminarpregunta/{id}")
		public void eliminar(@PathVariable Integer id) {
			Pregunta obj = service.get(id);
			if (obj != null) {
				service.delete(id);
			}
		}
}
