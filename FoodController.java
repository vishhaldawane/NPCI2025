package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

@RestController
public interface FoodController {

	List<Object> acceptOrderForJuiceAndDosa(String j, String d);
	
}
