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
<h1>${board.qnum }번 QUESTION_VALUE 상세정보</h1>
<form action="updateValue.do" method="post">
<input name="seq" type="hidden" value="${board.seq }" />
<table border="1" cellpadding="0" cellspacing="0" width="250">
	<tr>
		<td bgcolor="lightblue" align="center">번호</td>
		<td align="left">${board.seq }</td>
	</tr>
	<tr>
		<td bgcolor="lightblue" align="center">Qnum</td>
		<td align="left">${board.qnum }</td>
	</tr>
	<tr>
		<td bgcolor="lightblue" align="center">Nutri01</td>
		<td align="left">${board.nutri01 }</td>
	</tr>
		<tr>
		<td bgcolor="lightblue" align="center">Val01</td>
		<td align="left">${board.val01 }</td>
	</tr>
		<tr>
		<td bgcolor="lightblue" align="center">Nutri02</td>
		<td align="left">${board.nutri02 }</td>
	</tr>
		<tr>
		<td bgcolor="lightblue" align="center">Val02</td>
		<td align="left">${board.val02 }</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정">
		</td>
	</tr>	
</table>
<br>
<a href="getValueList.do">글목록</a>
</center>
</body>
</html>