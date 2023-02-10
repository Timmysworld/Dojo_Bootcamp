<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--For: c:out, c:forEach, etc...  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Village: All Ninjas</title>

	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
</head>
<body>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1> All Ninjas in <c:out value="${village.name}"/></h1>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>First Name</th>
								<th>Last Name</th>
								<th>age</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="ninja" items="${village.ninjas}">
								<tr>
									<td><c:out value="${ninja.firstName}"></c:out></td>
									<td><c:out value="${ninja.lastName}"></c:out></td>
									<td><c:out value="${ninja.age}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		
		</div>
</body>
</html>