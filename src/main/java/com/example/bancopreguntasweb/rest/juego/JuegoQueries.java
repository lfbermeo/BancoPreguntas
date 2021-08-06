package com.example.bancopreguntasweb.rest.juego;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bancopreguntasweb.models.entities.BancoPreguntas;
import com.example.bancopreguntasweb.models.entities.Pregunta;
import com.example.bancopreguntasweb.models.services.implementation.BancoPreguntasServiceImpl;







@Service
public class JuegoQueries {
	
	
	@Autowired
	private BancoPreguntasServiceImpl service_bancoPreguntas;
	
	/*
	public HashMap<String, BancoJSON> obtenerBancoPreguntas(String codigo) {
		
		BancoJSON objJSONBanco = new BancoJSON();
		HashMap<String, BancoJSON> returnJSON = new HashMap<String, BancoJSON>();
		
		BancoPreguntas objBanco = service_bancoPreguntas.findByCodigo(codigo);
		
		objJSONBanco.setIdbancopreguntas(objBanco.getIdbancopreguntas());
		objJSONBanco.setCodigo(objBanco.getCodigo());
		objJSONBanco.setTema(objBanco.getTema());
		objJSONBanco.setArea(objBanco.getCarrera().getArea().getNombre());
		objJSONBanco.setCarrera(objBanco.getCarrera().getNombre());
		
		
		
		List<PreguntaJSON> lspreguntasJSON = new ArrayList<PreguntaJSON>();
		for(Pregunta pregunta: objBanco.getPreguntas()) {
			lspreguntasJSON.add(
					new PreguntaJSON(
							pregunta.getEnunciado(), 
							pregunta.getRes1(), 
							pregunta.getRes2(), 
							pregunta.getRes3(),  
							pregunta.getRescorrecta(), 
							pregunta.getRetroalimentacion()));
		}
		objJSONBanco.setLspreguntas(lspreguntasJSON);
		returnJSON.put("bancopreguntas_" + codigo, objJSONBanco);
		
		return returnJSON;
		 
	}
	*/
public  BancoJSON obtenerBancoPreguntas(String codigo) {
		
		BancoJSON objJSONBanco = new BancoJSON();
		HashMap<String, BancoJSON> returnJSON = new HashMap<String, BancoJSON>();
		
		BancoPreguntas objBanco = service_bancoPreguntas.findByCodigo(codigo);
		
		objJSONBanco.setIdbancopreguntas(objBanco.getIdbancopreguntas());
		objJSONBanco.setCodigo(objBanco.getCodigo());
		objJSONBanco.setTema(objBanco.getTema());
		objJSONBanco.setArea(objBanco.getCarrera().getArea().getNombre());
		objJSONBanco.setCarrera(objBanco.getCarrera().getNombre());
		
		
		
		List<PreguntaJSON> lspreguntasJSON = new ArrayList<PreguntaJSON>();
		for(Pregunta pregunta: objBanco.getPreguntas()) {
			lspreguntasJSON.add(
					new PreguntaJSON(
							pregunta.getEnunciado(), 
							pregunta.getRes1(), 
							pregunta.getRes2(), 
							pregunta.getRes3(),  
							pregunta.getRescorrecta(), 
							pregunta.getRetroalimentacion()));
		}
		objJSONBanco.setLspreguntas(lspreguntasJSON);
		returnJSON.put("bancopreguntas_" + codigo, objJSONBanco);
		
		return objJSONBanco;
		 
	}

}
