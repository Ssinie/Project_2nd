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
<h1>글 등록</h1>
<hr>
<form action="insertBoard.ns" method="post">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" bgcolor="#b7a2de" width="70">제목</td>
		<td><input type="text" name="title"/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="#b7a2de" width="70">작성자</td>
		<td><input type="text" name="writer"/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="#b7a2de" width="70">내용</td>
		<td><textarea name="content" cols="40" rows="10"></textarea></td>
	</tr>
	<tr>
		<td align="center" colspan="2">
		<input type="submit" value="새글 등록완료"/></td>
	</tr>
</table>
</form>
<hr>
<a href="getBoardList.ns">글목록</a>
</center>
</body>
</html>