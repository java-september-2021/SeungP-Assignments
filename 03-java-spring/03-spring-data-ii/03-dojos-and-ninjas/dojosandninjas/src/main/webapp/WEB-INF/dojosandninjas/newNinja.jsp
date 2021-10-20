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
<link rel="stylesheet" href="/css/newDojoStyles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<h1>New Ninja</h1>
	<form:form action="/ninjas/new" method="POST" modelAttribute="ninja">
		<div id="formContainer">
			<div id="form">
				<div class="newDojoForm">
					<form:label path="dojo">Dojo: </form:label>
					<form:select path="dojo">
						<c:forEach items="${dojos}" var="dojo">
							<option value="${dojo.id}">
								${dojo.name}
							</option>
						</c:forEach>
					</form:select>
				</div>
				<div class="formError">
					<form:errors path="dojo" />
				</div>
				
				<div class="newDojoForm">
					<form:label path="firstName">First Name: </form:label>
					<form:input path="firstName" />
				</div>
				<div class="formError">
					<form:errors path="firstName" />
				</div>
				
				<div class="newDojoForm">
					<form:label path="lastName">Last Name: </form:label>
					<form:input path="lastName" />
				</div>
				<div class="formError">
					<form:errors path="lastName" />
				</div>
				
				<div class="newDojoForm">
					<form:label path="age">Age: </form:label>
					<form:input type="number" path="age" />
				</div>
				<div class="formError">
					<form:errors path="age" />
				</div>
				
				<div class="newDojoForm">
					<input type="submit" value="Submit" />
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>