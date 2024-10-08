package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj03BillingServiceApplication {
	// using Discovery Client component
	public static void main(String[] args) {
		SpringApplication.run(BootMsProj03BillingServiceApplication.class, args);
	}

}
