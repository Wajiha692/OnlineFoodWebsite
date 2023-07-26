package com.foodapp.dao;

import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.User;
import com.foodapp.model.UserType;

public class UserDao {

	private List<User> users = new ArrayList<>();

	public UserDao() {
		initUser();
	}

	private void initUser() {
		/*
		 * User admin1 = new User(); admin1.setFirstName("John");
		 * admin1.setLastName("Doe"); admin1.setUserName("admin");
		 * admin1.setPassWord("admin"); admin1.setUserType(UserType.ADMIN);
		 * users.add(admin1);
		 */
		User customer1 = new User();
		customer1.setFirstName("Evan");
		customer1.setLastName("Blacier");
		customer1.setUserName("customer1");
		customer1.setPassWord("customer1");
		customer1.setUserType(UserType.CUSTOMER);
		users.add(customer1);

		User customer2 = new User();
		customer2.setFirstName("Kemp");
		customer2.setLastName("Loan");
		customer2.setUserName("customer2");
		customer2.setPassWord("customer2");
		customer2.setUserType(UserType.CUSTOMER);
		users.add(customer2);

	}

	public void registerUser(User user) {
		users.add(user);
	}

	public User getUserByUsername(String userName) {
		User usr = null;
		for (User user : users) {
			if (user.getUserName().equalsIgnoreCase(userName)) {
				usr = user;
				break;
			}
		}
		return usr;
	}
}
