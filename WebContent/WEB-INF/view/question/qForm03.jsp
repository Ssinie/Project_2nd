<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>qForm03</h1>
<h3>qform01 -> 소화.</h3>

<form action = "/Project_2nd/question/qForm12.do" method ="post">
	<c:forEach var = "question" items = "${qSelect03}">
		${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents" value = "1">${question.contents01}<br/>
			<input type = "radio" name = "contents" value = "2">${question.contents02}<br/>
			<input type = "radio" name = "contents" value = "3">${question.contents03}<br/>
			<input type = "radio" name = "contents" value = "4">${question.contents04}<br/>
			<input type = "radio" name = "contents" value = "5">${question.contents05}<br/>
		</c:if>
	</c:forEach>
	<input type = "button" value = "이전" onclick = "history.back();"/>
	<input type = "submit" value = "다음">
</form>