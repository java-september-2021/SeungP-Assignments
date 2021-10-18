<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>First JSP</title>
    
    <!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/app.js"></script>
</head>
<body>
    <h1>Hello World!</h1>
    <div class="container text-center">
    	<div class="row">
    		<!-- <div class="col bg-secondary text-light m-2"></div> -->
    		<div class="col-6 offset-3 bg-secondary text-light">
    			<c:out value="${name}"/>
    		</div>
    		
    	</div>
    </div>
    
</body>
</head>