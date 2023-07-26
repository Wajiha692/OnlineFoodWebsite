package com.foodapp.model2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {

	private int id;
	private String name;
	private float rating;
	private String address;
	private Map<String, List<FoodItem>> menu = new HashMap<>();

	public Restaurant(int id, String name, float rating, String address) {
		this(name, address);
		this.id = id;
		this.rating = rating;
	}

	public Restaurant(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public Restaurant() {
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

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void addItem(String category, FoodItem item) {
		if (!menu.containsKey(category)) {
			menu.put(category, new ArrayList<>());
		}
		menu.get(category).add(item);
	}

	public Menu getMenu() {
		Menu menu = new Menu();
		menu.setVeg(this.menu.get("VEG"));
		menu.setNonveg(this.menu.get("NON-VEG"));
		menu.setBread(this.menu.get("BREAD"));
		menu.setBeverage(this.menu.get("BEVERAGE"));
		return menu;
	}

}
