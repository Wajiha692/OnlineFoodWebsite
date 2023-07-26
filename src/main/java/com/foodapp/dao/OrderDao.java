package com.foodapp.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.foodapp.dao.util.DBManager;
import com.foodapp.model2.FoodItem;
import com.foodapp.model2.Menu;
import com.foodapp.model2.Order;
import com.foodapp.model2.Owner;
import com.foodapp.model2.Restaurant;
import com.foodapp.model2.User;

public class OrderDao {

	public static Order createOrder(User user, Map<String, String[]> parameterMap, String resname) {
		Restaurant res = DBManager.getRestaurantByName(resname);

		// Create new order, this is in memory, once order is placed and user checkout,
		// remove it from this list and add to db
		Order order = new Order();
		order.setResName(resname);
		order.setRestaurantId(res.getId());
		order.setUser(user.getUserName());
		order.setUserId(user.getUserId());

		Menu orderMenu = new Menu();

		orderMenu.setVeg(calculateMenu(res.getMenu().getVeg(), parameterMap.get("veg_item_qty")));
		orderMenu.setNonveg(calculateMenu(res.getMenu().getNonveg(), parameterMap.get("non_veg_item_qty")));
		orderMenu.setBread(calculateMenu(res.getMenu().getBread(), parameterMap.get("bread_item_qty")));
		orderMenu.setBeverage(calculateMenu(res.getMenu().getBeverage(), parameterMap.get("beverages_item_qty")));

		order.setOrderItems(orderMenu);

		order.setTotalPrice(calculatePrice(orderMenu));

		return order;

	}

	// Method overloading
	private static Float calculatePrice(Menu orderMenu) {
		float totalPrice = calculatePrice(orderMenu.getVeg());
		totalPrice += calculatePrice(orderMenu.getNonveg());
		totalPrice += calculatePrice(orderMenu.getBread());
		totalPrice += calculatePrice(orderMenu.getBeverage());

		return totalPrice;
	}

	// Method overloading
	private static float calculatePrice(List<FoodItem> items) {
		float p = 0.0F;
		for (FoodItem i : items) {
			p += i.getPrice();
		}
		return p;
	}

	// List<Item> veg => [('dal fry', 56), ('chana dal', 67) ... )
	// ["1", ""]
	private static List<FoodItem> calculateMenu(List<FoodItem> veg, String[] qty) {
		List<FoodItem> items = new ArrayList<>();
		if (qty == null || qty.length == 0) {
			return new ArrayList<>();
		}

		for (int i = 0; i < qty.length; i++) {
			if (qty[i] == null || qty[i].trim().isBlank()) {
				continue;
			}
			int item_qty = Integer.parseInt(qty[i]);
			String name = veg.get(i).getName();
			float price = veg.get(i).getPrice();

			items.add(new FoodItem(name, (price * item_qty), item_qty));
		}

		return items;

	}

//	public static List<Order> getOrderByUser(String username) {
//		List<Order> userOrders = new ArrayList<>();
//		for (Order order : orders) {
//			if (order.getUser().equalsIgnoreCase(username)) {
//				userOrders.add(order);
//			}
//		}
//		return userOrders;
//	}

	public void addOrderDetails(Map<String, String[]> parameterMap) {
		// TODO Auto-generated method stub

	}

//	public static Order getLastOrderofUser(String userName) {
//		List<Order> ordersOfUser = getOrderByUser(userName);
//		if (!ordersOfUser.isEmpty()) {
//			return ordersOfUser.get(ordersOfUser.size() - 1);
//		}
//		return null;
//	}

//	public static void removePendingOrdersOfUser(User user) {
//		if (user == null) {
//			return;
//		}
//		Iterator<Order> orderItr = orders.iterator();
//		while (orderItr.hasNext()) {
//			Order order = orderItr.next();
//			if (order.getUser().equalsIgnoreCase(user.getUserName()) && order.getUserId() == user.getUserId()) {
//				orderItr.remove();
//			}
//		}
//	}

	public static int placeOrder(Order order) {
		if (order != null) {
			// Insert order to DB
			return DBManager.addOrder(order);
		}
		return -1;
	}

	public static List<Order> getAllOrdersAnyUser(Object user) {
		if (user instanceof Owner) {
			return DBManager.getAllOrderForAdmin(((Owner) user).getUserName());
		} else if (user instanceof User) {
			return DBManager.getAllOrderOfUser(((User) user).getUserName());
		}
		return null;
	}


//	public static List<Order> getAllOrdersOfUser(String userName) {
//		if (userName != null && !userName.isBlank()) {
//			return DBManager.getAllOrderOfUser(userName);
//		}
//		return orders;
//	}

}
