package com.axis.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.axis.Exception.InsufficientResourceException;
import com.axis.model.Coffee;
import com.axis.model.Inventory;

import com.axis.repository.CoffeeRepository;


@Service
public class CoffeeServiceImpl implements CoffeeService {
	
	
	
	@Autowired
	CoffeeRepository coffeeRepository;
	
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String INVENTORY_MICROSERVICE_URL = "http://localhost:8225/api/v1/inventory/findbyid/64129f4a41499712a6e8e9cb";
	private String INVENTORY_UPDATE_URL = "http://localhost:8225/api/v1/inventory/update/64129f4a41499712a6e8e9cb";
	

	@Override
	public Coffee addCoffee(Coffee coffee) {
		// TODO Auto-generated method stub
		return coffeeRepository.save(coffee);
	}

	@Override
	public void orderCoffee(String coffeeName, int sugar, int milk, int beans, int water) throws InsufficientResourceException {
		
		// TODO Auto-generated method stub
		boolean enoughResources= checkInventory(coffeeName, sugar,milk,beans, water);
		
		if(enoughResources) {
			//processPayment();
			updateInventoryOrdered(coffeeName,sugar, milk, beans, water);
			}
		else {
			throw new InsufficientResourceException("Insufficient Resources. Kindly Contact staff. Inconvenience cause is deeply regretted.");
		}		
	}
	private boolean checkInventory(String coffeeName, int sugar,int milk, int beans, int water) {
		String inventoryurl= INVENTORY_MICROSERVICE_URL;
		
		Inventory inventory = restTemplate.getForObject(inventoryurl, Inventory.class);
		if(inventory != null && inventory.getTotalSugar() >=sugar && inventory.getTotalMilk() >=milk && inventory.getTotalBeans() >= beans && inventory.getTotalWater() >= water  ) {
			return true;
			}
		else {
			return false;
		}
	}
	//private boolean processPayment() {
		//	return false;
	//	}
	private void updateInventoryOrdered(String coffeeName,int milk, int beans, int water, int sugar) {
		String inventoryurl= INVENTORY_MICROSERVICE_URL;
		String inventoryupdateurl =INVENTORY_UPDATE_URL;
		Inventory inventory = restTemplate.getForObject(inventoryurl, Inventory.class);
		
		int newTotalSugar = inventory.getTotalSugar()-sugar;
		inventory.setTotalSugar(newTotalSugar);
		
		int newTotalWater = inventory.getTotalWater()-water;
		inventory.setTotalWater(newTotalWater);
		
		int newTotalBean = inventory.getTotalBeans()-beans;
		inventory.setTotalBeans(newTotalBean);
		
		int newTotalMilk = inventory.getTotalMilk()-milk;
		inventory.setTotalMilk(newTotalMilk);
		restTemplate.put(inventoryupdateurl,inventory,void.class);
	}
	

	@Override
	public Coffee getCoffeeByName(String coffeeName) {
		// TODO Auto-generated method stub
		return coffeeRepository.getCoffeeByCoffeeName(coffeeName);
	}

	

	}

