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
<title>Attendance App | Edit Member</title>

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
				<form:form action="/member/${member.id}/edit" method="post" modelAttribute="member">
					<input type="hidden" name="group_id" value="${groups.id}"/>
<%-- 					<h1><c:out value="${groups.id}"></c:out></h1> --%>
<%-- 					<h1><c:out value="${member.groups.id}"></c:out></h1>  --%>
					<div>
						<form:label path="fName"  class="form-label">First Name:</form:label>
						<form:errors path="fName" class="text-danger" />
						<form:input type="text" path="fName" class="form-control"/>
					</div>
					<div>
						<form:label path="lName"  class="form-label">Last Name:</form:label>
						<form:errors path="lName" class="text-danger" />
						<form:input type="text" path="lName" class="form-control"/>
					</div>
					<input type="submit"  value="update entry"  class="btn-primary my-2" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>