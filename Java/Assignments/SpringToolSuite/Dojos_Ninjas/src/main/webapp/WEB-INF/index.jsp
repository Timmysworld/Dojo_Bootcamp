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

	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
<meta charset="UTF-8">
<title>Ninja and Villages</title>
</head>
<body>
	<h1>Villages</h1>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/villages/create" method="POST" modelAttribute="village">
					<div>
						<form:label path="name" class="form-label">Name:</form:label>
						<%-- <form:errors path="name"  class="text-danger"/> --%>
						<form:input type="text" path="name" class="form-control"/>
					</div>
					<input type="submit"  value="Create"  class="btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
	
	<c:forEach var="village" items="${villages}">
		<ul>
			<li><a href="/villages/view/${village.id}"><c:out value="${village.name}"></c:out></a></li> 
		</ul>
		
	</c:forEach>
	
	<hr />

	<h1>Ninja</h1>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<form:form action="/ninjas/create" method="POST" modelAttribute="ninja">
					<div>
					<form:label path="village" class="form-label">Village Name:</form:label>
						<form:select path="village">
        					<c:forEach var="vil" items="${villages}">
	        					<option value="${vil.id}"><c:out value="${vil.name}"/></option>
        					</c:forEach>
        				</form:select>
					</div> 
					<div>
						<form:label path="firstName" class="form-label">First Name:</form:label>
						<%-- <form:errors path="name"  class="text-danger"/> --%>
						<form:input type="text" path="firstName" class="form-control"/>
					</div>
					<div>
						<form:label path="lastName" class="form-label">Last Name:</form:label>
						<form:input type="text" path="lastName" class="form-control"/>
					</div>
					<div>
						<form:label path="age" class="form-label">Age:</form:label>
						<form:input type="text" path="age" class="form-control"/>
					</div>
					
					<input type="submit"  value="Add Ninja"  class="btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
	
		<c:forEach var="ninja" items="${ninjas}">
			<ul>
				<li><c:out value="${ninja.firstName}"></c:out></li>
			</ul>
		</c:forEach>
	
	
</body>
</html>