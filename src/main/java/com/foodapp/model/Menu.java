package com.foodapp.model;

import java.util.List;

public class Menu {
	private List<Item> veg;
	private List<Item> nonveg;
	private List<Item> bread;
	private List<Item> beverage;

	public Menu() {
		super();

	}

	public Menu(List<Item> veg, List<Item> nonveg, List<Item> bread, List<Item> bevrages) {
		super();
		this.veg = veg;
		this.nonveg = nonveg;
		this.bread = bread;
		this.beverage = bevrages;
	}

	public List<Item> getVeg() {
		return veg;
	}

	public void setVeg(List<Item> veg) {
		this.veg = veg;
	}

	public List<Item> getNonveg() {
		return nonveg;
	}

	public void setNonveg(List<Item> nonveg) {
		this.nonveg = nonveg;
	}

	public List<Item> getBread() {
		return bread;
	}

	public void setBread(List<Item> bread) {
		this.bread = bread;
	}

	public List<Item> getBeverage() {
		return beverage;
	}

	public void setBeverage(List<Item> bevrages) {
		this.beverage = bevrages;
	}

}
