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
	
	<form:form action="/book" method="POST" modelAttribute="bookObject">
		<div>
			<form:errors path="bookObject.*"></form:errors>
		</div>
		<div>
			<form:label path="name"></form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</div>
		<p>
			<button type="submit">Create book!</button>
		</p>
	</form:form>
	<c:forEach items="${allBooks}" var="books">
		<p><c:out value="${books.id}"></c:out></p>
		<p><c:out value="${books.name}"></c:out></p>
	</c:forEach>
	
</body>
</html>