package com.foodapp.model2;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	private List<FoodItem> veg;
	private List<FoodItem> nonveg;
	private List<FoodItem> bread;
	private List<FoodItem> beverage;

	public Menu() {
		veg = new ArrayList<>();
		nonveg = new ArrayList<>();
		bread = new ArrayList<>();
		beverage = new ArrayList<>();
	}
	
	public List<FoodItem> getVeg() {
		return veg;
	}

	public void setVeg(List<FoodItem> veg) {
		this.veg = veg;
	}

	public List<FoodItem> getNonveg() {
		return nonveg;
	}

	public void setNonveg(List<FoodItem> nonveg) {
		this.nonveg = nonveg;
	}

	public List<FoodItem> getBread() {
		return bread;
	}

	public void setBread(List<FoodItem> bread) {
		this.bread = bread;
	}

	public List<FoodItem> getBeverage() {
		return beverage;
	}

	public void setBeverage(List<FoodItem> beverage) {
		this.beverage = beverage;
	}

}
