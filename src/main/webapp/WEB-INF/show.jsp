<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World!</h1>
	
	<h1><c:out value="${book.name}"></c:out></h1>
	<p><c:out value="${book.id}"></c:out></p>
	
	<form:form action="/delete/book/${book.id}" method="POST">
	
		<button type="submit">delete this book!</button>
	
	</form:form>
	
	<a href="/edit/book/${book.id}">Edit this book!</a>
</body>
</html>