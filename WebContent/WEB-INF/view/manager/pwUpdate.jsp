<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>비밀번호 수정</h1>
<form action="pwUdate.ns" method="post">
<input name="id" type="hidden" value="${manager.id }" />
<c:if test="${mem.id != null }">
	<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" bgcolor="orange">새비밀번호</td>
		<td><input type="password" name="password"/></td>
	</tr>
	<!--  
	<tr>
		<td align="center" bgcolor="orange">새비밀번호 확인</td>
		<td><input type="password" name="password"/></td>
	</tr>
	-->
	<tr>
		<td align="center" colspan="2"><input type="submit" value="비밀번호 수정"/></td>
	</tr>
	</table>
	</c:if>
	</form>
</center>
</body>
</html>