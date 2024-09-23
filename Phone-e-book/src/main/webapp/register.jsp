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


	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center text-success">Registration Page</h4>
						
						<% String sucsMsg = (String)session.getAttribute("sucssMsg"); 
						String errorMsg = (String)session.getAttribute("errorMsg");
						if(sucsMsg!=null){
						%>
							<p class="text-success text-centre"><%=sucsMsg %></p>
						<%	
						session.removeAttribute("sucssMsg");
						}
						if(errorMsg != null){
						%>
							<p class="text-danger text-centre"><%=errorMsg %></p>
						<%
						session.removeAttribute("errorMsg");
						}
						%>
						
						<form class="container" action="register" method="post">
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Name</label>
								<input type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="name">
							</div>
							<div class="mb-3">
								<label for="exampleInputEmail1" class="form-label">Email
									address</label> <input type="email" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="email">
							</div>
							<div class="mb-3">
								<label for="exampleInputPassword1" class="form-label">Password</label>
								<input type="password" class="form-control"
									id="exampleInputPassword1" name="password">
							</div>
							<button type="submit" class="btn btn-primary">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>



	<%@include file="/components/footer.jsp"%>
</body>
</html>