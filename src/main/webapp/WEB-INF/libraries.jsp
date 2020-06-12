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
	<h1>Create a library!</h1>
	<a href="/">Go back</a>
	
	<form:form action="/library" method="POST" modelAttribute="library">
		<div>
			<p>Name:</p>
			<form:label path="name"></form:label>
			<p><form:errors path="name"></form:errors></p>
			<form:input path="name"></form:input>
		</div>
		<div>
			<p>Location:</p>
			<form:label path="location"></form:label>
			<p><form:errors path="location"></form:errors></p>
			<form:input path="location"></form:input>
		</div>
		<p>
			<button type="submit">Create library!</button>
		</p>
	</form:form>
	
	<c:forEach items="${libraries}" var="library">
		<br>
		<p>name: <c:out value="${library.name}"></c:out></p>
		<p>location: <c:out value="${library.location}"></c:out></p>
		<form action="delete/library/${library.id}" method="POST">
			<button type="submit">Delete Library</button>
		</form>
	</c:forEach>
</body>
</html>