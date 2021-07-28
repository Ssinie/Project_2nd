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
<h1>QUESTION_VALUE</h1>
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="lightblue">번호</th>
	<th bgcolor="lightblue">Qnum</th>
	<th bgcolor="lightblue">Nutri01</th>
</tr>
<c:forEach items="${boardList }" var="board">
<tr>
	<td align="center">${board.seq }</td>
	<td align="center">${board.qnum }</td>
	<td align="center"><a href="getValue.do?seq=${board.seq }">${board.nutri01 }</a></td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>