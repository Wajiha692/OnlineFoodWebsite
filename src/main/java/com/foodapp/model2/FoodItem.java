package com.foodapp.model2;

public class FoodItem {
	private int id;
	private String name;
	private float price;
	private int quantity;

	public FoodItem() {
	}

	public FoodItem(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	public FoodItem(String name, float price, int quantity) {
		this(name, price);
		this.quantity = quantity;
	}

	public FoodItem(int id, String name, float price, int quantity) {
		this(name, price, quantity);
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQty() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
