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
	<title>Travel Expense: Dashboard</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>Expense Dashboard:</h1>
				<a href="/expenses/add" class="btn btn-primary" >Add An Expense</a>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table  table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Expense</th>
							<th>Vendor</th>
							<th>Amount</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="expense" items="${budget}">
							<tr>
								<td><c:out value="${expense.id}"></c:out></td>
								<td><a href="/expenses/details/${expense.id}"><c:out value="${expense.expense}"></c:out></a></td>
								<td><c:out value="${expense.vendor}"></c:out></td>
								<td>$<c:out value="${expense.amount}"></c:out></td>
								<td><a href="/expenses/edit/${expense.id}" class="btn btn-link">Edit</a> | <a href="/expenses/${expense.id}" class="btn btn-link">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>