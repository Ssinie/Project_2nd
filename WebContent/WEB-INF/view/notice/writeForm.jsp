<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<form action="writeFormPro.do" method="post">
<table border="1">
	<tr>글 작성</tr>
	<tr>
		<td>제목</td>
		<td>
			<input type="text" name="title" />
			<input type="hidden" name="writer" value="${writer}"/>
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			<textarea name="content" rows="30" cols="80" wrap="hard"></textarea><br />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="완료">
		</td>
	</tr>
</table>
</form>
