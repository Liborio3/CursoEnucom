package com.mx.Provedores;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProvedoresApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsProvedoresApplication.class, args);
	}

}
