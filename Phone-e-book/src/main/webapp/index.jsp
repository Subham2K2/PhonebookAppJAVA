<%@page import="com.conn.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/components/allCss.jsp"  %>
<style type="text/css">

</style>
</head>
<body>
<%@include file="/components/navbar.jsp" %>

<%
Connection conn = DBConnect.getConn();
out.print(conn);
%>
<div class="container-fluid back-img text-center text-success">
	<h1 class="mt-3">Welcome to PhoneBook App</h1>
</div>

<%@include file="/components/footer.jsp" %>
</body>
</html>