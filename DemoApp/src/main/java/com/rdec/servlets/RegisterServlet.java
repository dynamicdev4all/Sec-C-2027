package com.rdec.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.image.DataBufferShort;
import java.io.IOException;
import java.sql.DatabaseMetaData;

import com.app.util.JWTUtil;
import com.rdec.database.DatabaseConnection;
import com.rdec.services.OTPService;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phoneNo = request.getParameter("phone");
		String emailAdd = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean saveDataStatus = DatabaseConnection.insertUserData(firstName, lastName, Integer.parseInt(phoneNo), emailAdd, password);
		
		if(saveDataStatus) {
			int generateOTP = (int)((Math.random()* 900000) + 100000);
			String token = JWTUtil.createToken(emailAdd, generateOTP);
//			boolean OTPSentStatus = OTPService.sendRegisterOTP(emailAdd, firstName + " " + lastName, generateOTP);
			boolean OTPSentStatus = OTPService.sendRegisterOTP(emailAdd, firstName + " " + lastName, token);
			if(OTPSentStatus) {
				HttpSession session = request.getSession();
				session.setAttribute("sentOTP", generateOTP);
				session.setAttribute("email", emailAdd);
				response.sendRedirect("otp_verify.html");
			}else {
				System.out.println("Cannot send OTP");
			}
		}else {
			System.out.println("Data not saved in DB");
		}
		
		


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
