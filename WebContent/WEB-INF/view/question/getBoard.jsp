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
<h1>${board.num }번 설문지 상세정보</h1>
<form action="updateBoard.do" method="post">
<input name="num" type="hidden" value="${board.num }" />
<hr>
<table border="1" cellpadding="0" cellspacing="0" width="1050">
	<tr>
		<td bgcolor="#65e08c" align="center">번호</td>
		<td align="left">${board.num }</td>
	</tr>
	<tr>
		<td bgcolor="#65e08c" align="center">제목</td>
		<td align="left">${board.title }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents01</td>
		<td align="left">${board.contents01 }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents02</td>
		<td align="left">${board.contents02 }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents03</td>
		<td align="left">${board.contents03 }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents04</td>
		<td align="left">${board.contents04 }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents05</td>
		<td align="left">${board.contents05 }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents06</td>
		<td align="left">${board.contents06 }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents07</td>
		<td align="left">${board.contents07 }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents08</td>
		<td align="left">${board.contents08 }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents09</td>
		<td align="left">${board.contents09 }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents10</td>
		<td align="left">${board.contents10 }</td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">등록날짜</td>
		<td align="left">${board.dates }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정">
		</td>
	</tr>	
</table>
<br>
<a href="getBoardList.do">글목록</a>
<hr>
</center>
</body>
</html>