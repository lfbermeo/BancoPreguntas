package com.example.bancopreguntasweb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	String[] resources = new String[] { "/include/**", "/bootstrap/**", "/css/**", "/fontawesome/**", "/img/**",
			"/js/**", "/jquery/**", "/datatables/**", "/layer" };
	// Utiliza la función de hash fuerte BCrypt.
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;

	@Autowired
	// private LoginSuccessHandler successHandler;
	private CustomSuccessHandler successHandler;

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(final HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(resources).permitAll().antMatchers("/api/**").permitAll().antMatchers("/")
				.permitAll()
				// Página de inicio sin login
				.antMatchers("/registro").permitAll()
				.antMatchers("/guardar_usuario").permitAll()
				
				.antMatchers("/profesor/**").hasRole("PROFESOR")
				.antMatchers("/administrador/**").hasRole("ADMINISTRADOR")
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				// Se accede a la pagina de login mediante botón
				.loginPage("/login")
				.defaultSuccessUrl("/", true)
				.successHandler(successHandler)
				.permitAll()
				.and()
				.logout()
				.permitAll()
				.and()
				.exceptionHandling()
				.accessDeniedPage("/error_403");
		http.csrf().disable();
	}

	// Acceso sistema
	@Autowired
	public void configureGobal(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder)
				.usersByUsernameQuery("SELECT usuario, pass, 'true' as enabled FROM usuario u Where u.usuario=?")
				.authoritiesByUsernameQuery("SELECT u.usuario, u.rol FROM usuario u Where u.usuario=?");


	}

}
