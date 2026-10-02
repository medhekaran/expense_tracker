package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.cfg.Configuration;

import com.dao.ExpenseDao;
import com.entity.Expense;
import com.entity.User;

@WebServlet("/updateExpense")
public class UpdateExpenseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String title =req.getParameter("title");
		String date =req.getParameter("date");
		String time =req.getParameter("time");
		String descpription =req.getParameter("descpription");
		String price =req.getParameter("price");
		
		HttpSession session = req.getSession();
		User user=(User) session.getAttribute("loginUser");
		
		Expense ex = new Expense(title,date,time,descpription,price, user);
		ex.setId(id);
		ExpenseDao dao = new ExpenseDao(new Configuration().configure("hibernate.cfg.xml").buildSessionFactory());
		boolean f=dao.updateExpense(ex);
		
		if(f) {
			session.setAttribute("msg", "Expense Updated Successful");
			resp.sendRedirect("user/view_expense.jsp");
		}else {
			session.setAttribute("msg", "Something Wrong");
			resp.sendRedirect("user/view_expense.jsp");
		}
		
	}

	
}
