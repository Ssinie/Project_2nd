<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nutrients Sundaye</title>
</head>
<body>
<center>
<h1>${board.num }번 설문지 수정</h1>
<form action="updateBoardPro.do" method="post">
<input name="num" type="hidden" value="${board.num }" />
<table border="1" cellpadding="0" cellspacing="0" >
	<tr>
		<td bgcolor="#65e08c" align="center">번호</td>
		<td align="left">${board.num }</td>
	</tr>
	<tr>
		<td bgcolor="#65e08c" align="center">제목</td>
		<td><input style="width:700px;" type="text" id="title" name="title" value="${board.title }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents01</td>
		<td><input style="width:700px;" type="text" id="contents01" name="contents01" value="${board.contents01 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents02</td>
		<td><input style="width:700px;" type="text" id="contents02" name="contents02" value="${board.contents02 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents03</td>
		<td><input style="width:700px;" type="text" id="contents03" name="contents03" value="${board.contents03 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents04</td>
		<td><input style="width:700px;" type="text" id="contents04" name="contents04" value="${board.contents04 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents05</td>
		<td><input style="width:700px;" type="text" id="contents05" name="contents05" value="${board.contents05 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents06</td>
		<td><input style="width:700px;" type="text" id="contents06" name="contents06" value="${board.contents06 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents07</td>
		<td><input style="width:700px;" type="text" id="contents07" name="contents07" value="${board.contents07 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents08</td>
		<td><input style="width:700px;" type="text" id="contents08" name="contents08" value="${board.contents08 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents09</td>
		<td><input style="width:700px;" type="text" id="contents09" name="contents09" value="${board.contents09 }"/></td>
	</tr>
		<tr>
		<td bgcolor="#65e08c" align="center">Contents10</td>
		<td><input style="width:700px;" type="text" id="contents10" name="contents10" value="${board.contents10 }"/></td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="수정">
		</td>
	</tr>	
</table>
<br>
<a href="getBoardList.do">글목록</a>
</center>
</body>

</html>