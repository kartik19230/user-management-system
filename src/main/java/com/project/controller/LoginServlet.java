package com.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.dao.UserDAO;
import com.project.model.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		
		User user = UserDAO.login(email, pwd);
		
		if(user != null) {
			
			HttpSession session = req.getSession();
			session.setAttribute("user",user);
			resp.sendRedirect("dashboard.jsp");
			
		}else {
			
			req.setAttribute("error", "Invalid Email or Password");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}

	
}
