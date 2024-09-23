<%@page import="com.entity.User"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">Phonebook</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="index.jsp">Home</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="addContact.jsp">Add phone number</a></li>
				<li class="nav-item"><a class="nav-link active"
					href="viewContact.jsp" aria-expanded="false"> view contact </a></li>
			</ul>

			<%
			User user = (User) session.getAttribute("user");
			if (user == null) {
			%>
			<form class="d-flex">
				<a href="login.jsp" class="btn btn-success ">Login</a> <a
					href="register.jsp" class="btn btn-danger ml-2">Register</a>
			</form>
			<%
			} else {
			%>
			<form class="d-flex">
				<button class="btn btn-primary"><%= user.getName()%></button>
				<a href="logout" class="btn btn-success ">Logout
				</a>
			</form>
			<%
			}
			%>



		</div>
	</div>
</nav>