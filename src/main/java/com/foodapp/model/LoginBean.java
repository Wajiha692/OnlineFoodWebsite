package com.foodapp.model;
import java.io.Serializable;

public class LoginBean implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String role;
    private UserType userType;

    public UserType getRole() {
		return userType;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public void setRole(UserType userType) {
		this.userType = userType;
	}
}
