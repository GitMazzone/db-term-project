/************************************************************************************
 * @file ControllerServlet.java
 *
 * @author  Michael Mazzone
 */

package com.dbtermproject;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet used to handle requests for the Web app.
 */
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private QueryResultDAO qrDAO;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        
        qrDAO = new QueryResultDAO();
        qrDAO.connect();
        qrDAO.disconnect();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getPathInfo();
		RequestDispatcher dispatcher = request.getRequestDispatcher(action + ".jsp");
		ArrayList<QueryResult> tuples = new ArrayList<>();
		boolean queried = true;
		
		switch(action) {
		case "/*":
		case "/":
			dispatcher = request.getRequestDispatcher("/Home.jsp");
			queried = false;
			break;
		case "/Query1":
			tuples = qrDAO.listAllEntitiesAndImpressions();
			break;
		case "/Query2":
			tuples = qrDAO.listAllEntitiesAndTheirAds();
			break;
		case "/Query3":
			tuples = qrDAO.listAllAdsAndImpressions();
			break;
		case "/Query4":
			tuples = qrDAO.listTargetAudiences();
			break;
		case "/Query5":
			tuples = qrDAO.listEntityAdProportions();
			break;
		case "/Query6":
			tuples = qrDAO.listEntitiesRankedByPoliticalness();
			break;
		case "/Query7":
			tuples = qrDAO.listAdsWithinDateRange();
			break;
		case "/Query8":
			tuples = qrDAO.listWellKnownImpressions();
			break;
		case "/Query9":
			tuples = qrDAO.listPubliclyTraded();
			break;
		}
		
		if(queried) request.setAttribute("result_tuples", tuples);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
