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
<link rel="stylesheet" href="/css/answerStyles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>${thisQuestion.questionText}</h1>
		<h3>Tags:</h3>
		<c:forEach items="${thisQuestion.tags}" var="tag">
			<h6>
				<c:out value="${tag.subject}" />
			</h6>
		</c:forEach>

		<div class="row" id="headers">
			<div class="col head">Answers</div>
		</div>
		<c:forEach items="${thisQuestion.answers}" var="answer">
			<div class="row dojoRow">
				<div class="col">
					<c:out value="${answer.answerText}" />
				</div>
			</div>
		</c:forEach>
	</div>
	
	<form:form action="/questions/${thisQuestion.id}/new" method="post" modelAttribute="answer">
				<div id="formContainer">
					<div id="form">
					<h2>Add your answer: </h2>
						<div class="newQuestionForm">
							<form:label path="answerText">Answer: </form:label>
							<form:input type="textbox" path="answerText" />
						</div>
						<div class="formError">
							<form:errors path="answerText" />
						</div>
						
						
						<div class="newQuestionForm">
							<input type="submit" value="Submit" />
						</div>
					</div>
				</div>
			</form:form>
</body>