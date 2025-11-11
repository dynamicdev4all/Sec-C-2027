package com.rdec.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import shadow.org.bson.Document;

import java.io.IOException;

import com.rdec.database.DatabaseConnection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailAdd = request.getParameter("email");
		String password = request.getParameter("password");
		
		Document loginUser = DatabaseConnection.loginUser(emailAdd);
		if(loginUser != null) {
			if(loginUser.getString("userEmail").equals(emailAdd) && loginUser.getString("userPassword").equals(password) && loginUser.getBoolean("isVerified")) {
//				response.sendRedirect("home_page.html");
				HttpSession session = request.getSession();
				String name = loginUser.getString("firstName") + " " + loginUser.getString("lastName");
				session.setAttribute("userName", name);
				response.sendRedirect("home.jsp");			
			}else if(loginUser.getString("userEmail").equals(emailAdd) && loginUser.getString("userPassword").equals(password) && !loginUser.getBoolean("isVerified")) {
				System.out.println("The account is not verified, please retry");
			}
			else {
				System.out.println("Your password is invalid");
			}
		}else {
			System.out.println("No user Found");
		}
		//this is not the correct way to use conditions
//		if(emailAdd.equals("admin@rdec.in") && password.equals("123456")) {
//			response.sendRedirect("home_page.html");
//		}	
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
