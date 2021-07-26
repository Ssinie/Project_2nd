<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<input type="button" value="제품정보 입력" onClick="location.href='http://localhost:8080/Project_2nd/master/iteminsert.do'"><br />
<input type="button" value="CSV파일 출력" onClick="location.href='http://localhost:8080/Project_2nd/master/itemTypeCSVWrite.do'"><br />
<input type="button" value="제품키값 입력" onClick="location.href='http://localhost:8080/Project_2nd/master/ItemTypeKeyInsert.do'"><br />
<input type="button" value="가중치 부여" onClick="location.href='http://localhost:8080/Project_2nd/master/ItemTypeValueInsert.do'">
<br />
<br />
<% int i = 1; %>
<c:forEach var="dto" items="${list}">
	<table border="1">
		<tr>
			<td><%=i%></td>
			<td width="10">${dto.LCNS_NO}</td>
			<td width="10">${PRDLST_REPORT_NO}</td>
			<td width="200">${dto.BSSH_NM}</td>
			<td width="800">${dto.RAWMTRL_NM}</td>
		</tr>
	</table>
	<% ++i; %>
</c:forEach>