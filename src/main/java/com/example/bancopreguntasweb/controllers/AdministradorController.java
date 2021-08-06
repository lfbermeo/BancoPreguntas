package com.example.bancopreguntasweb.controllers;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.bancopreguntasweb.models.entities.Area;
import com.example.bancopreguntasweb.models.entities.Carrera;
import com.example.bancopreguntasweb.models.entities.Usuario;
import com.example.bancopreguntasweb.models.services.implementation.AreaServiceImpl;
import com.example.bancopreguntasweb.models.services.implementation.CarreraServiceImpl;
import com.example.bancopreguntasweb.models.services.implementation.UsuarioServiceImpl;


@Secured("ROLE_ADMINISTRADOR")
@Controller
@RequestMapping("/administrador")
@SessionAttributes("usuario")
public class AdministradorController {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private AreaServiceImpl areasService;
	
	@Autowired
	private CarreraServiceImpl carrerasService;
	
	
	
	@RequestMapping("inicio_admin")
	public String inicio_admin(Model model) {
		String vista = "administrador/inicio_admin";
		return vista;
	}
	
	@RequestMapping("gestion_usuarios")
	public String gestion_usuarios(Model model) {
		String vista = "administrador/gestion_usuarios";	
		
		//Enviar la lista de usuarios
		List<Usuario> lsusuarios = usuarioService.listAll();
		model.addAttribute("lsusuarios", lsusuarios);
		
		return vista;
	}
	
	@RequestMapping("gestion_areas")
	public String gestion_areas(Model model) {
		String vista = "administrador/gestion_areas";	
		
		//Enviar la listas a la vista
		List<Area> lsareas = areasService.listAll();
		List<Carrera> lscarreras = carrerasService.listAll();
		
		model.addAttribute("lsareas", lsareas);
		model.addAttribute("lscarreras", lscarreras);
		return vista;
	}
	
	
	
	
	
	// Actualizar usuario desde vista admin cualquier usuario
	@RequestMapping(value = "actualizar_usuario", method = RequestMethod.POST)
	public String actualizar_usuario(@ModelAttribute("usuario1") Usuario usuario1, Model model) {
		String passactual = usuarioService.get(usuario1.getIdusuario()).getPass();
		
		Usuario objNuevo1 = new Usuario();
		objNuevo1.setIdusuario(usuario1.getIdusuario());
		objNuevo1.setNombres(usuario1.getNombres());
		objNuevo1.setApellidos(usuario1.getApellidos());
		objNuevo1.setEmail(usuario1.getEmail());
		objNuevo1.setRol(usuario1.getRol());
		objNuevo1.setUsuario(usuario1.getUsuario());
		
		
		if(usuario1.getPass()=="") {
			objNuevo1.setPass(passactual);	
		}else {
			objNuevo1.setPass(encoder.encode(usuario1.getPass()));
		}
		usuarioService.save(objNuevo1);
		//model.put("usuario", usuario);
		return "redirect:/administrador/gestion_usuarios";
	}
	
	
	
	
	// Actualizar usuario desde vista admin cuenta propia
		@RequestMapping(value = "actualizar_admin", method = RequestMethod.POST)
		public String actualizar_admin(@ModelAttribute("usuario") Usuario usuario, Map<String, Object> model) {
			String passactual = usuarioService.get(usuario.getIdusuario()).getPass();
			if(usuario.getPass()=="") {
				usuario.setPass(passactual);	
			}else {
				usuario.setPass(encoder.encode(usuario.getPass()));
			}
			usuario.setRol("ROLE_ADMINISTRADOR");
			usuarioService.save(usuario);
			return "administrador/inicio_admin";
		}
	
	
	
	
	
	
	// Guardar Informacion
	
	@RequestMapping(value = "crear_usuario", method = RequestMethod.POST)
	public String crear_usuario(@ModelAttribute("usuario") Usuario usuario,
			HttpServletRequest request, Map<String, Object> model) {
		

		Usuario objNuevo = usuarioService.get(usuario.getIdusuario());
		System.out.println(objNuevo.getEmail());
		
		
		String pass = encoder.encode(usuario.getPass());
		usuario.setPass(pass);
		
		Usuario objNuevo1 = new Usuario();
		objNuevo1.setNombres(usuario.getNombres());
		objNuevo1.setApellidos(usuario.getApellidos());
		objNuevo1.setEmail(usuario.getEmail());
		objNuevo1.setRol(usuario.getRol());
		objNuevo1.setUsuario(usuario.getUsuario());
		objNuevo1.setPass(pass);
			
		usuarioService.save(objNuevo1);
		
		model.put("usuario", objNuevo);
		
		
		return "redirect:/administrador/gestion_usuarios";
	}
	
	
	@RequestMapping(value = "guardar_area", method = RequestMethod.POST)
	public String guardar_area(@ModelAttribute("area") Area area, Model model) {
		areasService.save(area);
		return "redirect:/administrador/gestion_areas";
	}
	
	@RequestMapping(value = "guardar_carrera", method = RequestMethod.POST)
	public String guardar_carrera(@ModelAttribute("carrera") Carrera carrera, Model model) {
		carrerasService.save(carrera);
		return "redirect:/administrador/gestion_areas";
	}
	
	
	
	// ELIMINAR REGISTROS
	@RequestMapping(value = "eliminar_usuario", method = RequestMethod.POST)
	public String eliminar_usuario(@ModelAttribute("usuario1") Usuario usuario1, Model model) {
		usuarioService.delete(usuario1.getIdusuario());
		return "redirect:/administrador/gestion_usuarios";
	}
	@RequestMapping(value = "eliminar_area", method = RequestMethod.POST)
	public String eliminar_area(@ModelAttribute("area") Area area, Model model) {
		areasService.delete(area.getIdarea());
		return "redirect:/administrador/gestion_areas";
	}
	@RequestMapping(value = "eliminar_carrera", method = RequestMethod.POST)
	public String eliminar_carrera(@ModelAttribute("carrera") Carrera carrera, Model model) {
		carrerasService.delete(carrera.getIdcarrera());
		return "redirect:/administrador/gestion_areas";
	}
		

}
