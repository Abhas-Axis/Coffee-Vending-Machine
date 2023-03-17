package com.axis.Service;



import org.bson.types.ObjectId;

import com.axis.model.Inventory;

public interface InventoryService {
	
	
	Inventory getInventoryById(ObjectId _id);
	Inventory createInventory(Inventory inventory);
	Inventory updateInventoryById(ObjectId _id,Inventory inventory);
	
	
	
	
	
}
