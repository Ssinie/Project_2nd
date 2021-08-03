<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<% int i = 1; %>
<table border="1">
	<tr>
		<td>num</td>
		<td>상품명</td>
		<td>중분류</td>
		<td>소분류</td>
		<td>상품URL</td>
		<td>사진URL</td>
	</tr>
	<c:forEach var="dto" items="${list}">
	<tr>
		<td><%=i%></td>
		<td>${dto.name}</td>
		<td>${dto.maintag}</td>
		<td>${dto.subtag}</td>
		<td>${dto.url}</td>
		<td>${dto.imgurl}</td>
	</tr>
	<% ++i; %>
	</c:forEach>
</table>