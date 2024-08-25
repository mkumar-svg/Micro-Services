package com.nit.ms;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/employee-api")
@Slf4j
public class EmployeeOperationsController {
	
	@GetMapping("/wish")
	public ResponseEntity<String> showWishMessage() {
		log.debug("from the beginning of the showWishMessage()");
		return new ResponseEntity<String>("Good Morning", HttpStatus.OK);
	}
	
	@Scheduled(cron="10 * * * * *")
	public void showReport() {
		System.out.println("Report on::" + new Date());
	}

}
