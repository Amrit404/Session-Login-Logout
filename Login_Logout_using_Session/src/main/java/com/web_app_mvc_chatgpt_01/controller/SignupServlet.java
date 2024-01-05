package com.web_app_mvc_chatgpt_01.controller;

import com.web_app_mvc_chatgpt_01.model.Student;
import com.web_app_mvc_chatgpt_01.model.StudentDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        student.setEmail(email);
        
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.connectDB();
        studentDAO.registerStudent(student);
        
        response.sendRedirect("index.jsp");
    }
}

