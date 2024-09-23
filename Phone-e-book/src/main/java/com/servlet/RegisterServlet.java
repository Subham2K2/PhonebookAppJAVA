package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.UserDAO;
import com.entity.User;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = new User(name, email, password);
		
		UserDAO dao = new UserDAO(DBConnect.getConn());
		boolean f= dao.userRegister(u);
		
		HttpSession session = request.getSession();
		
		
		if (f) {
			session.setAttribute("sucssMsg", "User Registration Successful");
			response.sendRedirect("register.jsp");
		}else {
			session.setAttribute("errorMsg", "User Registration Unsuccessful");
			response.sendRedirect("register.jsp");
		}
	}

}
