<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>신상정보.</h1>

<form action = "/Project_2nd/question/pInsert.do" method = "post">
	nick: <input type = "text" name = "nick"><br/>
	age: <input type = "text" name = "age"><br/>
	weight: <input type = "text" name = "weight"><br/>
	height: <input type = "text" name = "height"><br/>
	gender: m<input type = "radio" name = "gender" value = "male">
	w<input type = "radio" name = "gender" value = "female"><br/>
	<input type = "submit" value = "다음">
</form>