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
<title>The Book Club | Edit Book</title>

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
				<a href="/dashboard" class="btn btn-primary">Book Shelf</a>
				<%-- <c:out value="${userId}"/> --%>
				<form:form action="/book/${books.id}/edit" method="post" modelAttribute="books">
					<form:hidden value="${user.id}" path="user"/>
					<div>
						<form:label path="title"  class="form-label">Title:</form:label>
						<form:errors path="title" class="text-danger" />
						<form:input type="text" path="title" class="form-control"/>
					</div>
					<div>
						<form:label path="author"  class="form-label">Author:</form:label>
						<form:errors path="author" class="text-danger" />
						<form:input type="text" path="author" class="form-control" />
				   </div>
				   <div>
						<form:label path="thoughts"  class="form-label">Thoughts:</form:label>
						<form:errors path="thoughts" class="text-danger" />
						<form:textarea row="5" col="10"  path="thoughts" class="form-control" />
					</div>
					<input type="submit"  value="update entry"  class="btn-primary" />
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>