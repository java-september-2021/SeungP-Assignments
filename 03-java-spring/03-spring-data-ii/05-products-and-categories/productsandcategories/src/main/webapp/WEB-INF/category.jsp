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
<link rel="stylesheet" href="/css/productStyles.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="row">
			<h1><c:out value="${category.name}"/></h1>
		</div>
		
		<div class="row">
			<div class="col mainContainer">
				<h3>Products: </h3>
				<c:forEach items="${categoryProducts}" var="product">
					<div class="row">- ${product.name}</div>
				</c:forEach>
			</div>
			
			<div class="col mainContainer">
				<form:form action="/categories/${category.id}" method="PUT" modelAttribute="product">
					<div id="formContainer">
						<div id="form">
							<form:label path="id">Add Product: </form:label>
							<form:select path="id">
								<c:forEach items="${nonIncludedProducts}" var="product">
									<option value="${product.id}">
										${product.name}
									</option>
								</c:forEach>
							</form:select>
							
							<div class="newProductForm">
								<input type="submit" value="Submit" />
							</div>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>