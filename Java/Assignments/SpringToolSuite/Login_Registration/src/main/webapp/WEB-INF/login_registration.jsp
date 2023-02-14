<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--For: c:out, c:forEach, etc...  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--For: FORM -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--For: rendering Errors on PUT routes  -->
<%@page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login and Registration</title>

	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container pt-5">
		<div class="row">
			<div class="col-6">
				<h1>Welcome</h1>
				<p>Join our growing community</p>
				
				<h2>Register</h2>
				<form:form action="/register" method="post" modelAttribute="newUser">
					<div>
						<form:label path="userName"  class="form-label">Username:</form:label>
						<form:errors path="userName" class="text-danger" />
						<form:input type="text" path="userName" class="form-control"/>
					</div>
					<div>
						<form:label path="email"  class="form-label">Email:</form:label>
						<form:errors path="email" class="text-danger" />
						<form:input type="text" path="email" class="form-control" />
				   </div>
				   <div>
						<form:label path="password"  class="form-label">Password:</form:label>
						<form:errors path="password" class="text-danger" />
						<form:input type="password" path="password" class="form-control" />
					</div>
					<div>
						<form:label path="confirmPassword"  class="form-label">Confirm Password:</form:label>
						<form:errors path="confirmPassword" class="text-danger" />
						<form:input type="password" path="confirmPassword" class="form-control" />
					</div>
					
					<input type="submit"  value="Register"  class="btn-primary" />
				</form:form>
			</div>
		</div>
			<div class="col-6">		
				<h2>Login</h2>
				<form:form action="/login" method="post" modelAttribute="newLogin">
<%-- 					<div>
						<form:label path="userName"  class="form-label">Username:</form:label>
						<form:errors path="userName" class="text-danger" />
						<form:input type="text" path="userName" class="form-control"/>
					</div> --%>
					<div>
						<form:label path="email"  class="form-label">Email:</form:label>
						<form:errors path="email" class="text-danger" />
						<form:input type="text" path="email" class="form-control" />
				   </div>
				   <div >
						<form:label path="password"  class="form-label">Password:</form:label>
						<form:errors path="password" class="text-danger" />
						<form:input type="password" path="password" class="form-control" />
					</div>

					
					<input type="submit"  value="Login"  class="btn-primary" />
				</form:form>
			</div>
		</div>
</body>
</html>