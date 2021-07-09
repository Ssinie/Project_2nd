<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>요즘 느끼는 기분은 어떠하옵니까?</h1>

<form action = "/Project_2nd/question/qForm2.do" method = "post">
	혈액순환: <input type = "radio" name = "intr" value = "1"/><br/>
	소화: <input type = "radio" name = "intr" value = "2"/><br/>
	피부: <input type = "radio" name = "intr" value = "3"/><br/>
	눈: <input type = "radio" name = "intr" value = "4"/><br/>
	두뇌활동: <input type = "radio" name = "intr" value = "5"/><br/>
	피로감: <input type = "radio" name = "intr" value = "6"/><br/>
	관절: <input type = "radio" name = "intr" value = "7"/><br/>
	모발: <input type = "radio" name = "intr" value = "8"/><br/>
	면역: <input type = "radio" name = "intr" value = "9"/><br/>
	없음: <input type = "radio" name = "intr" value = "0"/><br/>
	<input type = "submit" value = "다음"/>
</form>