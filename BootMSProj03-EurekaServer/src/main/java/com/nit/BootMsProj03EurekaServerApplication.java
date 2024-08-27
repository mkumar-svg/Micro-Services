package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj03EurekaServerApplication {
	// using Discovery Client component
	public static void main(String[] args) {
		SpringApplication.run(BootMsProj03EurekaServerApplication.class, args);
	}

}
