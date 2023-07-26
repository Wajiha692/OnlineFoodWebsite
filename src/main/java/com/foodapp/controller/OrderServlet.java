package com.foodapp.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.dao.OrderDao;
import com.foodapp.model.UserType;
import com.foodapp.model2.Order;
import com.foodapp.model2.User;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
		String resname = request.getParameter("resname");

		Object userType = request.getSession().getAttribute("userType");
		Object user = request.getSession().getAttribute("user");
		if (UserType.ADMIN.toString().equalsIgnoreCase(userType.toString())) {
			request.setAttribute("allorders", OrderDao.getAllOrdersAnyUser(user));
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/allorders.jsp");
			dispatcher.forward(request, response);
			return;
		}
		String userName = "";
		if (user instanceof User) {
			userName = ((User) user).getUserName();
		} else {
			// TODO
			// return from here as we cannot find user
			// call logout and let user login again
		}
		Map<String, String[]> parameterMap = request.getParameterMap();
		Order order = null;
		// When user want to add order
		if (parameterMap.size() > 0) {
			order = OrderDao.createOrder((User) user, parameterMap, resname);
			// set to request attribute
			request.setAttribute("order", order);
			// set to session, this will be used at checkout
			request.getSession().setAttribute("order", order);
//			request.getSession().setAttribute("resname", order.getResName());
//			request.getSession().setAttribute("restid", order.getRestaurantId());
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/order.jsp");
			dispatcher.forward(request, response);
		} else {
			// When user want to see his own order
			request.setAttribute("allorders", OrderDao.getAllOrdersAnyUser(user));
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/allorders.jsp");
			dispatcher.forward(request, response);
			return;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
