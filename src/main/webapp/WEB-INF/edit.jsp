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
	<h1>Hello this is <c:out value="${book.name}"></c:out></h1>
	
	<form:form action="/edit/book/${book.id}" method="POST" modelAttribute="book">
		<div>
			<form:errors path="book.*"></form:errors>
		</div>
		<div>
			<form:label path="name"></form:label>
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</div>
		<p>
			<button type="submit">Edit book!</button>
		</p>
	</form:form>
</body>
</html>