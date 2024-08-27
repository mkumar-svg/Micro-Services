package com.nit.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/billing-api")
@Slf4j
public class BillingServiceController {
	
	@Value("${server.port}")
	private int port;
	
	@Value("${eureka.instance.instance-id}")
	private String instance_id;
	
	@GetMapping("/payment")
	public ResponseEntity<String> doPayment() {
		log.debug("from doPayment() method");
		int amount = new Random().nextInt(1000000);
		log.debug("amount generated in doPayment() method");
		return new ResponseEntity<String>("Bill amount is:: "+ amount +" Payment can be using Cards, upi payment" + instance_id + "....." + port, HttpStatus.OK);
	}
	
	@GetMapping("/payment/{cardNo}")
	public ResponseEntity<String> doPayment1(@PathVariable("cardNo") long cardNo) {
		log.debug("from doPayment1() method");
		int amount = new Random().nextInt(1000000);
		log.debug("amount generated in doPayment1() method");
		return new ResponseEntity<String>("Bill amount is:: "+ amount +" Payment can be using Cards no:"+cardNo+ " with " + instance_id + "....." + port, HttpStatus.OK);
	}

}
