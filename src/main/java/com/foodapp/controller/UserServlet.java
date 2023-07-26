package com.foodapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.dao.UserDao;
import com.foodapp.model.User;
import com.foodapp.model.UserType;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao = new UserDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/UserRegistration.jsp");
//		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/AdminLogin.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 String username, password, email, role, first_name, last_name, address; 
		 
		 username=request.getParameter("txt_username");
	     password=request.getParameter("txt_password"); 
	     email=request.getParameter("txt_email");
	     first_name=request.getParameter("txt_firstname");
	     last_name=request.getParameter("txt_lastname");
	     address=request.getParameter("txt_address");
	     //role="customer";
	     
			/*
			 * String dburl="jdbc:mysql://localhost:3306/mysql_database"; String
			 * dbuname="webstudent"; String dbpwd ="webstudent";
			 */
	     
	     String dburl="jdbc:mysql://localhost:3306/food_db"; 
	     String dbuname="root";    
	     String dbpwd ="root";
	        
	     try
	        {
	            Class.forName("com.mysql.jdbc.Driver"); 
	            Connection con= DriverManager.getConnection(dburl,dbuname,dbpwd); 
	            /*out.println ("database successfully opened.");*/
	            PreparedStatement pstmt=null; 
	            
	            pstmt=con.prepareStatement("SELECT * FROM user WHERE email=? "); 
	            pstmt.setString(1,email); 
	            ResultSet rs=pstmt.executeQuery(); 
	           
	            if(rs.next())
	            {
	                String checkEmail=rs.getString("email");
	/*                 String checkUsername=rs.getString("username");
	 */                
	                if(email.equals(checkEmail))    
	                {
	                    request.setAttribute("Msg", "sorry email already exist"); 
	                }
	                
	                RequestDispatcher dispatcher =
		               		 request.getRequestDispatcher("WEB-INF/views/UserDetails.jsp");
		               		 dispatcher.forward(request, response);
		               		 
	/*                 if(username.equals(checkUsername))    
	                {
	                    request.setAttribute("errorMsg", "sorry username already exist"); 
	                } */
	            }
	            else
	            {
	                pstmt=con.prepareStatement("INSERT INTO user (username, password, email, first_name, last_name, address) VALUES(?,?,?,?,?,?)"); 
	                pstmt.setString(1,username);
	                pstmt.setString(2,password);
	                pstmt.setString(3,email);           
	                //pstmt.setString(4,role);
	                pstmt.setString(4,first_name);
	                pstmt.setString(5,last_name);
	                pstmt.setString(6,address);
	                pstmt.executeUpdate(); 
	                
	                request.setAttribute("Msg", "register successfully please login account");
	                
	                RequestDispatcher dispatcher =
	               		 request.getRequestDispatcher("WEB-INF/views/UserDetails.jsp");
	               		 dispatcher.forward(request, response);
	            }
	            
	            pstmt.close();  
	            con.close(); 
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	}
		/*
		 * String firstName = request.getParameter("firstName"); String lastName =
		 * request.getParameter("lastName"); String userName =
		 * request.getParameter("userName"); String password =
		 * request.getParameter("password"); String userTypeStr =
		 * request.getParameter("userType"); UserType userType = UserType.CUSTOMER; if
		 * (UserType.ADMIN.toString().equalsIgnoreCase(userTypeStr)) { userType =
		 * UserType.ADMIN; }
		 * 
		 * User user = new User(); user.setFirstName(firstName);
		 * user.setLastName(lastName); user.setUserName(userName);
		 * user.setPassWord(password); user.setUserType(userType);
		 * 
		 * userDao.registerUser(user); request.setAttribute("user", user); //
		 * response.sendRedirect(""); RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("WEB-INF/views/UserDetails.jsp");
		 * dispatcher.forward(request, response);
		 */

}

