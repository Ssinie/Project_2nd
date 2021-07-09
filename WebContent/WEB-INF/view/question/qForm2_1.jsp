<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>혈액순환.</h1>

<form action = "/Project_2nd/question/qInsert2.do" method = "post">
	상처: <input type = "radio" name = "bld" value = "1"/><br/>
	저림: <input type = "radio" name = "bld" value = "2"/><br/>
	잇몸 붓기: <input type = "radio" name = "bld" value = "3"/><br/>
	걱정: <input type = "radio" name = "bld" value = "4"/><br/>
	<input type = "submit" value = "다음"/>
</form>