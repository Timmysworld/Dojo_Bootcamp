<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>Travel Expense: Details</title>
</head>
<body>

	<h2 class="mx-auto">Expense Details:</h2>
	<a href="/dashboard" class="btn btn-primary mx-auto" >Dashboard</a>
		
		<div class="card mx-auto" style="width: 18rem;">
	
			<div class="card-body" >
		
				<h5 class="card-title">Expense: <c:out value="${budget.expense}"></c:out></h5>
				<h6 class="card-subtitle mb-2 text-muted"> Vendor: <c:out value="${budget.vendor}"></c:out></h6>
				<p>Amount: $<c:out value="${budget.amount}"></c:out></p>
				<p> Description: <c:out value="${budget.description}"></c:out></p>
			
			</div>

		</div>
		


</body>
</html>