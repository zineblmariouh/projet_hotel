package controller;

import beans.User;
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

import service.UserService;


@WebServlet(name = "Signup", urlPatterns = {"/Signup"})
public class Signup extends HttpServlet {
   
    UserService userService = new UserService();
 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
        
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
    	String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String repass = request.getParameter("re_password");
        
 
        if(nom.length() < 2) {
        	request.setAttribute("nom", "Invalid name at least 2 characters");
        }
        if(prenom.length() < 2) {
        	request.setAttribute("prenom", "Invalid first name at least 2 characters");
        }
        if(!email.contains("@") || !email.contains(".")) {
        	request.setAttribute("email", "invalid email");
        }
        if(password.length() < 4) {
        	request.setAttribute("pass", "Invalid password at least 4 characters");
        }
        if(!repass.equals(password)) {
        	request.setAttribute("repass", "passwords aren't similar");
        }
    	if(request.getAttribute("nom") != null ||request.getAttribute("prenom") != null 
    			|| request.getAttribute("email") != null || request.getAttribute("pass") != null 
    			||request.getAttribute("repass") != null) {
    		request.setAttribute("message", "Login failed");
    		RequestDispatcher dispatcher = 
        	        request.getRequestDispatcher("signup.jsp");
        	    dispatcher.forward( request, response ); 
	    }
        else {
        	try 
            {
        		String generatedPassword = null;
        		int Min = 1;
                int Max = 9999999;
                int random = Min + (int)(Math.random() * ((Max - Min) + 1));
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
              userService.create(new User(nom, prenom, email, generatedPassword, random));
              HttpSession session = request.getSession();
              session.setAttribute("id", random);
              session.setAttribute("nom", nom);
              session.setAttribute("prenom", prenom);
              response.sendRedirect("hotels.jsp");
            } catch (Exception e) {
              e.printStackTrace();
            }
          
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
