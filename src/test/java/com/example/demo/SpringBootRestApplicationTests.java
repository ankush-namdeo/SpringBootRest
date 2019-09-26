package com.example.demo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.spring.rest.GreetingRestController;

@RunWith(SpringRunner.class)
public class SpringBootRestApplicationTests {
	
	private MockMvc mockMvc;
	
	@InjectMocks
	private GreetingRestController greetingRestController;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(greetingRestController).build();

	}
	
	@Test
	public void testGreetingForId() throws Exception {
		
		mockMvc.perform(get("/greeting?id=123&account=business"))
		.andExpect(status().isOk()).andExpect(content().string("Hi, userId 123"));
		
	}
	
	@Test
	public void testGreetingForAccountAndSize() throws Exception {
		
		mockMvc.perform(get("/greeting?account=business&type=big"))
		.andExpect(status().isOk()).andExpect(content().string("Welcome, business user!"));
		
	}
	
	@Test
	public void testGreetingForAccountAndSizeError() throws Exception {
		
		mockMvc.perform(get("/greeting?account=business&type=small"))
		.andExpect(status().isNotImplemented());
		
	}
	
	@Test
	public void testGreetingForAccountAndSizeErrorInRequest() throws Exception {
		
		mockMvc.perform(post("/greeting?account=business&type=small"))
		.andExpect(status().isNotImplemented());
		
	}
	
	@Test
	public void testGreetingForNoAccountAndSize() throws Exception {
		
		mockMvc.perform(post("/greeting?account=personal&type=small"))
		.andExpect(status().isNotImplemented());
		
	}
	@Test
	public void testGreetingForFaultyRequest() throws Exception {
		
		mockMvc.perform(post("/greeting?account=persal&type=small"))
		.andExpect(status().isBadRequest());
		
	}
	
	
	
	
}
