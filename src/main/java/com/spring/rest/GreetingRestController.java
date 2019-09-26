package com.spring.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/greeting")
	@GetMapping
	public Response greeting(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "account") accounttype account,
			@RequestParam(value = "type", required = false) sizeType size) {
		Response response = new Response();
		if (null != id && account.equals(accounttype.business)) {
			response.setMessage("Hi, userId " + id);
			return response;
		} else if (account.equals(accounttype.business) && size.equals(sizeType.small)) {
			response.setError("path not set");
			return response;
		} else if (account.equals(accounttype.business) && size.equals(sizeType.big)) {
			response.setMessage("Welcome, business user!");
			return response;
		} else {
			response.setError("path not set");
			return response;
		}
	}
}
