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
<title>The Book Club | Details </title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
	
		<div class="row">
			<div class="col-12">
				<h1><c:out value="${books.title}"/></h1>
				<a href="/dashboard" class="btn btn-primary">Book Shelf</a>
			</div>
		</div>
		<div>
			<h5><c:out value="${books.user.firstName}"/> read <c:out value="${books.title}"/> by <c:out value="${books.author}"/> </h5> 
			<p>Here are your thoughts!</p>
			<hr>
			<c:out value="${books.thoughts}"/>
			<hr>
		</div>
	
		<div>
			<c:if test="${userId == books.user.id}">
		      <a href="/book/${books.id}/edit" class="btn btn-primary">Edit</a> 
			  <a href="/book/${books.id}/delete" class="btn btn-primary">Delete</a>
			</c:if>
		</div>
	</div>
	
</body>
</html>