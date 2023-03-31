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
<title>Attendance App | Register </title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<section class="h-100 bg-dark">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card card-registration my-4">
          <div class="row g-0">
            <div class="col-xl-6 d-none d-xl-block">
              <img src="../images/grouppic.jpeg"
                alt="Some photo here" class="img-fluid"
                style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
            </div>
            
            <form:form action="/register" method="post" modelAttribute="newUser" class="col-xl-6">
              <div class="card-body p-md-5 text-black">
                <h3 class="mb-5 text-uppercase">Register</h3>

                <div class="row">
                  <div class="form-outline mb-4">
	                  <form:input type="username" path="username" id="form3Example8" class="form-control form-control-lg" />
	                  <form:errors path="username" class="text-danger" />
	                  <form:label path="username" class="form-label" for="form3Example8">Username</form:label>
	              </div>
                  <div class="col-md-6 mb-4">
                    <div class="form-outline">
                      <form:input type="text" path="firstName" id="form3Example1m" class="form-control form-control-lg" />
                      <form:errors path="firstName" class="text-danger" />
                      <form:label  path="firstName" class="form-label" for="form3Example1m">First name</form:label>
                    </div>
                  </div>
                  <div class="col-md-6 mb-4">
                    <div class="form-outline">
                      <form:input type="text" path="lastName" id="form3Example1n" class="form-control form-control-lg" />
                      <form:errors path="lastName" class="text-danger" />
                      <form:label path="lastName" class="form-label" for="form3Example1n">Last name</form:label>
                    </div>
                  </div>
                </div>

                <div class="form-outline mb-4">
                  <form:input type="email" path="email" id="form3Example8" class="form-control form-control-lg" />
                  <form:errors path="email" class="text-danger" />
                  <form:label path="email" class="form-label" for="form3Example8">Email</form:label>
                </div>
  
                <div class="form-outline mb-4">
                  <form:input type="password" path="password" id="form3Example9" class="form-control form-control-lg" />
                  <form:errors path="password" class="text-danger" />
                  <form:label path="password" class="form-label" for="form3Example9">Password</form:label>
                </div>
                
                <div class="form-outline mb-4">
                  <form:input type="password" path="confirmPassword" id="form3Example9" class="form-control form-control-lg" />
                  <form:errors path="confirmPassword" class="text-danger" />
                  <form:label path="confirmPassword" class="form-label" for="form3Example9">Confirm Password</form:label>
                </div>
 
                <div class="d-flex justify-content-end pt-3">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                  <button type="button" class="btn btn-light btn-lg">Reset all</button>
                  <input type="submit"  value="Register"  class="btn btn-warning btn-lg ms-2" />
                </div>

              </div>
              
            </form:form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
</section>

</body>
</html>