<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<form action="deleteFormPro.do" method="post">
<input type="hidden" name="num" value="${num}"/>
<table>
<tr>정말 삭제하시겠습니까?</tr>
<tr>
	<td>ID</td>
	<td><input type="text" name="id" /></td>
</tr>
<tr>
	<td>PW</td>
	<td><input type="password" name= "password" /></td>
</tr>
<tr>
	<input type="submit" value="완료" />
</tr>
<tr>
	<input type="button" vaule="돌아가기" Onclick="location.href='http://localhost:8080/Project_2nd/manager/board.do'"/>
</tr>
</table>
</form>