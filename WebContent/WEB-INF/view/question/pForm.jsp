<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>신상정보.</h1>

<form action = "/Project_2nd/question/pInsert.do" method = "post">
	nick: <input type = "text" name = "nick" required><br/>
	age: <input type = "number" min = "10" max = "120" name = "age" required><br/>
	height: <input type = "number" min = "100" max = "250" name = "height" value = "h" required><br/>
	weight: <input type = "number" min = "30" max = "300" name = "weight" value = "w" required><br/>
	gender: m<input type = "radio" name = "gender" value = "male" required>
	w<input type = "radio" name = "gender" value = "female" required><br/>
	<br/>
	<input type = "submit" value = "다음">
</form>