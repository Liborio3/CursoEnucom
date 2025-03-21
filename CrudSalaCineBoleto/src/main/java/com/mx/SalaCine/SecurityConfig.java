package com.mx.SalaCine;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {
	
/*	@Bean
	UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		
		manager.createUser(
				
				User.withDefaultPasswordEncoder()
					.username("francis")
					.password("1234")
					.roles("USER")
					.build()
				);
		return manager;
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		 http.csrf(csrf ->csrf.disable()).authorizeHttpRequests(
				 authorize ->authorize
				 .requestMatchers(HttpMethod.GET,"/Sala/**").authenticated()
				 .requestMatchers(HttpMethod.GET,"Boleto/**").authenticated()
				 .requestMatchers(HttpMethod.POST,"Boleto/**").authenticated()
				 .anyRequest().denyAll()
				 
				 ).formLogin().and().httpBasic();
		 return http.build();
	}*/

}
