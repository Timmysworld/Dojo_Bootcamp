<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--For: c:out, c:forEach, etc...  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration | Dashboard</title>

<!-- For any Bootstrap that uses JS or jQuery-->
<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
</head>
<body>

<div class="container">
	
		<h1>Welcome <c:out value="${userName}">!</c:out></h1>
		<p>This is your dashboard nothing to see just yet</p>
	
	<a href="/logout" class="btn btn-primary">Log Out</a>
</div>

</body>
</html>