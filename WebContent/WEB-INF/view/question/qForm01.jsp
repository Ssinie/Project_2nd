<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>qform01</h1>

<form action = "/Project_2nd/question/qForm02.do" method = "post">
	<c:forEach var = "question" items = "${qSelect}">
		${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents" value = "${question.contents01}">${question.contents01}<br/>
			<input type = "radio" name = "contents" value = "${question.contents02}">${question.contents02}<br/>
			<input type = "radio" name = "contents" value = "${question.contents03}">${question.contents03}<br/>
			<input type = "radio" name = "contents" value = "${question.contents04}">${question.contents04}<br/>
			<input type = "radio" name = "contents" value = "${question.contents05}">${question.contents05}<br/>
			<input type = "radio" name = "contents" value = "${question.contents06}">${question.contents06}<br/>
			<input type = "radio" name = "contents" value = "${question.contents07}">${question.contents07}<br/>
			<input type = "radio" name = "contents" value = "${question.contents08}">${question.contents08}<br/>
			<input type = "radio" name = "contents" value = "${question.contents09}">${question.contents09}<br/>
			<input type = "radio" name = "contents" value = "${question.contents10}">${question.contents10}<br/>
		</c:if>
	</c:forEach>
	<input type = "submit" value = "다음">
</form>