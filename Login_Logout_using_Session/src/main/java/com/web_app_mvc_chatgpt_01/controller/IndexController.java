package com.web_app_mvc_chatgpt_01.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web_app_mvc_chatgpt_01.model.StudentDAO;


@WebServlet("/login")
public class IndexController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public IndexController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		StudentDAO studentDAO = new StudentDAO();
        studentDAO.connectDB();
        boolean logIn = studentDAO.logIn(username,password);
        
		if(logIn) {
			request.setAttribute("msg", "WELCOME");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/view/newfile.jsp");
			rd.forward(request, response);
		}else {
			request.setAttribute("error", "Wrong Credential");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		
	}

}
