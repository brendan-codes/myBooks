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

	<h1>Create a book!</h1>
	<a href="/library">Create a library</a> | <a href="/author">Create an author!</a>
	
	<form:form action="/book" method="POST" modelAttribute="bookObject">
		<div>
			<form:errors path="bookObject.*"></form:errors>
		</div>
		<p>Name:</p>
		<div>
			<form:label path="name"></form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</div>
		<p>Library:</p>
		<select name="" id="">
			<option value="" disabled>Library</option>
		</select>
		<p>
			<button type="submit">Create book!</button>
		</p>
	</form:form>
	<c:forEach items="${allBooks}" var="books">
		<p><c:out value="${books.id}"></c:out></p>
		<p><c:out value="${books.name}"></c:out></p>
		<a href="/book/${books.id}">Show this book!</a>
	</c:forEach>
	
</body>
</html>