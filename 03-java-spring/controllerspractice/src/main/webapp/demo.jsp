<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
    </head>
<body>
    <h1>Hello World</h1>
    <% for(int i=0; i<5;i++) {%>
    	<h1><%= i %></h1>
    <% } %>
    
    <p>The time is: <%= new Date() %></p>
    
    <% String test = request.getParameter("name"); %>
    <h1><%= test %></h1>
</body>
</html>