package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.UserDAO;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		User u = dao.loginUser(email, password);
		HttpSession session = req.getSession();
		 try {
		        
		        if (u != null) {
		        	session.setAttribute("user", u);
		            System.out.println("User is Available: " + u);
		            resp.sendRedirect("index.jsp"); // Redirect to home if successful
		        } else {
		            System.out.println("User is not available");
		            resp.sendRedirect("login.jsp?error=invalid"); // Include error message
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        resp.sendRedirect("login.jsp?error=server"); // Redirect with a server error indicator
		    }
	}
}
