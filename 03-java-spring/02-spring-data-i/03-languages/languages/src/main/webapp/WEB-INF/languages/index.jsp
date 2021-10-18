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
<link rel="stylesheet" href="/css/indexStyles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row" id="headers">
			<div class="col head">Name</div>
			<div class="col head">Creator</div>
			<div class="col head">Version</div>
			<div class="col head">Actions</div>
		</div>
		
		<c:forEach items="${languages}" var="language">
			<div class="row languageRow">
				<div class="col"><a href="languages/${language.id}"><c:out value="${language.name}"/></a></div>
				<div class="col"><c:out value="${language.creator}"/></div>
				<div class="col"><c:out value="${language.currentVersion}"/></div>
				<div class="col d-flex justify-content-evenly">
					<form action="/languages/${language.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<a href="" onclick="this.closest('form').submit();return false;">Delete</a>
					</form>
					<a href="/languages/edit/${language.id}">Edit</a>
				</div>
			</div>
		</c:forEach>
	</div>
	<form:form action="/languages" method="post" modelAttribute="language">
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