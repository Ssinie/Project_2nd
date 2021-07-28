<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nutrients Sunday</title>
</head>
<body>
<center>
<h1>관리자 정보수정</h1>
<hr>
<form action="updateManager.ns" method="post">
<input name="id" type="hidden" value="${manager.id }" />
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" bgcolor="orange" width="70">아이디</td>
		<td align="left">${manager.id }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="managerNAME">이름</label></td>
		<td><input type="text" id="managerNAME" name="name" value="${manager.name }"/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="managerNAME">소속부서</label></td>
		<td>
			<select name="department">
				<option value="none">=== 선택 ===</option>
				<option value="인사부">인사부</option>
				<option value="기획부">기획부</option>
				<option value="홍보부">홍보부</option>
				<option value="영업부">영업부</option>
				<option value="경리부">경리부</option>
			</select>
		</td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="managerGENDER">성별</label></td>
		<td>
			<input type="radio" id="managerGENDER" name="gender" value="여성">여성
			<input type="radio" id="managerGENDER" name="gender" value="남성">남성
		</td>
	</tr>
		<tr>
		<td align="center" bgcolor="orange"><label for="managerEMAIL">이메일</label></td>
		<td><input type="email" id="managerEMAIL" name="mail" value="${manager.mail }"/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="managerPHONE">전화번호</label></td>
		<td><input type="text" id="managerPHONE" name="phone" value="${manager.phone }"/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="managerADDRESS">주소</label></td>
		<td><input type="text" id="managerADDRESS" name="address" value="${manager.address }"/></td>
	</tr>
	<tr>
		<td align="center" colspan="2">
			<button type="submit">등록완료</button>
			<button type="button" onclick="">취소</button>
		</td>
	</tr>	
</table>
</form>
<hr>
<a href="getManagerList.ns">글목록</a>
</center>
</body>
</html>