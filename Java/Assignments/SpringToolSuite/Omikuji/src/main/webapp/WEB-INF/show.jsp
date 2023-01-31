<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">

<meta charset="UTF-8">
<title>Your Omikuji</title>
</head>
<body>

	<div class="wrapper">
	
		<div class="heading">
			<h2>Here's your Omikuji</h2>
		</div>
		
		<div class="message-box">
			<p> In <c:out value="${number}"/> years
			you will live in <c:out value="${city}"/> 
			with <c:out value="${name}"/> as your roommate, 
			selling <c:out value="${hobby}"/> for a living. 
			The next time you see a <c:out value="${thing}"/>, 
			you will have good luck. Also, 
			<c:out value="${message}"/>.
			</p>
		</div>
		
		<div class="btn">
			<button> <a href="/omikuji/form"> Go Back </a> </button>
		</div>
	
	</div>


</body>
</html>