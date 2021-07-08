<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>question Form.</h1>

<form action = "/Project_2nd/question/qInsert.do" method = "post">
	닉네임: <input type = "text" name = "nick" required = "true"/><br/>
	나이: <input type = "text" name = "age" min = 10 max = 110 required = "true"/><br/>
	몸무게: <input type = "text" name = "weight" required = "true"/><br/>
	키: <input type = "text" name = "height" required = "true"/><br/>
	성별: <input type = "radio" name = "gender" value = "male" required = "true"/>남자
	<input type = "radio" name = "gender" value = "female" required = "true">여자
	<input type = "submit" value = "입력"/>
</form>