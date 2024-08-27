package com.nit.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.clientcomp.IBillingServiceClientComp;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/shopping-api")
@Slf4j
public class ShoppingServiceController {
	
	@Autowired
	private IBillingServiceClientComp client;
	
	@GetMapping("/purchase")
	public ResponseEntity<String> shopping() {
		log.debug("start of shopping method()");
		System.out.println("Client comp class obj::" + client.getClass());
		
		// invoke provide MS
		String resultMsg = client.invokeDoPayment();
		
		log.info("Target MS is invoked");
		// return final output
		String finalMsg = "Shopping of shirt, trouser is done......" + resultMsg;
		log.debug("final message is generated");
		return new ResponseEntity<String>("<br>"+finalMsg, HttpStatus.OK);
	}
	
	@GetMapping("/purchase/{cardNo}")
	public ResponseEntity<String> shopping(@PathVariable("cardNo") long cardNo) {
		log.debug("start of shopping method() with card number");
		System.out.println("Client comp class obj::" + client.getClass());
		
		// invoke provide MS
		String resultMsg = client.invokeDoPayment();
		
		log.info("Target MS is invoked");
		// return final output
		String finalMsg = "Shopping of shirt, trouser is done......" + resultMsg;
		log.debug("final message is generated");
		return new ResponseEntity<String>("<br>"+finalMsg, HttpStatus.OK);
	}

}
