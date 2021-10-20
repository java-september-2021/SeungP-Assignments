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
<link rel="stylesheet" href="/css/questionsStyles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Questions Dashboard</h1>
		<div class="row" id="headers">
			<div class="col head">Question</div>
			<div class="col head">Tags</div>
		</div>
		
		<c:forEach items="${questions}" var="question">
			<div class="row dojoRow">
				<div class="col"><a href="/questions/${question.id}"><c:out value="${question.questionText}"/></a></div>
				<div class="col">
					<c:forEach items="${question.tags}" var="tag">
						<c:out value="${tag.subject}"/>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
	</div>
	
	<a href="/questions/new">New Question</a>
</body>