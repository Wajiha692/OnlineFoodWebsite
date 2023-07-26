package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeUserServlet
 */
@WebServlet("/WelcomeUser")
public class WelcomeUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

//		String id = request.getParameter("name");
//		String password = request.getParameter("password");
//		String view = request.getParameter("view");
//		User usr = ApiServices.verifyUser(id,password);
//		if("view".equals(view)) {
//			request.getSession().setAttribute("view", "view");
//		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/WelcomeUser.jsp");
		dispatcher.forward(request, response);

//		if(usr != null || "view".equals(view)) {
//			if(usr != null)
//				request.getSession().setAttribute("userType", usr.getUserType().toString());
//			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/WelcomeUser.jsp");
//			dispatcher.forward(request, response);
//		}
//		else {
//			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/UserLogin.jsp");
//			dispatcher.forward(request, response);
//		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
