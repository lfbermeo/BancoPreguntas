package com.example.bancopreguntasweb.config;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.bancopreguntasweb.models.entities.Usuario;
import com.example.bancopreguntasweb.models.services.implementation.UsuarioServiceImpl;



@Component
@SessionAttributes("usuario")
public class CustomSuccessHandler implements AuthenticationSuccessHandler {
	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		String redirectUrl = null;
		Usuario usuario = usuarioService.findByUsuario(authentication.getName());
	    request.getSession().setAttribute("usuario",usuario);

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {

			if (grantedAuthority.getAuthority().equals("ROLE_PROFESOR")) {
				usuario.setRol("PROFESOR");
				redirectUrl = "profesor/inicio_profesor";
				break;
			} else if (grantedAuthority.getAuthority().equals("ROLE_ADMINISTRADOR")) {
				usuario.setRol("ADMINISTRADOR");
				redirectUrl = "administrador/inicio_admin";
				break;
			}
		}
		if (redirectUrl == null) {
			throw new IllegalStateException();
		}
		new DefaultRedirectStrategy().sendRedirect(request, response, redirectUrl);
	}

}
