package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.FoodService;

@RestController
@RequestMapping("/foodie")
public class FoodControllerImpl implements FoodController {
	@Autowired  FoodService foodService;	
	//  http://localhost:8080/foosie/order1/Apple/Masala
	@Override
	@GetMapping("/order1/{jt}/{dt}")
	public List<Object> acceptOrderForJuiceAndDosa(
			@PathVariable("jt") String j, 
			@PathVariable("dt") String d) {
		List<Object> list = foodService.serveJuiceAndDosa(j, d);	
		return list;
	}

}
