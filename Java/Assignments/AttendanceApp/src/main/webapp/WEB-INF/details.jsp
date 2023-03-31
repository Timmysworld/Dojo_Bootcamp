<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--For: c:out, c:forEach, etc...  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--For: FORM -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--For: rendering Errors on PUT routes  -->
<%@page isErrorPage = "true" %>
<!-- DATE -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance Application | Details </title>

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
	                              <a href="/group/${group.id}" class="nav-link px-0">  <c:out value="${group.name }"></c:out> </a>
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
                        <!-- <img src="https://github.com/mdo.png" alt="hugenerd" width="30" height="30" class="rounded-circle"> -->
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
                        <!-- <li><a class="dropdown-item" href="#">Sign out</a></li> -->
                    </ul>
                </div>

	    </div>
	  </div>
	</nav>
	<main class="content">
		<div class="container-fluid p-0">
			<div class="row mb-2 mb-xl-3 ">
				<div class="col-12 d-none d-sm-block ">
					<h3>Dashboard</h3>
					<div>
						<h3><c:out value="${groups.name }"></c:out></h3>
						<p style="color: black"> Group Leader:  <c:out value="${groups.groupleader.firstName }"></c:out></p>
					</div>
					<%-- <h1><c:out value="${groups.id}"></c:out></h1> --%>
					
					
					<div>
						<a href="/group/${groups.id}/edit" class="btn btn-primary">Edit</a> 
			  			<a href="/group/${groups.id}/delete" class="btn btn-primary">Delete</a>
					</div>
					
				</div>
			</div>
			
		  <div class="row">
		  <div class="col-12 col-lg-8 d-flex py-2">
		  	<img src="http://via.placeholder.com/759x360" alt="" />
		  </div>
		  
		  <div class="col-12 col-lg-4 d-flex py-2">
		  	<div class="card flex-fill w-100">
		  		<div class="card-header d-flex justify-content-between">
		  			<h5 class="card-title mb-0"> Add Members</h5> 
		  		</div>
		  	
		  	<div class="card-body">
				<form:form action="/member/add" method="post" modelAttribute="newMember">
					<input type="hidden" name="group_id" value="${groups.id}"/>
					<div>
						<form:label path="fName">First Name:</form:label>
	  					<form:input path="fName" class="form-control me-2" type="text" placeholder="" aria-label="Add a Member"/>
					</div>
					<div>
						<form:label path="lName">Last Name:</form:label>
	  					<form:input path="lName" class="form-control me-2" type="text" placeholder="" aria-label="Add a Member"/>
					</div>
					
				<input type="submit" value="add member" class="my-2" />	
				</form:form>	
		  	</div>
		  </div>
		  
		  </div>

		  </div>
		  
		  <div class="row pb-2 mb-4">
		  <div class="col-12 col-lg-12 d-flex py-2">
		  	<div class="card flex-fill w-100">
		  		<div class="card-header d-flex justify-content-between">
		  			<h5 class="card-title mb-0">Members</h5>
		  			
		  			<!--DATE PICKER  -->
		  			<div class="date">
		  				<jsp:useBean id="now" class="java.util.Date" />
					    <fmt:formatDate value="${now}" pattern="yyyy-MM-dd" var="formattedDate"/>
					    
		  				<label for="date">Today:</label>
		  				<input type="date" name="date" value="${formattedDate}">
		  			</div>
		  			
		  		</div>
		  	
		  	<div class="card-body" >
		  		<table class="table mb-0">
		  			<thead>
		  			<tr>
		  				<th>First Name</th>
		  				<th>Last Name</th>
		  				<th>Attendance</th>
		  				<th>Actions</th>
		  			</tr>
		  			</thead>
		  				<tbody>
		  				<c:forEach var="member" items="${groups.members}"> 
	
		  					<tr>
		  					
				  				<td><c:out value="${member.fName}"></c:out></td>
				  				<td><c:out value="${member.lName}"></c:out></td>
				  			
				  				<td>
				  					<a href="/attendance/${attendance_id}/${member_id}/add" class="btn btn-primary">Here</a> |
				  					<a href="" class="btn btn-primary">Not Here</a> 
				  				</td>
				  				<td>
				  					<a href="/member/${member.id}/${groups.id}/edit">Edit</a> | 
				  					<a href="/member/${member.id}/delete">Delete</a>
				  				</td>
		  					</tr>
		  					</c:forEach>
		  				</tbody>
		  		</table>
		  	
		  	</div>
		  </div>
		  
		  </div>

		  </div>
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  

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