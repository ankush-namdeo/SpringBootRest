package com.spring.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRestController {

	enum accounttype {
		personal, business
	}

	enum sizeType {
		small, big
	}

	
	@GetMapping("/greeting")
	public ResponseEntity<Object> greeting(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "account") accounttype account,
			@RequestParam(value = "type", required = false) sizeType size) {

		if (null != id && account.equals(accounttype.business)) {

			return new ResponseEntity<Object>("Hi, userId " + id, HttpStatus.OK);
		} else if (account.equals(accounttype.business) && size.equals(sizeType.big)) {
			return new ResponseEntity<Object>("Welcome, business user!", HttpStatus.OK);
		} else if (account.equals(accounttype.business) && size.equals(sizeType.small)) {
			return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
		}

		return new ResponseEntity<Object>(HttpStatus.NOT_IMPLEMENTED);
	}
}
