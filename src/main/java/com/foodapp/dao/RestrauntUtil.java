package com.foodapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.Item;
import com.foodapp.model.Menu;
import com.foodapp.model.Restraunt;

public class RestrauntUtil {
	private static List<Restraunt> restraunts = new ArrayList<>();

	public RestrauntUtil() {
		initRestraunt();
	}

	private void initRestraunt() {
		List<Item> veg;
		List<Item> nonveg;
		List<Item> bread;
		List<Item> beverage;
		Restraunt res;

		veg = new ArrayList<Item>();
		Item veg1 = new Item("Dal Fry", 190F);
		Item veg2 = new Item("Rice", 240F);
		Item veg3 = new Item("Paneer kadhai", 280F);
		veg.add(veg1);
		veg.add(veg2);
		veg.add(veg3);

		nonveg = new ArrayList<Item>();
		Item nonveg1 = new Item("Chicken tikka", 350F);
		Item nonveg2 = new Item("Chicken Biryani", 550F);
		Item nonveg3 = new Item("Fish Fry", 380F);
		nonveg.add(nonveg1);
		nonveg.add(nonveg2);
		nonveg.add(nonveg3);

		bread = new ArrayList<Item>();
		Item bread1 = new Item("Roti", 10F);
		Item bread2 = new Item("Naan", 40F);
		Item bread3 = new Item("Paratha", 30F);
		bread.add(bread1);
		bread.add(bread2);
		bread.add(bread3);

		beverage = new ArrayList<Item>();
		Item beverage1 = new Item("Lime juice", 45F);
		Item beverage2 = new Item("Milkshake", 40F);
		Item beverage3 = new Item("Water", 30F);
		beverage.add(beverage1);
		beverage.add(beverage2);
		beverage.add(beverage3);

		Menu menu = new Menu(veg, nonveg, bread, beverage);
		res = new Restraunt("habib", menu, 3.5F);
		restraunts.add(res);

		List<Item> vegList1 = new ArrayList<>();
		List<Item> nonvegList1 = new ArrayList<>();
		List<Item> breadList1 = new ArrayList<>();
		List<Item> beverageList1 = new ArrayList<>();

		veg1 = new Item("Dal fry", 200F);
		veg2 = new Item("pulao", 250F);
		veg3 = new Item("chilly paneer", 320F);
		vegList1.add(veg1);
		vegList1.add(veg2);
		vegList1.add(veg3);

		nonveg1 = new Item("Chicken kadhai", 360F);
		nonveg2 = new Item("mutton Biryani", 1050F);
		nonveg3 = new Item("Fish curry", 480F);
		nonvegList1.add(nonveg1);
		nonvegList1.add(nonveg2);
		nonvegList1.add(nonveg3);

		bread1 = new Item("Rumali", 15F);
		bread2 = new Item("Butter Naan", 45F);
		bread3 = new Item("Paratha", 30F);
		Item bread4 = new Item("kulcha", 60F);

		breadList1.add(bread1);
		breadList1.add(bread2);
		breadList1.add(bread3);
		breadList1.add(bread4);

		beverage1 = new Item("Soda Lime", 45F);
		beverage2 = new Item("Coffee", 100F);
		beverage3 = new Item("Tea", 85F);
		beverageList1.add(beverage1);
		beverageList1.add(beverage2);
		beverageList1.add(beverage3);

		menu = new Menu(vegList1, nonvegList1, breadList1, beverageList1);
		res = new Restraunt("Sajjad", menu, 4.2F);
		restraunts.add(res);

		List<Item> vegList2 = new ArrayList<>();
		List<Item> nonvegList2 = new ArrayList<>();
		List<Item> breadList2 = new ArrayList<>();
		List<Item> beverageList2 = new ArrayList<>();

		veg1 = new Item("Curry", 220.2F);
		veg2 = new Item("Dal Chaawal", 50F);
		veg3 = new Item("Vegetable Biryani", 180F);
		vegList2.add(veg1);
		vegList2.add(veg2);
		vegList2.add(veg3);

		nonveg1 = new Item("Egg Roll", 90F);
		nonveg2 = new Item("mutton Keema", 980F);
		nonveg3 = new Item("chicken fried rice", 275F);
		nonvegList2.add(nonveg1);
		nonvegList2.add(nonveg2);
		nonvegList2.add(nonveg3);

		bread1 = new Item("Tava Roti", 8F);
		bread2 = new Item("Butter Naan", 40F);
		bread3 = new Item("Stuffed Naan", 60F);
		bread4 = new Item("Aloo Paratha", 50F);

		breadList2.add(bread1);
		breadList2.add(bread2);
		breadList2.add(bread3);
		breadList2.add(bread4);

		beverage1 = new Item("Mojito", 45F);
		beverage2 = new Item("Orange Juice", 45F);
		beverage3 = new Item("Mint Lime", 25F);
		beverageList2.add(beverage1);
		beverageList2.add(beverage2);
		beverageList2.add(beverage3);

		menu = new Menu(vegList2, nonvegList2, breadList2, beverageList2);
		res = new Restraunt("Kolachi", menu, 3.9F);
		restraunts.add(res);
	}

	public Restraunt getRestrauntByName(String name) {
		Restraunt rest = null;
		for (Restraunt r : restraunts) {
			if (r.getName().equalsIgnoreCase(name)) {
				rest = r;
				break;
			}
		}
		return rest;
	}

	public void addRestraunts(Restraunt res) {
		restraunts.add(res);

	}
}
