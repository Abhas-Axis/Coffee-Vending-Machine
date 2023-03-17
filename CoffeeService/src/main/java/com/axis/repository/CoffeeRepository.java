package com.axis.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.axis.model.Coffee;

public interface CoffeeRepository extends MongoRepository<Coffee,String>{
	
	
	@Query("{'coffeeName' : ?0}")
	Coffee getCoffeeByCoffeeName(String coffeeName);

}
