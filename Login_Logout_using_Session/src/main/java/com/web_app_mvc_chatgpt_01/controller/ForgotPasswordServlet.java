package com.web_app_mvc_chatgpt_01.controller;

import com.web_app_mvc_chatgpt_01.model.StudentDAO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@WebServlet("/forgotpassword")
public class ForgotPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ForgotPasswordServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
        String newPassword = request.getParameter("newPassword");

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.connectDB();
        boolean status = studentDAO.existByEmail(email);
        if(status) {
        	// Call the updatePassword method to update the password
	        studentDAO.updatePassword(email, newPassword);
	
	        response.sendRedirect("index.jsp");
	        
        }else {
	        request.setAttribute("error", "Email does not exist");
        	RequestDispatcher rd = request.getRequestDispatcher("forgotpassword.jsp");
        	rd.forward(request, response);
        }
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
