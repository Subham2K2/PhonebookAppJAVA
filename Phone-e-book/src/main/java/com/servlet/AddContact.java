package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.ContactDAO;
import com.entity.Contact;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/addContact")
public class AddContact extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId=Integer.parseInt(req.getParameter("userid"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phonno = req.getParameter("number");
		
		Contact c=new Contact(name, email, phonno, userId);
		ContactDAO dao = new ContactDAO(DBConnect.getConn());
		
		boolean f = dao.saveContact(c);
		HttpSession session = req.getSession();
		if (f) {
			session.setAttribute("succMsg", "Your Contact saved successfully");
			resp.sendRedirect("addContact.jsp");
		}else {
			session.setAttribute("errorMsg", "Your Contact not saved successfully");
			resp.sendRedirect("addContact.jsp");
		}
	}
	
}
