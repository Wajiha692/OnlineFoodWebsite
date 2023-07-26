package com.foodapp.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.foodapp.dao.util.DBManager;
import com.foodapp.model.LoginBean;
import com.foodapp.model.UserType;
import com.foodapp.model2.User;

public class LoginDao {

	private LoginBean user;
	
	public LoginDao(LoginBean user) {
		this.user = user;
	}
	
	public User validate() {
		User loginUser = null;
		if(UserType.ADMIN.equals(user.getRole())) {
			loginUser = DBManager.getOwner(user.getUsername(), user.getPassword());
		} else if (UserType.CUSTOMER.equals(user.getRole())) {
			loginUser = DBManager.getUser(user.getUsername(), user.getPassword());
		}
		return loginUser;
	}
	
    public String validate(LoginBean loginBean) throws ClassNotFoundException {
       // String status = "";

        Class.forName("com.mysql.cj.jdbc.Driver");

        String username = loginBean.getUsername();
    	String password = loginBean.getPassword();
//    	String role = loginBean.getRole();
    	
    	String usernameDB = "";
        String passwordDB = "";
        String roleDB = "";
        
        try (Connection connection = DriverManager
            .getConnection("jdbc:mysql://localhost:3306/mysql_database?allowPublicKeyRetrieval=true&useSSL=false", "webstudent", "webstudent");

        	
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from login where username = ? and password = ? and role = ? ")) {
            preparedStatement.setString(1, loginBean.getUsername());
            preparedStatement.setString(2, loginBean.getPassword());
//            preparedStatement.setString(3, loginBean.getRole());
            
            
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            
            
            while(rs.next())
            {
            	usernameDB = rs.getString("username");
                passwordDB = rs.getString("password");
                roleDB = rs.getString("role");
     
                if(username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("admin"))
                return "admin";
                
                else if(username.equals(usernameDB) && password.equals(passwordDB) && roleDB.equals("customer"))
                return "customer";
            }

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return "Invalid user credentials";
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}