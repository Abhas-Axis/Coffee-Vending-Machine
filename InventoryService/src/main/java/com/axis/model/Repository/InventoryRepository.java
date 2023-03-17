package com.axis.model.Repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.axis.model.Inventory;

public interface InventoryRepository extends MongoRepository<Inventory, ObjectId> {

}
