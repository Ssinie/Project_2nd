<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>설문 결과.</h1>

<div id = result class = "container" style = "display:block;">
	<form method = "post">
		<br/>
		나이: ${param.age}세<br/>
		몸무게: ${param.weight}kg<br/>
		신장: ${param.height}cm<br/>
		성별: <c:if test = "${param.gender == 'male'}">남성</c:if><c:if test = "${param.gender == 'female'}">여성</c:if><br/>
		<br/>
		${nick} 님에게 추천 드리는 영양제는...<br/>
		<br/>
		<c:forEach var = "dto" items = "${nameDto}" begin = "0" end = "9" step = "1">
			<img src = "${dto.imgurl}"/><br/>
			${dto.name}<br/>
		</c:forEach>
		<br/>
		<input type = "button" value = "메인페이지 이동" onClick="location.href='http://localhost:8080/Project_2nd/main.ns'"> 
	</form>
</div>