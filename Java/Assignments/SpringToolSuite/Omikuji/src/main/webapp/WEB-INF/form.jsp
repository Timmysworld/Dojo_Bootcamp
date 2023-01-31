<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="UTF-8">
<title>Omikuji Form</title>
</head>
<body>
	
	<div class="wrapper">
		<div class="heading">
			<h2>Create an Omikuji</h2>
			<p> send  something nice to a friend</p>
		</div>

		<form class="form-box" action='/omikuji/show' method='post'>
			<label>Pick any number from 5 to 25:</label>
		    	<input class='numbox' type="number" name='number'>
			<label>Enter name of any city:</label>
		    	<input type='text' name='city'>
		    <label>Enter name of any real person:</label>
		    	<input type='text' name='name'>
		    <label>Enter professional endeavor or hobby:</label>
		    	<input type='text' name='hobby'>
		    <label>Enter any type of living thing:</label>
		    	<input type="text" name='thing'/>
		    <label>Say something nice to someone:</label>
		    	<textarea rows='5' cols='30' name="message"></textarea>
		    <p>Send and show a friend</p>
		       <input type='submit' value='Submit'>
    	</form>
	</div>
    

	

</body>
</html>