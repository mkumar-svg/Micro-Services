package com.nit.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.clientcomp.IBillingServiceClientComp;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceController {
	
	@Autowired
	private IBillingServiceClientComp client;
	
	@GetMapping("/purchase")
	@CircuitBreaker(name="Shopping-Service", fallbackMethod = "billingFallback")
	public ResponseEntity<String> shopping() {
		System.out.println("Client comp class obj::" + client.getClass());
		
		// invoke provide MS
		String resultMsg = client.invokeDoPayment();
		
		// return final output
		String finalMsg = "Shopping of shirt, trouser is done......" + resultMsg;
		return new ResponseEntity<String>("<br>"+finalMsg, HttpStatus.OK);
	}
	
	public ResponseEntity<String> billingFallback(Exception e) {
		System.out.println("ShoppingServiceController.billingFallback()");
		return new ResponseEntity<String>("Billing operations are out of service::", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/purchase/{cardNo}")
	public ResponseEntity<String> shopping(@PathVariable("cardNo") long cardNo) {
		System.out.println("Client comp class obj::" + client.getClass());
		
		// invoke provide MS
		String resultMsg = client.invokeDoPayment();
		// return final output
		String finalMsg = "Shopping of shirt, trouser is done......" + resultMsg;
		return new ResponseEntity<String>("<br>"+finalMsg, HttpStatus.OK);
	}

}
