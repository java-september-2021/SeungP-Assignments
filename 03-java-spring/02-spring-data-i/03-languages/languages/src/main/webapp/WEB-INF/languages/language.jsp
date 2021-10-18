<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/languageStyles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row text-end">
			<div class="col">
				<a href="/languages">Dashboard</a>
			</div>
		</div>
		<div class="row">
			<h3><c:out value="${language.name}"/></h3>
		</div>
		<div class="row">
			<h3><c:out value="${language.creator}"/></h3>
		</div><div class="row">
			<h3><c:out value="${language.currentVersion}"/></h3>
		</div>
		<div class="row">
			<a href="/languages/edit/${language.id}">Edit</a>
		</div>
		<div class="row">
			<form action="/languages/${language.id}" method="post">
				<input type="hidden" name="_method" value="delete"> 
				<a href="" onclick="this.closest('form').submit();return false;">Delete</a>
			</form>
		</div>
	</div>
</body>
</html>