<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey Index</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/styles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<form method="POST" action="/submit">
			<div class="row">
				<div class="col">
					<label>Your name: </label>
					<input type="text" name="name">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>Dojo Location: </label> 
					<select name="location">
						<option value="San Jose">San Jose</option>
						<option value="Oakland">Oakland</option>
						<option value="Online">Online</option>
					</select>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label>Favorite Language: </label>
					<select name="language">
                    	<option value="Javascript">Javascript</option>
                    	<option value="CSS">CSS</option>
                    	<option value="Python">Python</option>
                	</select>
				</div>
			</div>
			<div class="row">
				<div class="col" id="comment">
					<label>Comments: </label>
					<input type="text" name="comments" id="commentBox">
					
					
				</div>
			</div>
			<div class="row">
				<div class="col" id="submit">
					<input type="submit" value="Submit">
				</div>
			</div>
		</form>
	</div>
</body>
</html>