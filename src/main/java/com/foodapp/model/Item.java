package com.foodapp.model;

public class Item {
	private String name;
	private Float price;
	private int qty;

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Item() {
		super();
	}

	public Item(String name, Float price) {
		this(name, price, 0);
	}
	
	public Item(String name, float price, int qty) {
		this.name = name;
		this.price = price;
		this.qty = qty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
