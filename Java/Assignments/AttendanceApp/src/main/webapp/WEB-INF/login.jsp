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
<title>The Book Club | Log In</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css">
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<section class="bg-dark  login_section" >
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
            
            <form action="/login" method="post"  class="col-xl-6">
            
            <c:if test="${logoutMessage != null}">
	        	<c:out value="${logoutMessage}"></c:out>
	    	</c:if>
	    	
	    	<c:if test="${errorMessage != null}">
		        <c:out value="${errorMessage}"></c:out>
		    </c:if>
	    	
	    	
              <div class="card-body p-md-5 text-black">
                <h3 class="mb-5 text-uppercase">Log In</h3>

                <div class="form-outline mb-4">
                  <input type="text" name="username" id="form3Example8" class="form-control form-control-lg" />
                  <%-- <form:errors path="email" class="text-danger" /> --%>
                  <label class="form-label" for="username form3Example8">Username</label>
                </div>
  
                <div class="form-outline mb-4">
                  <input type="password" name="password" id="form3Example9" class="form-control form-control-lg" />
                  <%-- <form:errors path="password" class="text-danger" /> --%>
                  <label class="form-label" for="password form3Example9">Password</label>
                </div>
                
                <div class="d-flex justify-content-end pt-3">
                 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                  <button type="button" class="btn btn-light btn-lg">Reset all</button>
                  <input type="submit"  value="Login!"  class="btn btn-warning btn-lg ms-2" />
                </div>

              </div>
              
            </form>
            
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>
</html>