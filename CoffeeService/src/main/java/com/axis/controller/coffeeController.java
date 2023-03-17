package com.axis.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.axis.Exception.InsufficientResourceException;
import com.axis.model.Coffee;
import com.axis.repository.CoffeeRepository;
import com.axis.service.CoffeeService;

@RestController
@RequestMapping("/api/v1/coffee")
@CrossOrigin
public class coffeeController {
	
	@Autowired
	private CoffeeService coffeeService;
	
	@Autowired
	private CoffeeRepository coffeeRepository;
	
	@PostMapping("/add")
	public ResponseEntity<Coffee> addCoffee(@RequestBody Coffee coffee){
		return new ResponseEntity<Coffee>(coffeeService.addCoffee(coffee),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/get/{coffeeName}")
	public ResponseEntity<Coffee>getCoffeeByName(@PathVariable String coffeeName){
		return new ResponseEntity<Coffee>(coffeeService.getCoffeeByName(coffeeName),HttpStatus.FOUND);	
	}
	
	@PostMapping("/order/{coffeeName}")
	public ResponseEntity<?> orderCoffee(@PathVariable String coffeeName){
		try {
			Coffee coffee = coffeeRepository.getCoffeeByCoffeeName(coffeeName);
			coffeeService.orderCoffee(coffee.getCoffeeName(),coffee.getSugar(),coffee.getMilk(),coffee.getBeans(),coffee.getWater());
			return new ResponseEntity<String>("Coffee ordered successfully",HttpStatus.OK);
		}
		catch (InsufficientResourceException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
	}
}
	
	
