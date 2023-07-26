/*
 * package com.foodapp.controller;
 * 
 * import java.io.IOException;
 * 
 * import javax.servlet.RequestDispatcher; import
 * javax.servlet.ServletException; import javax.servlet.annotation.WebServlet;
 * import javax.servlet.http.HttpServlet; import
 * javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import com.foodapp.model.User; import com.foodapp.model.UserType; import
 * com.foodapp.services.ApiServices;
 * 
 *//**
	 * Servlet implementation class Login
	 */
/*
 * @WebServlet("/userlogin") public class UserLoginServlet extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 *//**
	 * @see HttpServlet#HttpServlet()
	 */
/*
 * public UserLoginServlet() { super(); }
 * 
 *//**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
/*
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * response.getWriter().append("Served at: ").append(request.getContextPath());
 * 
 * request.getSession().removeAttribute("userType");
 * 
 * RequestDispatcher dispatcher =
 * request.getRequestDispatcher("WEB-INF/views/UserLogin.jsp");
 * dispatcher.forward(request, response); }
 * 
 *//**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 *//*
		 * protected void doPost(HttpServletRequest request, HttpServletResponse
		 * response) throws ServletException, IOException { String id =
		 * request.getParameter("name"); String password =
		 * request.getParameter("password");
		 * 
		 * User usr = ApiServices.verifyUser(id, password);
		 * 
		 * if (usr == null) { doGet(request, response); return; }
		 * 
		 * if (UserType.ADMIN.equals(usr.getUserType())) {
		 * request.getSession().removeAttribute("userType");
		 * request.getSession().setAttribute("userType", usr.getUserType().toString());
		 * request.getSession().setAttribute("userName", usr.getUserName());
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("WEB-INF/views/AdminPannel.jsp");
		 * dispatcher.forward(request, response); } else if
		 * (UserType.CUSTOMER.equals(usr.getUserType())) {
		 * request.getSession().removeAttribute("userType");
		 * request.getSession().setAttribute("userType", usr.getUserType().toString());
		 * request.getSession().setAttribute("userName", usr.getUserName());
		 * RequestDispatcher dispatcher =
		 * request.getRequestDispatcher("WEB-INF/views/WelcomeUser.jsp");
		 * dispatcher.forward(request, response); } else { doGet(request, response); }
		 * 
		 * }
		 * 
		 * }
		 */