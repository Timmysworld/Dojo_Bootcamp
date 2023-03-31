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
<title>Attendance App | Edit Group</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

<div class="container pt-5">
		<div class="row">
			<div class="col-6">
				<h1>Change your entry</h1>
				<a href="/admin/dashboard" class="btn btn-primary">Admin Dashboard</a>
				<%-- <c:out value="${userId}"/> --%>
				<form:form action="/group/${groups.id}/edit" method="post" modelAttribute="groups">
				<%-- 	<form:hidden value="${user.id}" path="user"/> --%>
					<div>
						<form:label path="name"  class="form-label">Name:</form:label>
						<form:errors path="name" class="text-danger" />
						<form:input type="text" path="name" class="form-control"/>
					</div>
					
					<div>
						<form:label path="groupleader"  class="form-label">Group Leader:</form:label>
						<form:select path="groupleader" class="form-select" id="">
						<c:forEach var="user" items="${groupleader}">
							<option value="${user.id }"><c:out value="${user.firstName }"></c:out></option>	
						</c:forEach>
						</form:select>
				 	</div>

					<input type="submit"  value="update entry"  class="btn-primary my-2" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>