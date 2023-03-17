package com.axis.service;

import com.axis.model.Coffee;

public interface CoffeeService {
	Coffee addCoffee(Coffee coffee);
	Coffee getCoffeeByName(String coffeeName);
	void orderCoffee(String coffeeName, int sugar, int milk, int bean, int water);
}
