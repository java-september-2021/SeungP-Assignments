<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/dojoStyles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
		<div class="row" id="headers">
			<div class="col head">First Name</div>
			<div class="col head">Last Name</div>
			<div class="col head">Age</div>
		</div>
		
		<c:forEach items="${ninjas}" var="ninja">
			<div class="row dojoRow">
				<div class="col"><c:out value="${ninja.firstName}"/></div>
				<div class="col"><c:out value="${ninja.lastName}"/></div>
				<div class="col"><c:out value="${ninja.age}"/></div>
			</div>
		</c:forEach>
	</div>