package com.nit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BootMsProj09BillingService_ELKStackApplication {

	public static void main(String[] args) {
		log.debug("start of main(-) method");
		SpringApplication.run(BootMsProj09BillingService_ELKStackApplication.class, args);
		log.debug("end of main(-) method");
	}

}
