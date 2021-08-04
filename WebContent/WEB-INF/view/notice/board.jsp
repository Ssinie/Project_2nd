<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<h1>공지사항</h1>
<table border="1">
	<tr>
		<td colspan="4">
			<input type="button" value="글 작성" onClick="location.href='http://localhost:8080/Project_2nd/manager/writeForm.do'" />
		</td>
	</tr>
	<tr>
		<td>NUM</td>
		<td>제목</td>
		<td>작성자</td>
		<td>최종 수정일</td>
	</tr>
<c:if test="${count == 0}">
	<tr>
	<td colspan="4">게시글이 현재 없습니다.</td>
	</tr>
</c:if>
<c:if test="${count >= 1}">
<c:forEach var="list" items="${list}">
	<tr>
		<td>${list.num}</td>
		<td><a href="form.do?num=${list.num}">${list.title}</a></td>
		<td>${list.writer}</td>
		<td>${list.updatedate}</td>
	</tr>
</c:forEach>
</c:if>	
</table>


