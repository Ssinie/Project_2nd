<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<table border="1">
	<tr>글 확인</tr>
	<tr>
		<td>제목</td>
		<td>
			${dto.title}
		</td>
	</tr>
	<tr>
		<td>내용</td>
		<td>
			${dto.content}
		</td>
	</tr>
	<tr>
		<td colspan="2">
		<input type="button" value="목록" onClick="location.href='http://localhost:8080/Project_2nd/manager/board.do'" />
		<input type="button" value="수정" onClick="location.href='http://localhost:8080/Project_2nd/manager/updateForm.do?num=${dto.num}'" />
		<input type="button" value="삭제" onClick="location.href='http://localhost:8080/Project_2nd/manager/deleteForm.do?num=${dto.num}'" />
		</td>
	</tr>
</table>