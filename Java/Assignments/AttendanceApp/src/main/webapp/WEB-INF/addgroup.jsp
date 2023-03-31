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
<title>Attendance Application | Create Group</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="wrapper">	
<!--Side Bar  -->
<div class="sidebar">
    <div class="flex-nowrap sidebar-content">
        <div class="bg-dark">
            <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
                <!--  <a href="" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">-->
                   <!--  <span class="fs-5 d-none d-sm-inline">Attendance App</span> -->
                <!-- </a>-->
                <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
                    <li class="nav-item">
                        <a href="#" class="nav-link align-middle px-0">
                            <i class="fs-4 bi-house"></i> <span class="ms-1 d-none d-sm-inline">Dashboard</span>
                        </a>
                    </li>
               		<li>
                      <a href="#submenu1" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                          <i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline">Groups</span> </a>
                      <ul class="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">
                         <c:forEach var="group" items="${Groups}">
	                          <li class="w-100">
	                              <a href="/admin/group/${group.id}" class="nav-link px-0">  <c:out value="${group.name }"></c:out> </a>
	                          </li>
	                      </c:forEach>
                      </ul>
                    </li>      
                </ul>
            </div>
        </div>
    </div>
</div>

<!-- Main   -->
<div class="main">
	<!-- Navigation Bar  -->
	<nav class="navbar navbar-expand-lg bg-body-tertiary bg-primary">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="/admin/dashboard">Attendance Application</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo02" aria-controls="navbarTogglerDemo02" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarTogglerDemo02">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="#">Link 1</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="#">Link 2</a>
	        </li>
	        <li>
	        
	        
	        </li>

	      </ul>
	      <div class="dropdown me-auto">
                    <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="https://github.com/mdo.png" alt="hugenerd" width="30" height="30" class="rounded-circle">
                        <span class="d-none d-sm-inline mx-1"><c:out value="${currentUser.firstName}"></c:out></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-dark text-small text-white shadow" aria-labelledby="dropdownUser1">
                        <li><a class="dropdown-item" href="#">New Group...</a></li>
                        <li><a class="dropdown-item" href="#">Settings</a></li>
                        <li><a class="dropdown-item" href="#">Profile</a></li>
                        <li>
                            <hr class="dropdown-divider">
                        </li>
                        <li class="nav-item">
				       	<form id="logoutForm" method="POST" action="/logout">
					        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					        <input type="submit" class="dropdown-item" value="Logout!" />
				    	</form>
				        </li>
                    </ul>
                </div>

	    </div>
	  </div>
	</nav>
	<!--Content -->
	<main class="content">
		<div class="container-fluid p-0">
			<div class="row mb-2 mb-xl-3">
				<div class="col-auto d-none d-sm-block">
					<h3>Create a Group</h3>
				</div>
			</div>
		</div>
		<div class="col-6">
		<form:form action="/admin/create/group" method="post" modelAttribute="newGroup">
		<%-- <form:hidden value="${user.id}" path="user"/> --%>
			<div>
				<form:label path="name"  class="form-label">Name:</form:label>
				<form:errors path="name" class="text-danger" />
				<form:input type="text" path="name" class="form-control"/>
			</div>
			
			<div>
				<form:select path="groupleader" class="form-select" id="">
				<c:forEach var="user" items="${groupleader}">
					<option value="${user.id }"><c:out value="${user.firstName }"></c:out></option>	
				</c:forEach>
				</form:select>
			</div>
			
			<input type="submit"  value="create Group"  class="btn-primary my-2" />
			
		</form:form>
		</div>
	</main>
</div> 

<!--Footer  -->

  <footer class="bg-primary fixed-bottom">
    <ul class="nav justify-content-center ">
      <li class="nav-item "><a href="#" class="nav-link px-2 text-white">Home</a></li>
      <li class="nav-item "><a href="#" class="nav-link px-2 text-white">Features</a></li>
      <li class="nav-item "><a href="#" class="nav-link px-2 text-white">Pricing</a></li>
      <li class="nav-item "><a href="#" class="nav-link px-2 text-white">FAQs</a></li>
      <li class="nav-item "><a href="#" class="nav-link px-2 text-white">About</a></li>
    </ul>
    <p class="mb-0 text-center text-white">&copy; 2023 Timothy Singleton, Inc</p>
  </footer>
</div>
</body>
</html>