package com.foodapp.services;

import com.foodapp.dao.RestrauntUtil;
import com.foodapp.dao.UserDao;
import com.foodapp.model.Menu;
import com.foodapp.model.Restraunt;
import com.foodapp.model.User;

public class ApiServices {

	public static User verifyUser(String username, String password) {
		UserDao u1 = new UserDao();

		User usr = u1.getUserByUsername(username);
		if (usr != null) {
			if (usr.getPassWord().equals(password)) {
				return usr;
			}
		}
		return null;
	}

	public static void addRestraunt(String name, Menu menu, Float rating) {
		RestrauntUtil resd = new RestrauntUtil();
		Restraunt res = new Restraunt(name, menu, rating);
		resd.addRestraunts(res);
	}

	public static Restraunt getRestraunts(String resname) {
		RestrauntUtil res = new RestrauntUtil();

		return res.getRestrauntByName(resname);
	}

}
