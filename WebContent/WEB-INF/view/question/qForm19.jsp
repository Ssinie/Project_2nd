<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>qForm19</h1>
<h1>건강검진.</h1>

<form action = "/Project_2nd/question/qForm20.do" method ="post">
	<c:forEach var = "question" items = "${qSelect19}">
		${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents" value = "1">${question.contents01}<br/>
			<input type = "radio" name = "contents" value = "2">${question.contents02}<br/>
			<input type = "radio" name = "contents" value = "3">${question.contents03}<br/>
			<input type = "radio" name = "contents" value = "4">${question.contents04}<br/>
		</c:if>
	</c:forEach>
	<input type = "button" value = "이전" onclick = "history.back();"/>
	<input type = "submit" value = "다음">
</form>