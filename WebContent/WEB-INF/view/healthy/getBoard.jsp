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
<h1>글 상세</h1>
<hr>
<form action="updateBoardV.ns" method="post">
<input name="num" type="hidden" value="${board.num }" />
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" bgcolor="#b7a2de" width="70">제목</td>
		<td align="left"><input name="title" type="text" value="${board.title }" /></td>
	</tr>
	<tr>
		<td align="center" bgcolor="#b7a2de">작성자</td>
		<td align="left">${board.writer }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="#b7a2de">내용</td>
		<td align="left">${board.content }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="#b7a2de">등록일</td>
		<td align="left">${board.regdate }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="#b7a2de">수정일</td>
		<td align="left">${board.updateDate }</td>
	</tr>
<c:if test="${mem != null }">
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="글수정">
			<button type="button" id=test name="test" onclick='location.href="deleteBoard.ns?num=${board.num }";'>글삭제</button>
		</td>
	</tr>		
</c:if>
</table>
</form>

<a href="getBoardList.ns">글목록</a>
<hr>
</center>
</body>
</html>