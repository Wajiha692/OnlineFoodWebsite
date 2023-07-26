package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.dao.OrderDao;
import com.foodapp.dao.util.DBManager;
import com.foodapp.model2.Order;
import com.foodapp.model2.Restaurant;
import com.foodapp.model2.User;

/**
 * Servlet implementation class CheckoutServlet
 */
@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutServlet() {
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

		Order order = (Order) request.getSession().getAttribute("order");
		// When user want to add order

		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String comments = request.getParameter("comments");
		
		if (order != null) {
			order.setAddress(address);
			order.setContact(contact);
			order.setComments(comments);
//			Restaurant restaurantByName = DBManager.getRestaurantByName(request.getSession().getAttribute("resname").toString());
//			int restid = restaurantByName.getId();
//			order.setRestaurantId(restid);
			int orderId = OrderDao.placeOrder(order);
			if(orderId > -1) {
				order.setOrderId(orderId);
			}
		}

		if(order.getOrderId() > 0) {
			request.setAttribute("orderStatus", "Order placed successful, check your order at `Order Status`");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/WelcomeUser.jsp");
		dispatcher.forward(request, response);

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
