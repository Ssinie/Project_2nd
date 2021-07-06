<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>question Form.</h1>
<form action = "qPro.do" method = "post">
	닉네임: <input type = "text" name = "nick"/><br/>
	나이: <input type = "text" name = "age"/><br/>
	몸무게: <input type = "text" name = "weight"/><br/>
	키: <input type = "text" name = "height"/><br/>
	성별: <input type = "radio" value = "남자"/>
	<input type = "radio" value = "여자"/>
</form>