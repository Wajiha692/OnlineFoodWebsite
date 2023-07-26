package com.foodapp.model2;

// Model class for user
public class User {

	protected int userId;
	protected String userName;
	protected String password;
	protected String firstName;
	protected String lastName;
	protected String email;
	protected String address;

	// Constructor with all fields
	public User(int userId, String userName, String password, String firstName, String lastName, String email, String address) {
		this(userName, password, firstName, lastName, email, address);
		this.userId = userId;
	}
	
	public User(String userName, String password, String firstName, String lastName, String email, String address) {
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.address = address;
	}
	
	// Default constructor
	public User() {}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", address=" + address + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getUserId() {
		return userId;
	}

	public User getUser() {
		User user = new User();
		user.setAddress(address);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.userId = userId;
		return user;
	}
}
