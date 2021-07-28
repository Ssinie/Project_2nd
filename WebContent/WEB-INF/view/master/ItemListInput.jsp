<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<% int i = 1; %>
<table border="1">
	<tr>
		<td>num</td>
		<td>제품번호</td>
		<td>비타민A</td>
		<td>비타민B</td>
		<td>비타민C</td>
	</tr>
	<c:forEach var="dto" items="${list}">
	<tr>
		<td><%=i%></td>
		<td>${dto.PRDLST_REPORT_NO}</td>
		<td>${dto.vitaA}</td>
		<td>${dto.vitaB}</td>
		<td>${dto.vitaC}</td>
	</tr>
	<% ++i; %>
	</c:forEach>
</table>