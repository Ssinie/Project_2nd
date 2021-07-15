<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>qform02</h1>
<h3>qform01 -> 혈액순환.</h3>

<form action = "/Project_2nd/question/qForm03.do" method ="post">
	<c:forEach var = "question" items = "${qSelect}">
		${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents" value = "${question.contents01}">${question.contents01}<br/>
			<input type = "radio" name = "contents" value = "${question.contents02}">${question.contents02}<br/>
			<input type = "radio" name = "contents" value = "${question.contents03}">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<input type = "submit" value = "다음">
</form>