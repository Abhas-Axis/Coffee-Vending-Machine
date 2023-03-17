package com.axis.Service;



import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axis.Exception.IdNotFoundException;
import com.axis.model.Inventory;
import com.axis.model.Repository.InventoryRepository;


@Service
public class InventoryServiceImpl implements InventoryService {
	
	@Autowired
	InventoryRepository inventoryRepository;
	
	

	@Override
	public Inventory createInventory(Inventory inventory) {
		// TODO Auto-generated method stub
		return inventoryRepository.save(inventory);
	}

	@Override
	public Inventory updateInventoryById(ObjectId _id, Inventory inventory) {
		
		Optional<Inventory> inv = inventoryRepository.findById(_id);

		if(inv.isPresent()) {
			inventory.setId(inv.get().getId());
			return inventoryRepository.save(inventory);			
		}
			
		else
			throw new IdNotFoundException("no id present to Update");
		
	}

	@Override
	public Inventory getInventoryById(ObjectId _id) {
		// TODO Auto-generated method stub
       Optional<Inventory> inv = inventoryRepository.findById(_id);
		
		if(inv.isPresent()) {
			return inv.get();
		}
		else {
			throw new IdNotFoundException("Invalid");
		}
		
	}



		}
		
		
	
		
		// TODO Auto-generated method stub
			