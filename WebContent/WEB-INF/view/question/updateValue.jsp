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
<h1>${board.qnum }번 QUESTION_VALUE 수정</h1>
<form action="updateValuePro.do" method="post">
<input name="seq" type="hidden" value="${board.seq }" />
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td bgcolor="#65e08c" align="center">번호</td>
		<td align="left">${board.seq }</td>
	</tr>
	<tr>
		<td bgcolor="#65e08c" align="center">Qnum</td>
		<td><input style="width:300px;" type="text" id="qnum" name="qnum" value="${board.qnum }"/></td>
	</tr>
	<tr>
		<td bgcolor="#65e08c" align="center">Nutri01</td>
		<td><input style="width:300px;" type="text" id="nutri01" name="nutri01" value="${board.nutri01 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Val01</td>
		<td><input style="width:300px;" type="text" id="val01" name="val01" value="${board.val01 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Nutri02</td>
		<td><input style="width:300px;" type="text" id="nutri02" name="nutri02" value="${board.nutri02 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Val02</td>
		<td><input style="width:300px;" type="text" id="val02" name="val02" value="${board.val02 }"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정">
		</td>
	</tr>	
</table>
</form>
<br>
<a href="getValueList.do">글목록</a>
</center>
</body>
</html>