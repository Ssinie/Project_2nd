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
<h1>글 수정</h1>
<hr>
<form action="updateBoard.ns" method="post">
<input name="num" type="hidden" value="${board.num }" />
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" bgcolor="orange" width="70">번호</td>
		<td align="left">${board.num }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange" width="70">제목</td>
		<td align="left"><input name="title" type="text" value="${board.title }" /></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange">작성자</td>
		<td align="left"><input name="writer" type="text" value="${board.writer }" /></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange">내용</td>
		<td align="left"><input name="content" type="text" value="${board.content }" /></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange">등록일</td>
		<td align="left">${board.regdate }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange">수정일</td>
		<td align="left">${board.updateDate }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="글 수정완료">
		</td>
	</tr>		
</table>
</form>
<hr>
<a href="getBoardList.ns">글목록</a>
</center>
</body>
</html>