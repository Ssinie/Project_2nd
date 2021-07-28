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
<h1>설문지 내용</h1>
<table border="1" cellpadding="0" cellspacing="0" width="700">
<tr>
	<th bgcolor="lightblue">번호</th>
	<th bgcolor="lightblue">제목</th>
</tr>
<c:forEach items="${boardList }" var="board">
<tr>
	<td align="center">${board.num }</td>
	<td align="center"><a href="getBoard.do?num=${board.num }">${board.title }</a></td>
</tr>
</c:forEach>
</table>
</center>
</body>
</html>