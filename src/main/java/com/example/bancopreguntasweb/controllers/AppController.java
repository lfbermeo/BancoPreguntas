package com.example.bancopreguntasweb.controllers;



import java.util.Map;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("usuario")
public class AppController {

	@RequestMapping("/")
	public String inicioSistema(Map<String, Object> model) {

		return "redirect:/login";
	}

	
	
	

	

	
	
	

	
	
	


}
