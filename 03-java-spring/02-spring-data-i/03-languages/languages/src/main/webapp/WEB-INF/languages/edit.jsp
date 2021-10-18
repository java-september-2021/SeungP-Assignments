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
<link rel="stylesheet" href="/css/indexStyles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row text-end offset-9">
			<div class="col editPage">
				<a href="/languages">Dashboard</a>
			</div>
			<div class="col editPage">
				<form action="/languages/${language.id}" method="post">
					<input type="hidden" name="_method" value="delete"> 
					<a href="" onclick="this.closest('form').submit();return false;">Delete</a>
				</form>
			</div>
		</div>
		
	</div>
	
	<form:form action="/languages/${language.id}" method="post" modelAttribute="language">
		<input type="hidden" name="_method" value="put">
		<div id="formContainer">
			<div id="form">
				<div class="newLanguageForm">
					<form:label path="name">Name: </form:label>
					<form:input path="name" />
				</div>
				<div class="formError">
					<form:errors path="name" />
				</div>

				<div class="newLanguageForm">
					<form:label path="creator">Creator: </form:label>
					<form:input path="creator" />
				</div>
				<div class="formError">
					<form:errors path="creator" />
				</div>

				<div class="newLanguageForm">
					<form:label path="currentVersion">Current Version: </form:label>
					<form:input path="currentVersion" />
				</div>
				<div class="formError">
					<form:errors path="currentVersion" />
				</div>

				<div class="newLanguageForm">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>