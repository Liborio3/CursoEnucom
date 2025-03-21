package com.mx.Tienda.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	/*
	 * @Bean
	 * 
	 * Que es @Bean: es una anotacion que se utiliza en clases de configuracion
	 * (@Configuration) para indicar que un metodo produce un "Bean" que sera
	 * administrado por el Contenedor de Instancias de Spring.
	 * 
	 * 
	 * Que es un "Bean": en Spring es un objeto que forma parte del contexto de la
	 * aplicacion y ademas es administrado por el contenedor de instancias de
	 * Spring.
	 * 
	 * Estos objetos pueden ser invocadoes en otras partes del codigo mediante la
	 * inyeccion de dependencias
	 * 
	 * En resumen: un bean es una unica instancia que se encuentra almacenadoa en el
	 * "Contenedor de instancias" de Spring Framework. Esto para garantizar que solo
	 * exista una sola instancia de ese objeto.
	 * 
	 */

	// Ejemplo de un BEAN
	
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}

/*
 * control shif + o para eliminar paquetes que no utilizo
 */
