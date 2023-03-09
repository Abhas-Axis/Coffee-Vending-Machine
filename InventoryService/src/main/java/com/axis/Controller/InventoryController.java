package com.axis.Controller;



import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.Service.InventoryService;
import com.axis.model.Inventory;

@RestController
@RequestMapping("/inv")
public class InventoryController {
	
	@Autowired
	private InventoryService inventoryService;
	
	@PostMapping("/create")
	ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory){
		return new ResponseEntity<Inventory>(inventoryService.createInventory(inventory),HttpStatus.OK);
	}
	
	@PutMapping("/update/{_id}")
	public ResponseEntity<Inventory> updateInventoryById(@PathVariable() ObjectId _id, @RequestBody Inventory inventory)
	{
		return new ResponseEntity<Inventory>(inventoryService.updateInventoryById(_id,inventory),HttpStatus.CREATED);
		
	}

}
