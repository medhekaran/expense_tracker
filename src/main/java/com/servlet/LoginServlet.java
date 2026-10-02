package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.cfg.Configuration;

import com.dao.userDao;
import com.entity.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email= req.getParameter("email");
		
		String password = req.getParameter("password");
		
		userDao dao = new userDao(new Configuration().configure("hibernate.cfg.xml").buildSessionFactory());
		
		User u=dao.login(email, password);
		
		HttpSession session = req.getSession();

		if(u==null) {
			session.setAttribute("msg", "invalid email & Password");
			resp.sendRedirect("login.jsp");

		}else {
			session.setAttribute("loginUser", u);
			resp.sendRedirect("user/home.jsp");
		}
			
	}

	
	
}
