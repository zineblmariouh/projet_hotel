package controller;


import beans.User;
import service.UserService;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {
	UserService userService = new UserService();
   
    
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session = request.getSession();
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String email = request.getParameter("email");
        String password = request.getParameter("password");
        try 
        {
    		String generatedPassword = null;
    		
          // Create MessageDigest instance for MD5
          MessageDigest md = MessageDigest.getInstance("MD5");

          // Add password bytes to digest
          md.update(password.getBytes());

          // Get the hash's bytes
          byte[] bytes = md.digest();

          // This bytes[] has bytes in decimal format. Convert it to hexadecimal format
          StringBuilder sb = new StringBuilder();
          for (int i = 0; i < bytes.length; i++) {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
          }
         
          // Get complete hashed password in hex format
          generatedPassword = sb.toString();
          User user = userService.findByEmailAndPassword(email, generatedPassword);
          if(user != null) {
          HttpSession session = request.getSession();
          session.setAttribute("id", user.getIdentifier());
          session.setAttribute("nom", user.getNom());
          session.setAttribute("prenom", user.getPrenom());
          response.sendRedirect("hotels.jsp");
          }
          else {
	  		request.setAttribute("message", "Login failed");
  			RequestDispatcher dispatcher = 
  	        request.getRequestDispatcher("login.jsp");
      	    dispatcher.forward( request, response ); 
          }
        } catch (Exception e) {
          e.printStackTrace();
        }
       
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
