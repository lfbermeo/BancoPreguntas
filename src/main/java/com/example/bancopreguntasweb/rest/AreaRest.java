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

import com.example.bancopreguntasweb.models.entities.Area;
import com.example.bancopreguntasweb.models.services.implementation.AreaServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api")
public class AreaRest {
	
	
	@Autowired
	private AreaServiceImpl service;
	
	// Listar 
		@RequestMapping("/listarareas")
		public List<Area> get() {
			List<Area> objEnlazado = service.listAll();
			return objEnlazado;
		}
		
	// Obtener por id
	@RequestMapping("/area/{id}")
	public ResponseEntity<Area> getById(@PathVariable(value = "id") Integer id) {
		Area objP = service.get(id);
		if (objP == null) {
			return new ResponseEntity<Area>(objP, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Area>(objP, HttpStatus.OK);
	}
	
	// Guardar y actualizar
		@PostMapping("/guardararea")
		public void guardar(@RequestBody Area area) {
			service.save(area);
		}

		// Eliminar registro 
		@GetMapping("/eliminararea/{id}")
		public void eliminar(@PathVariable Integer id) {
			Area obj = service.get(id);
			if (obj != null) {
				service.delete(id);
			}
		}

}
