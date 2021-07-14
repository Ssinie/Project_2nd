<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>qform01</h1>

<form action = "/Project_2nd/Insert.do" method = "post">
	<c:forEach var = "question" items = "${list}">
		${question.title}
	</c:forEach>
</form>