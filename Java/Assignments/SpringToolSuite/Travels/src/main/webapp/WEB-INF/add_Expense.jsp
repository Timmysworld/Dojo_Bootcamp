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
	<title>Add Expense</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>Add Expense:</h1>
				<a href="/dashboard" class="btn btn-primary">Dashboard</a>
				<form:form action="/expenses/add" method="post" modelAttribute="budget">
					<div>
						<form:label path="expense"  class="form-label">Expenses:</form:label>
						<form:errors path="expense" class="text-danger" />
						<form:input type="text" path="expense" class="form-control"/>
					</div>
					<div>
						<form:label path="vendor"  class="form-label">Vendor:</form:label>
						<form:errors path="vendor" class="text-danger" />
						<form:input type="text" path="vendor" class="form-control" />
				   </div>
					<div>
						<form:label path="amount"  class="form-label">Amount:</form:label>
						<form:errors path="amount" class="text-danger" />
						<form:input type="number" path="amount" class="form-control" />
					</div>
					<div>
						<form:label path="description"  class="form-label">Description:</form:label>
						<form:errors path="description" class="text-danger" />
						<form:textarea row="5" col="10" path="description" class="form-control" />
					</div>
					
					<input type="submit"  value="Add An Expense"  class="btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>