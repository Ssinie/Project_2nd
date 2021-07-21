<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>qResult.</h1>

<div id = result>
	<form action = "pValue.do" method = "post">
		필요 영양소:
		추천 영양제:<br/>
		nick: ${param.nick}<br/>
		age: ${param.age}<br/>
		
		weight: ${param.weight}<br/>
		height: ${param.height}<br/>
		gender: ${param.gender}<br/>
		c01: ${param.contents}<br/>
		c02: ${param.contents02}<br/>
		c03: ${param.contents03}<br/>
		c04: ${param.contents04}<br/>
		c05: ${param.contents05}<br/>
		c06: ${param.contents06}<br/>
		c07: ${param.contents07}<br/>
		c08: ${param.contents08}<br/>
		c09: ${param.contents09}<br/>
		<!--c10: ${param.contents10}<br/>-->
		<!--c11: ${param.contents11}<br/>-->
		<!--c10: ${param.contents12}<br/>-->
	</form>
</div>

<div id = result02>
	<form method = "post">
		${param.nick}님이 제일 필요한 영양소는 ${param.contents01} 입니다.
	</form>
</div>
	
	<%--
		String nick = request.getParameter("nick");
		out.println("nick : <b>"+nick+"</b><br>");
		
		String contents01 = request.getParameter("contents01");
		out.println("contents01 : <b>"+contents01+"</b><br>");
	--%>