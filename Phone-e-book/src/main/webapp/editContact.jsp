<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.ContactDAO"%>
<%@page import="com.entity.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/components/allCss.jsp"%>
</head>
<body>
	<%@include file="/components/navbar.jsp"%>

	<h1>Edit Page</h1>
		<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Edit Details For User</h4>
						<%
						String succMsg = request.getParameter("succMsg");
						String errMsg = request.getParameter("errorMsg");
						if (succMsg != null) {
						%>
						<p class="text-success text-center"><%= succMsg %></p>
						<%
						} else if (errMsg != null) {
						%>
						<p class="text-danger text-center"><%= errMsg %></p>
						<%
						}
						%>

						<form class="container" action="addContact">
						<%
						int cid = Integer.parseInt(request.getParameter("cid"));
							ContactDAO dao = new ContactDAO(DBConnect.getConn());
						Contact c = dao.getContactByID(cid);
						%>
							<input type="hidden" value="<%= user.getId() %>" name="userid">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Name</label>
								<input type="text" class="form-control" id="exampleInputEmail1" name="name" value="<%=c.getName() %>">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email address</label>
								<input type="email" class="form-control" id="exampleInputEmail1" name="email">
							</div>
							<div class="mb-3">
								<label for="exampleInputNumber1" class="form-label">Number</label>
								<input type="text" class="form-control" id="exampleInputNumber1" name="number">
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>