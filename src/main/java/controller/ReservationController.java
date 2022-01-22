package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.ReservationService;
import beans.Reservation;
import connexion.Connexion;

@WebServlet(name = "ReservationController", urlPatterns = { "/ReservationController" })
public class ReservationController extends HttpServlet {

	ReservationService reservationService = new ReservationService();

	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		RequestDispatcher dispatcher = 
    	        request.getRequestDispatcher("reservation.jsp");
    	    dispatcher.forward( request, response ); 
		

	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request  servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException      if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String First_name = request.getParameter("fname");
		String Last_name = request.getParameter("lname");
		String Email = request.getParameter("email");
		String Country = request.getParameter("country");
		String Phone = request.getParameter("phone");
		String chambre = request.getParameter("id");
	
		String dateDebut = request.getParameter("cin");
		String dateFin = request.getParameter("cout");
		reservationService.create(new Reservation(chambre, First_name, Last_name, Email, Country, Phone, dateDebut, dateFin));
		response.sendRedirect("hotels.jsp");
		
		
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
