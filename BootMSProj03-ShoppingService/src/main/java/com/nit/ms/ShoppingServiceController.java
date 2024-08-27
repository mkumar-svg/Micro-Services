package com.nit.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nit.clientcomp.BillingServiceClientComp;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingServiceController {
	
	@Autowired
	private BillingServiceClientComp client;
	
	@GetMapping("/purchase")
	public ResponseEntity<String> shopping() {
		
		// invoke provide MS
		String resultMsg = client.invokeDoPayment();
		
		// return final output
		String finalMsg = "Shopping of shirt, trouser is done......" + resultMsg;
		
		return new ResponseEntity<String>(finalMsg, HttpStatus.OK);
	}

}
