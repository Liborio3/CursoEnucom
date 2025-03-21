package com.mx.APIGateway2.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//METODO CON USUARIO Y CONTRASEÑA CONFIGURADOS EN MEMORIA
	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(
				
				User.builder().username("diego").password("987654").roles("USER").build()
				
				);
		
		return manager;
	}
	
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(); // Para producción
//        // return NoOpPasswordEncoder.getInstance(); // Solo para pruebas (sin cifrado)
//    }
	
	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf ->csrf.disable()).authorizeHttpRequests(
				//URLs permitidos
				authorize -> authorize
				.requestMatchers(HttpMethod.GET,"Boleto/listar**").authenticated()
				.requestMatchers("/Sala/listar**").authenticated()
				.anyRequest().denyAll()
				).formLogin().and().httpBasic();
		return http.build();
	}
}
