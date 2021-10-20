<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/newProductStyles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>New Category</h1>
	<form:form action="/categories/new" method="post" modelAttribute="category">
		<div id="formContainer">
			<div id="form">
				<div class="newProductForm">
					<form:label path="name">Name: </form:label>
					<form:input path="name" />
				</div>
				<div class="formError">
					<form:errors path="name" />
				</div>
				
				<div class="newProductForm">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>