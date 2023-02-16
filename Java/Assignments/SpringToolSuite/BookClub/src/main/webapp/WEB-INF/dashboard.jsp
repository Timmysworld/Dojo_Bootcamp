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
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	<meta charset="UTF-8">
	<title>The Book Club | Dashboard</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h1>Welcome <c:out value="${user.firstName}"></c:out> </h1>
				<p>Books from everyones shelves</p>
				<div>
					<a href="/book/new" class="btn btn-primary" >Add to my shelf</a>
					<a href="/logout" class="btn btn-primary">logout</a>
				</div>
				
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table  table-striped">
					<thead>
						<tr>
							<th>Id</th>
							<th>Title</th>
							<th>Author Name</th>
							<th>Posted By</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<tr>
								<td><c:out value="${book.id }"></c:out></td>
								<td><a href="/book/${book.id}"><c:out value="${book.title }"></c:out></a></td>
								<td><c:out value="${book.author }"></c:out></td>
								<td><c:out value="${book.user.firstName }"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		
		
	
	</div>

</body>
</html>