package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.dao.LoginDao;
import com.foodapp.model.LoginBean;
import com.foodapp.model.UserType;
import com.foodapp.model2.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/userlogin")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.getSession().removeAttribute("userType");
		// for get resquet on /userLogin redirect to UserLogin.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/UserLogin.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		LoginBean bean = new LoginBean();
		bean.setUsername(username);
		bean.setPassword(password);
		bean.setRole(role.equalsIgnoreCase(UserType.ADMIN.toString()) ? UserType.ADMIN : UserType.CUSTOMER);
		LoginDao login = new LoginDao(bean);

		User user = login.validate();

		if (user == null) {
			// user not found with given username and password
			// set loginStatus attribute, this will be used in UserLigin.jsp page to show
			// invalid user message
			request.setAttribute("loginStatus", "Invalid username or password");
			request.getRequestDispatcher("WEB-INF/views/UserLogin.jsp").forward(request, response);
		} else {
			request.setAttribute("userName", user.getUserName());
			request.getSession().setAttribute("user", user);
			if (bean.getRole().equals(UserType.ADMIN)) {
				request.getSession().setAttribute("userType", UserType.ADMIN.toString());
				request.getRequestDispatcher("WEB-INF/views/AdminPannel.jsp").forward(request, response);
			} else if (bean.getRole().equals(UserType.CUSTOMER)) {
				request.getSession().setAttribute("userType", UserType.CUSTOMER.toString());
				request.getRequestDispatcher("WEB-INF/views/WelcomeUser.jsp").forward(request, response);
			}
		}

	}
}