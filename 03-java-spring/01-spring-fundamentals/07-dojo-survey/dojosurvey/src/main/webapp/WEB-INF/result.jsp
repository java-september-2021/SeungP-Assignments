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
<link rel="stylesheet" href="/css/resultStyles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col">
				<h3>Submitted info</h3>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<p>Name: </p>
				<p><c:out value="${name}"></c:out></p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<p>Location: </p>
				<p><c:out value="${location}"></c:out></p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<p>Favorite Language: </p>
				<p><c:out value="${language}"></c:out></p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<p>Comments: </p>
				<p><c:out value="${comments}"></c:out></p>
			</div>
		</div>
		<div class="row">
			<div class="col">
				<a href="/">
   					<button>Go Back</button>
				</a>
			</div>
		</div>
	</div>
	
</body>
</html>