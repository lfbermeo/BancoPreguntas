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


import com.example.bancopreguntasweb.models.entities.Carrera;
import com.example.bancopreguntasweb.models.services.implementation.CarreraServiceImpl;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class CarreraRest {
	
	
	@Autowired
	private CarreraServiceImpl service;
	
	// Listar 
		@RequestMapping("/listarcarreras")
		public List<Carrera> get() {
			List<Carrera> objEnlazado = service.listAll();
			return objEnlazado;
		}
		
	// Obtener por id
	@RequestMapping("/carrera/{id}")
	public ResponseEntity<Carrera> getById(@PathVariable(value = "id") Integer id) {
		Carrera objP = service.get(id);
		if (objP == null) {
			return new ResponseEntity<Carrera>(objP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Carrera>(objP, HttpStatus.OK);
	}
	
	// Guardar y actualizar
		@PostMapping("/guardarcarrera")
		public void guardar(@RequestBody Carrera carrera) {
			service.save(carrera);
		}

		// Eliminar registro 
		@GetMapping("/eliminarcarrera/{id}")
		public void eliminar(@PathVariable Integer id) {
			Carrera obj = service.get(id);
			if (obj != null) {
				service.delete(id);
			}
		}

}
