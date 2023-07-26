package com.foodapp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.foodapp.dao.util.DBManager;
import com.foodapp.model.Restraunt;
import com.foodapp.model2.FoodItem;
import com.foodapp.model2.Menu;

public class RestrauntDao {

	List<Restraunt> res = new ArrayList<Restraunt>();

	public RestrauntDao() {
		initRestraunts();
	}

	private void initRestraunts() {

	}

	public Restraunt getRestrauntByName(String name) {
		Restraunt rest = null;
		for (Restraunt r : res) {
			if (r.getName().equalsIgnoreCase(name)) {
				rest = r;
				break;
			}
		}
		return rest;
	}

	public List<Restraunt> getRes() {
		return res;
	}

	public void setRes(List<Restraunt> res) {
		this.res = res;
	}

	public void addRestraunts(Restraunt res) {
		this.res.add(res);
	}

	public void performUpdate(String changes, String restaurantId) {
		if(changes == null || changes.trim().isBlank() || restaurantId == null || restaurantId.trim().isBlank()) {
			// nothing to update
			return;
		}
		List<FoodItem> itemsToBeUpdated = getItemsFromString(changes);
		DBManager.updateMenuForRestaurant(itemsToBeUpdated, restaurantId);
		
		
	}

	/**
	 * This method parse the string and convert it to list of FoodItem with name and
	 * updated price. This will be send to DB for updating the price of menu items
	 * 
	 * @param changes
	 * @return
	 */
	private List<FoodItem> getItemsFromString(String changes) {
		List<FoodItem> items = new ArrayList<>();
		String[] split = changes.split(",");
		for(String str : split) {
			String[] id_price = str.split("#");
			FoodItem item = new FoodItem();
			item.setId(Integer.parseInt(id_price[0]));
			item.setPrice(Float.parseFloat(id_price[1]));
			items.add(item);
		}
		return items;
	}

	public void performDeleteMenu(String changes, String restaurantId) {
		if(changes == null || changes.trim().isBlank() || restaurantId == null || restaurantId.trim().isBlank()) {
			// nothing to delete
			return;
		}
		// Split the comma separated id's and get list of id of food item, it will be
		// then deleted from menu table for the give restaurant
		List<Integer> toBeDeletedFoodItems = Stream.of(changes.trim().split(",")).map(x -> Integer.parseInt(x))
				.collect(Collectors.toList());
		// DB helper method to delete items from the menu of restaurant
		DBManager.deleteMenuForRestaurant(toBeDeletedFoodItems, restaurantId);
	}

	public void performAddMenuItems(String changes, String restaurantId) {
		if(changes == null || changes.trim().isBlank() || restaurantId == null || restaurantId.trim().isBlank()) {
			// nothing to add
			return;
		}
		Menu menu = new Menu();
		// Parsing the string coming from front-end, into menu object
		Stream.of(changes.split("##")).forEach(str -> {
			// str is in the format => food_name$food_price$food_category
			String[] data = str.split("\\$");
			if(data.length != 3) {
				return;
			}
			if(data[2].equalsIgnoreCase("veg")) {
				menu.getVeg().add(new FoodItem(data[0], Float.parseFloat(data[1])));
			} else if (data[2].equalsIgnoreCase("non-veg")) {
				menu.getNonveg().add(new FoodItem(data[0], Float.parseFloat(data[1])));
			} else if (data[2].equalsIgnoreCase("bread")) {
				menu.getBread().add(new FoodItem(data[0], Float.parseFloat(data[1])));
			} else if (data[2].equalsIgnoreCase("beverage")) {
				menu.getBeverage().add(new FoodItem(data[0], Float.parseFloat(data[1])));
			}
		});
		// DB helper method to add items to restaurant
		DBManager.addMenuItemsForRestaurant(menu, restaurantId);
	}

}
