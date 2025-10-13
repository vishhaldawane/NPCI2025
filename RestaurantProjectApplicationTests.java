package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Dosa;
import com.example.demo.entities.Juice;
import com.example.demo.entities.Tea;
import com.example.demo.repositories.DosaRepository;
import com.example.demo.repositories.JuiceRepository;
import com.example.demo.repositories.TeaRepository;
import com.example.demo.services.FoodService;

@SpringBootTest
class RestaurantProjectApplicationTests {

	@Autowired
	JuiceRepository juiceRepo;

	@Autowired
	DosaRepository dosaRepo;

	@Autowired
	TeaRepository teaRepo;

	@Test
	void addInventory() {
		Juice juice1 = new Juice(101,"Apple",150);
		Juice juice2 = new Juice(102,"PineApple",50);
		Juice juice3 = new Juice(103,"Grapes",30);
		
		juiceRepo.save(juice1);
		juiceRepo.save(juice2);
		juiceRepo.save(juice3);
		
		
		Dosa dosa1 = new Dosa(301,"Plain",50);
		Dosa dosa2 = new Dosa(302,"Masala",150);
		Dosa dosa3 = new Dosa(303,"Cheese Masala",230);
		
		dosaRepo.save(dosa1);
		dosaRepo.save(dosa2);
		dosaRepo.save(dosa3);
		
		Tea tea1 = new Tea(501,"Black Tea",50);
		Tea tea2 = new Tea(502,"Green Tea",150);
		Tea tea3 = new Tea(503,"Normal Tea",230);
		
		teaRepo.save(tea1);
		teaRepo.save(tea2);
		teaRepo.save(tea3);
		
		
		
	}

	
	@Autowired
	FoodService foodService;
	
	@Test
	public void serveBothJuiceAndDosaTest() {
		
		List<Object> list= foodService.serveJuiceAndDosa("PineApple", "Cheese Masala");
		for (Object object : list) {
			if(object instanceof Dosa) {
				Dosa dosa = (Dosa) object;
				System.out.println("Dosa : "+dosa);
			}
			else if(object instanceof Juice) {
				Juice j1 = (Juice) object;
				System.out.println("Juice : "+j1);
			}
			else if(object instanceof Tea) {
				Tea t1 = (Tea) object;
				System.out.println("Juice : "+t1);
			}
		}
	}
}

