package com.rdec.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

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
		System.out.println("This is the data from Login Page");
		String emailAdd = request.getParameter("email");
		String password = request.getParameter("password");
		//this is not the correct way to use conditions
//		if(emailAdd.equals("admin@rdec.in") && password.equals("123456")) {
//			response.sendRedirect("home_page.html");
//		}	
		if("admin@rdec.in".equals(emailAdd) && "123456".equals(password)) {
//			response.sendRedirect("home_page.html");
			HttpSession session = request.getSession();
			session.setAttribute("userName", "Deepak");
			response.sendRedirect("home.jsp");			
		}else {
			System.out.println("Your email or password is invalid");
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
