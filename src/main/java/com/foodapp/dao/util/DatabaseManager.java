package com.foodapp.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

	private static final String CONN_STR = "jdbc:mysql://localhost:3306/food_db?allowPublicKeyRetrieval=true&useSSL=false";
	private static final String DB_USER = "root";
	private static final String DB_USER_PASSWORD = "root";
	
	public static Connection getConnection() {
		try {
			Connection connection = DriverManager.getConnection(CONN_STR, DB_USER, DB_USER_PASSWORD);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
