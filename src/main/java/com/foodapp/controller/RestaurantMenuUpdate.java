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
 * Servlet implementation class RestaurantMenuUpdate
 */
@WebServlet("/RestaurantMenuUpdate")
public class RestaurantMenuUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RestaurantMenuUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("operation", "RestaurantMenuUpdate");
		request.setAttribute("action", "Update");

		String resname = request.getParameter("name");

		Restaurant rest = DBManager.getRestaurantByName(resname);

		request.setAttribute("restraunt", rest);
		request.setAttribute("menu", rest.getMenu());

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/ModifyMenuRestaurant.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String restaurantId = request.getParameter("restid");
		String changes = request.getParameter("menuModification");
		RestrauntDao rd = new RestrauntDao();
		rd.performUpdate(changes, restaurantId);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/AdminPannel.jsp");
		dispatcher.forward(request, response);
	}

}
