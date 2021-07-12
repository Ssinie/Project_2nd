<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>지문 입력.</h1>

<form action = "/Project_2nd/question/qcInsert.do" method = "post">
	제목: <input type = "text" name = "title"/>
	내용: <input type = "text" name = "contents"/>
</form>