<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>qResult.</h1>

<div id = result>
	<form method = "post" action = "aResult.do">
		<c:if test = "${pResult01.BSSH_NM != pResult02.BSSH_NM && pResult01.BSSH_NM != pResult03.BSSH_NM}">추천 영양제: ${pResult01.BSSH_NM}의</c:if>
		<c:if test = "${pResult01.PRDLST_NM != pResult02.PRDLST_NM && pResult01.PRDLST_NM != pResult03.PRDLST_NM}">${pResult01.PRDLST_NM} 입니다!</c:if><br/>
		<c:if test = "${pResult02.BSSH_NM != pResult01.BSSH_NM && pResult02.BSSH_NM != pResult03.BSSH_NM}">추천 영양제: ${pResult02.BSSH_NM}의</c:if>
		<c:if test = "${pResult02.PRDLST_NM != pResult01.PRDLST_NM && pResult02.PRDLST_NM != pResult03.PRDLST_NM}">${pResult02.PRDLST_NM} 입니다!</c:if><br/>
		<c:if test = "${pResult03.BSSH_NM != pResult01.BSSH_NM && pResult03.BSSH_NM != pResult02.BSSH_NM}">추천 영양제: ${pResult03.BSSH_NM}의</c:if>
		<c:if test = "${pResult03.PRDLST_NM != pResult01.PRDLST_NM && pResult03.PRDLST_NM != pResult02.PRDLST_NM}">${pResult03.PRDLST_NM} 입니다!</c:if><br/>
		
		nick: ${nick}<br/>
		age: ${param.age}<br/>
		weight: ${weight}<br/>
		height: ${param.height}<br/>
		gender: ${param.gender}<br/>
	</form>
</div>

<div id = result02>
	<form method = "post">
		${aResult.nick}님이 제일 필요한 영양소는 ${paramValues.contents} 입니다.
	</form>
</div>
	
	<!--
		String nick = request.getParameter("nick");
		out.println("nick : <b>"+nick+"</b><br>");
		
		String contents01 = request.getParameter("contents01");
		out.println("contents01 : <b>"+contents01+"</b><br>");
	-->