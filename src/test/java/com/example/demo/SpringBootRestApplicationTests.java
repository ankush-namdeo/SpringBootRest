package com.example.demo;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.spring.rest.GreetingRestController;
import com.spring.rest.Response;
import com.spring.rest.SpringBootRestApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { GreetingRestController.class,
		SpringBootRestApplication.class }, webEnvironment = WebEnvironment.RANDOM_PORT)

public class SpringBootRestApplicationTests {
	@LocalServerPort
	int randomPort;

	@Test
	public void testGreetingsWithIDandAccount() throws URISyntaxException {
		RestTemplate r = new RestTemplate();
		Integer id = 123;
		String account = "business";
		String type = "small";
		final String baseUrl = "http://localhost:" + randomPort + "/greeting?id=" + id + "&account=" + account
				+ "&type=" + type;
		URI uri = new URI(baseUrl);
		ResponseEntity<Response> result = r.getForEntity(uri, Response.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals("Hi, userId " + id, result.getBody().getMessage());
	}

	@Test
	public void testGreetingsWithAccountandTypePositive() throws URISyntaxException {
		RestTemplate r = new RestTemplate();
		String account = "business";
		String type = "big";
		final String baseUrl = "http://localhost:" + randomPort + "/greeting?&account=" + account + "&type=" + type;
		URI uri = new URI(baseUrl);
		ResponseEntity<Response> result = r.getForEntity(uri, Response.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals("Welcome, business user!", result.getBody().getMessage());
	}

	@Test
	public void testGreetingsWithAccountandTypeSmall() throws URISyntaxException {
		RestTemplate r = new RestTemplate();
		String account = "business";
		String type = "small";
		final String baseUrl = "http://localhost:" + randomPort + "/greeting?&account=" + account + "&type=" + type;
		URI uri = new URI(baseUrl);
		ResponseEntity<Response> result = r.getForEntity(uri, Response.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals("path not set", result.getBody().getError());

	}
	
	@Test
	public void testGreetingsPersonalAccount() throws URISyntaxException {
		RestTemplate r = new RestTemplate();
		String account = "personal";
		String type = "small";
		final String baseUrl = "http://localhost:" + randomPort + "/greeting?&account=" + account + "&type=" + type;
		URI uri = new URI(baseUrl);
		ResponseEntity<Response> result = r.getForEntity(uri, Response.class);
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertEquals("path not set", result.getBody().getError());

	}
	
	
}
