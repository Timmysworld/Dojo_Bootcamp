<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
<meta charset="UTF-8">
<title> The Fruit Loops  </title>
</head>
<body>
	<div class=" wrapper">
	<h1> Fruit Store </h1>
	<table class= "table table-striped">
		<thead>
		<tr>
			<th scope="col">Name</th>
			<th scope="col">Price</th>
		</tr>
		</thead>
		<tbody>
		
		<!--LOOPS THROUGH ITEMS THAT IS SET TO VARIABLE FRUIT  -->
		<c:forEach var="fruit" items="${itemController}">
		<tr>
		
			<td><c:out value="${fruit.name}"/></td>
			<td><c:out value="${fruit.price}"/></td>
		
		</tr>
		</c:forEach>
		
		</tbody>
	</table>
		
	
	</div>


</body>
</html>