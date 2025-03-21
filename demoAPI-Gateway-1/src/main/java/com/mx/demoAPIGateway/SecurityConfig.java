package com.mx.demoAPIGateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//Metodo con usuario y contraseña configurados en Meoria
	@Bean
	UserDetailsService userDetailService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(
				User.builder()
					.username("user")
					.password("1234")
					.roles("USER")
					.build()
				);
		return manager;
	}

	
	
	
	//Metodo para agregar seguridad basica para todas las peticiones "BasicAuth"
	
/*	HttpBasicConfigurer<HttpSecurity> httpBasicConfigurer(HttpSecurity http) throws Exception{
		return http.csrf(csrf -> csrf.disable())
					.authorizeHttpRequests()
					.anyRequest().authenticated()
					.and()
					.formLogin()
					.and()
					.httpBasic();
		
	}*/
	
	//Metodo para trabajar con los filtros de SpringSecurity "SecurityFilterChain"
/*	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf ->csrf.disable()).authorizeHttpRequests(
				//URLs permitidos
				authorize -> authorize
				.requestMatchers(HttpMethod.GET,"Tienda/Clientes/**").authenticated()
				.requestMatchers("/Tienda/Productos/**").authenticated()
				.anyRequest().denyAll()
				).formLogin().and().httpBasic();
		return http.build();
	}
	*/
}
