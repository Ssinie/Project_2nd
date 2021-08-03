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
<h1>관리자 목록</h1>
<br>
<c:if test="${mem == null }">
	<a href="/Project_2nd/manager/hello.ns">홈</a>
	<a href="register.ns">관리자등록</a>
	<a href="managerLogin.ns">로그인</a>
</c:if>
<c:if test="${mem != null}">
<c:if test="${mem.status == 99}">
		<p>status가 99인 사람만 보임!</p>
</c:if>
</c:if>
<c:if test="${mem != null }">
	<p>${mem.id }님 반갑습니다.</p>
	<input type="button" onclick='location.href="hello.ns"' value="홈"/>
	<input type="button" onclick='location.href="register.ns"' value="관리자등록"/>
	<input type="button" onclick='location.href="managerlogout.ns"' value="로그아웃"/>
</c:if>



<br>
<table border="1" cellpadding="0" cellspacing="0" width="1050">
<tr>
	<th bgcolor="orange" width="100">관리자ID</th>
	<th bgcolor="orange" width="400">관리자명</th>
	<th bgcolor="orange" width="400">소속부서</th>
	<th bgcolor="orange" width="150">전화번호</th>
	<th bgcolor="orange" width="200">등록일시</th>
</tr>

<c:forEach items="${boardList }" var="board">
<tr>
	<td align="center"><a href="getManager.ns?id=${board.id }">${board.id }</a></td>
	<td align="center">${board.name }</td>
	<td align="center">${board.department }</td>
	<td align="center">${board.phone }</td>
	<td align="center">${board.regdate }</td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>