package com.example.bancopreguntasweb.controllers;

import java.security.Principal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.bancopreguntasweb.models.entities.Usuario;
import com.example.bancopreguntasweb.models.services.implementation.UsuarioServiceImpl;






@Controller
@SessionAttributes("usuario")
public class UsuarioController {
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UsuarioServiceImpl usuarioService;

	
	
	// Ingreso al sistema
		@RequestMapping("/login")
		public String login(@RequestParam(value = "error", required = false) String error,
				@RequestParam(value = "logout", required = false) String logout, Model model, Principal principal,
				RedirectAttributes flash) {
			System.out.println("entro login");
			model.addAttribute("titulo", "Sistema de Gamificación");

			if (principal != null) {
				flash.addFlashAttribute("info", "Ya inicio sesión anteriormente");
			
				Usuario actual_usuario = usuarioService.findByUsuario(principal.getName());
				if(actual_usuario.getRol().equals("ROLE_PROFESOR")) {
					return "redirect:/profesor/inicio_profesor";
				}else if (actual_usuario.getRol().equals("ROLE_ADMINISTRADOR")){
					return "redirect:/administrador/inicio_admin";
				}
			}

			if (error != null) {
				model.addAttribute("error", "Usuario o contraseña incorrectos, inténtelo nuevamente!");
			}

			if (logout != null) {
				model.addAttribute("success", "La sesión se cerró correctamente!");
			}

			return "login";
		}
		
		@RequestMapping("/registro")
		public String registro(Map<String, Object> model) {
			//model.addAttribute("titulo", "Gamificación juego 3D");
			Usuario usuario = new Usuario();
			model.put("titulo", "Registrar usuario");
			model.put("usuario", usuario);
			return "registro";
		}
		// Guardar usuario
		@RequestMapping(value = "/guardar_usuario", method = RequestMethod.POST)
		public String guardarUsuario(@RequestParam(value = "sms", required = false) String sms,
				@ModelAttribute("usuario") Usuario usuario, RedirectAttributes flash, SessionStatus status, Model model) {

			String mensajeFlash = (usuario.getIdusuario() != null) ? "Usuario creado exitosamente!"
					: "Usuario Registrado Exitosamente!";

			String pass = encoder.encode(usuario.getPass());
			usuario.setPass(pass);
			usuario.setRol("ROLE_PROFESOR");
			usuarioService.save(usuario);
			
			
			status.setComplete();
			
			flash.addFlashAttribute("success", mensajeFlash);
			System.out.println("Datos guardados correctamente!");

			// objeto para visualizar en la vista
			model.addAttribute("usuario", usuario);
			model.addAttribute("sms", "Usuario creado correctamente, inicie sesión!");
			String vista = "login";
			return vista;
		}
		
		
		
}
