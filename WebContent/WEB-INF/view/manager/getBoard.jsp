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
<h1>${manager.name}님의 상세정보</h1>
<hr>
<form action="updateManagerV.ns" method="post">
<input name="id" type="hidden" value="${manager.id }" />
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" bgcolor="orange" width="70">관리자ID</td>
		<td align="left">${manager.id }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange">관리자명</td>
		<td align="left">${manager.name }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange">소속부서</td>
		<td align="left">${manager.department }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange">성별</td>
		<td align="left">${manager.gender }</td>
	</tr>
		<tr>
		<td align="center" bgcolor="orange">이메일</td>
		<td align="left">${manager.mail }</td>
	</tr>
		<tr>
		<td align="center" bgcolor="orange">전화번호</td>
		<td align="left">${manager.phone }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange">주소</td>
		<td align="left">${manager.address }</td>
	</tr>
		<tr>
		<td align="center" bgcolor="orange">등록일</td>
		<td align="left">${manager.regdate }</td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange">수정일</td>
		<td align="left">${manager.updateDate }</td>
	</tr>
	<c:if test="${mem.id == manager.id }">
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="일반 수정">
			<button type="button" onclick='location.href="pwUpdateV.ns"'>비밀번호 수정</button>
		</td>
	</tr>
	</c:if>
</table>
</form>
<br>
<c:if test="${mem.id == manager.id }">
<form action="exManager.ns" method="post">
	<input name="id" type="hidden" value="${manager.id }" />
	<button type="submit">관리자 탈퇴</button>
	<button type="button" onclick="location.href='managerlogout.ns'" >로그아웃</button>
	<!-- <a href="managerlogout.ns">로그아웃</a>  -->
</form>
</c:if>
<a href="getManagerList.ns">글목록</a>
<hr>

</center>
</body>
</html>