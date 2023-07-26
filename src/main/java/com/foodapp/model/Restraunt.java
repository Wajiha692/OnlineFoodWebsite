package com.foodapp.model;

public class Restraunt {
	private String name;
	private Menu menu;
	private Float rating;

	public Restraunt() {
		super();
	}

	public Restraunt(String name, Menu menu, Float rating) {
		this.name = name;
		this.menu = menu;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

}
