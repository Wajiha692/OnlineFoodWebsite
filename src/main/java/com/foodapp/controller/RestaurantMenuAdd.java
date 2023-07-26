package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.dao.RestrauntDao;
import com.foodapp.dao.util.DBManager;
import com.foodapp.model2.Restaurant;

/**
 * Servlet implementation class RestaurantMenuAdd
 */
@WebServlet("/RestaurantMenuAdd")
public class RestaurantMenuAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantMenuAdd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// this attribute is used in form action
		request.setAttribute("operation", "RestaurantMenuAdd");
		
		// this attibute is used for button label
		request.setAttribute("action", "Add to Menu");

		String resname = request.getParameter("name");

		// This will get the restaurant object which has given restaurant details and all its menu details
		Restaurant rest = DBManager.getRestaurantByName(resname);

		request.setAttribute("restraunt", rest);
		request.setAttribute("menu", rest.getMenu());

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/AddRestaurantMenu.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String restaurantId = request.getParameter("restid");
		String changes = request.getParameter("menuModification");
		System.out.println(changes);
		RestrauntDao rd = new RestrauntDao();
		rd.performAddMenuItems(changes, restaurantId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/AdminPannel.jsp");
		dispatcher.forward(request, response);
	}

}
