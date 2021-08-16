<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<title>Insert title here</title>
</head>
<script type="text/javascript">
$(function(){ 
	$("#alert-success").hide(); 
	$("#alert-danger").hide(); 
	$("input").keyup(function(){ 
		var pwd1=$("#pw1").val(); 
		var pwd2=$("#pw2").val(); 
	if(pwd1 != "" || pwd2 != ""){ 
		if(pwd1 == pwd2){ 
		$("#alert-success").show().attr("style","color:#00f");
		$("#alert-danger").hide(); 
		$("#submit").removeAttr("disabled"); 
	}else{
		$("#alert-success").hide(); 
		$("#alert-danger").show().attr("style","color:#f00");
		$("#submit").attr("disabled", "disabled"); 
	} 
} 
});
});

</script>
<body>
<center>
<h1>비밀번호 수정</h1>
<form action="pwUdate.ns" method="post">
<input name="id" type="hidden" value="${manager.id }" />
<c:if test="${mem.id != null }">
	<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" bgcolor="orange">새비밀번호</td>
		<td><input type="password" name="password" id="pw1" required/></td>
	</tr> 
	<tr>
		<td align="center" bgcolor="orange">새비밀번호 확인</td>
		<td><input type="password" name="rePw" id="pw2" required/></td>
	</tr>
	<tr>
		<td align="center" colspan="3" class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</td>
		<td align="center" colspan="3" class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</td>
	</tr>
	<tr>
		<td align="center" colspan="2">
		<input id="submit" type="submit" disabled="disabled" value="비밀번호 수정"/>
		<button type="button" onclick="history.go(-1)">취소</button></td>
	</tr>
	</table>
	</c:if>
	</form>
</center>
</body>
</html>