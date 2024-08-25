package com.nit.ms;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search-api")
public class SearchServiceOperationsController {
	
	@GetMapping("/welcome")
	public ResponseEntity<String> showHomePage() {
		return new ResponseEntity<String>("Welcome to Search Service MS", HttpStatus.OK);
	}

}
