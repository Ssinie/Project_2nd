<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nutrients Sunday</title>
</head>
<body>
<center>
<h1>관리자 로그인</h1>
<form action="loginCheck.ns" method="post">
	<c:if test="${mem.id == null }">
	<table border="1" cellpadding="0" cellspacing="0">
	
	<tr>
		<td align="center" bgcolor="orange">아이디</td>
		<td><input type="text" name="id"/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange">비밀번호</td>
		<td><input type="password" name="password"/></td>
	</tr>

	<tr>
		<td align="center" colspan="2">	
			<input type="submit" value="로그인"/>
		</td>
	</tr>
	</table>
	</c:if>
	<c:if test="${mem != null }">
		<tr>
			<td><p>${mem.id }님 환영합니다.</p></td>	
		</tr>
	</c:if>
	<c:if test="${msg == false}">
		<tr>
			<td><p style="color: red;">로그인 실패! 아이디와 비밀번호 확인해주세요.</p></td>	
		</tr>
	</c:if>
</form>
</center>
</body>
</html>