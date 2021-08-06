package com.example.bancopreguntasweb.rest.juego;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*")
@RestController
@RequestMapping(path = "/api/juego")
public class JuegoRest {

	
	
	@Autowired
	JuegoQueries queriesJuego;

	/*@RequestMapping("/bancopreguntas/{codigo}")
	public HashMap<String, BancoJSON> obtenerBancoPreguntas(@PathVariable(value = "codigo") String codigo) {
		return queriesJuego.obtenerBancoPreguntas(codigo);
	}*/
	@RequestMapping("/bancopreguntas/{codigo}")
	public BancoJSON obtenerBancoPreguntas(@PathVariable(value = "codigo") String codigo) {
		return queriesJuego.obtenerBancoPreguntas(codigo);
	}
}
