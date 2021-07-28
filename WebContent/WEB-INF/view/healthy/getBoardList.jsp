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
<h1>게시글 목록</h1>
<br>
<a href="insertBoardV.ns">새글 등록</a>
<a href="crawling.ns">크롤링 하기</a>
<br>
<table border="1" cellpadding="0" cellspacing="0" width="1050">
<tr>
	<th bgcolor="orange" width="100">번호</th>
	<th bgcolor="orange" width="400">제목</th>
	<th bgcolor="orange" width="150">작성자</th>
	<th bgcolor="orange" width="200">등록일</th>
	<th bgcolor="orange" width="200">수정일</th>
</tr>

<c:forEach items="${boardList }" var="board">
<tr>
	<td align="center">${board.num }</td>
	<c:if test="${board.writer eq 'naver' }"> 
		<td align="left"><a href="${board.content }">${board.title }</a></td>
	</c:if>
	<c:if test="${board.writer ne 'naver' }">
		<td align="left"><a href="getBoard.ns?num=${board.num }">${board.title }</a></td>
	</c:if>
	<td align="center">${board.writer }</td>
	<td align="center">${board.regdate }</td>
	<td align="center">${board.updateDate }</td>
</tr>
</c:forEach>


</table>
</center>
</body>
</html>