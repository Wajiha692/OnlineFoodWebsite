package com.foodapp.model2;

// Using Inheritance, because Owner have only one field extra
public class Owner extends User {
	private Restaurant restaurant;

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Owner() {
		super();
	}

	public Owner(int userId, String userName, String password, String firstName, String lastName, String email,
			String address) {
		super(userId, userName, password, firstName, lastName, email, address);
	}

	public Owner(String userName, String password, String firstName, String lastName, String email, String address) {
		super(userName, password, firstName, lastName, email, address);
	}
	
	public void setRestaurantId(int id) {
		if(restaurant == null) {
			restaurant = new Restaurant();
		}
		restaurant.setId(id);
	}

}
