<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.ContactDAO"%>
<%@page import="com.entity.Contact"%>
<%@
page import="java.util.ArrayList"%>
<%@
page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Contact Page</title>
<%@include file="/components/allCss.jsp"%>
<style type="text/css">
.crd-ho:hover {
	background-color: #f7f7f7;
} 
</style>
</head>
<body>
	<%@include file="/components/navbar.jsp"%>
	<%
	if (user == null) {
		response.sendRedirect("login.jsp");
	}
	%>
	<div class="container">
		<div class="row p-4">

			<%
			if (user != null) {
				ContactDAO dao = new ContactDAO(DBConnect.getConn());
				List<Contact> contact = dao.getAllContact(user.getId());
				for (Contact c : contact) {
			%>
			<div class="col-md-3">
				<div class="card crd-ho">
					<div class="card-body">
						<h5>
							Name :
							<%=c.getName()%></h5>
						<h5>
							Ph no:
							<%=c.getPhonno()%></h5>
						<h5>
							Email :
							<%=c.getEmail()%></h5>
						<div class="text-centre">
							<a href="editContact.jsp?cid = <%=c.getId() %>" class="btn btn-success">Edit</a> <a class="btn btn-delete">Delete</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			}
			%>

		</div>
	</div>
</body>
</html>