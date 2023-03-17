package com.axis.model;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Inventory")
public class Inventory {
	@Id
	private ObjectId _id;
	private int totalMilk;
	private int totalWater;
	private int totalSugar;
	private int totalBeans;
	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId _id) {
		this._id = _id;
	}
	public int getTotalMilk() {
		return totalMilk;
	}
	public void setTotalMilk(int totalMilk) {
		this.totalMilk = totalMilk;
	}
	public int getTotalWater() {
		return totalWater;
	}
	public void setTotalWater(int totalWater) {
		this.totalWater = totalWater;
	}
	public int getTotalSugar() {
		return totalSugar;
	}
	public void setTotalSugar(int totalSugar) {
		this.totalSugar = totalSugar;
	}
	public int getTotalBeans() {
		return totalBeans;
	}
	public void setTotalBeans(int totalBeans) {
		this.totalBeans = totalBeans;
	}
	
	
	
}
