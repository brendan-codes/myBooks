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
	<h1>Create an Author!</h1>
	<a href="/">Go back</a>
	
	<form:form action="/author" method="POST" modelAttribute="authorObject">
		<div>
			<p>Name:</p>
			<form:label path="name"></form:label>
			<p><form:errors path="name"></form:errors></p>
			<form:input path="name"></form:input>
		</div>
		<p>
			<button type="submit">Create author!</button>
		</p>
	</form:form>
	
	<c:forEach items="${authors}" var="author">
		<br>
		<p>name: <c:out value="${author.name}"></c:out></p>
		<form action="delete/author/${author.id}" method="POST">
			<button type="submit">Delete Author</button>
		</form>
	</c:forEach>
</body>
</html>