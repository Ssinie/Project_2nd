<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src='https://code.jquery.com/jquery-3.3.1.min.js'></script>
<title>Nutrients Sunday</title>
</head>
<script type = "text/javascript">
$(document).ready(function(){
	$("#submit").on("click", function(){
		var idChkVal = $("#idChk").val();
		if(idChkVal == "N"){
			alert("중복확인 버튼을 눌러주세요.");
			/* $("#submit").attr("disabled", "disabled"); */
		}else if(idChkVal == "Y"){
			$("#regForm").submit();
		    /* $("#submit").removeAttr("disabled"); */
		}
	});
})

	function fn_idChk(){
		var query = {id : $("#id").val()};
		var id = $("#id").val();
		if(id == '') {
			alert("아이디를 입력하세요.");
			return
		}
		$.ajax({
			type : "post",
			url : "idChk.ns",		
			data : query,
			success : function(data){
				console.log(data);
				if(data == '1'){
					$(".result .msg").text("사용불가");
					$(".result .msg").attr("style","color:#f00");
					$("#submit").attr("disabled", "disabled");
				}else if(data == '0'){
					$(".result .msg").text("사용가능");
					$(".result .msg").attr("style", "color:#00f");
					$("#idChk").attr("value", "Y");
					$("#submit").removeAttr("disabled");
				}
			}
		});
	}
	
	
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
<h1>관리자 등록</h1>
<form action="registerPro.ns" method="post" id="regForm">
<table border="1" cellpadding="0" cellspacing="0">
	<tr>
		<td align="center" bgcolor="orange"><label for="managerID">아이디</label></td>
		<td><input type="text" id="id" name="id" required/></td>
		<td><button class="idChk" type="button" id="idChk" onclick="fn_idChk();" value="N">중복확인</button></td>
	</tr>
	<tr class="result">
		<td align="center" colspan="3"><span class="msg">아이디를 확인해주세요.</span></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="pw">비밀번호</label></td>
		<td><input type="password" name="password" id="pw1" required/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="rePw">재확인</label></td>
		<td><input type="password" name="rePw" id="pw2" required/></td>
	</tr>
	<tr>
		<td align="center" colspan="3" class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</td>
		<td align="center" colspan="3" class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="managerNAME">이름</label></td>
		<td><input type="text" id="managerNAME" name="name" required/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="managerNAME">소속부서</label></td>
		<td>
			<select name="department" required>
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
			<input type="radio" id="managerGENDER" name="gender" value="여성" required>여성
			<input type="radio" id="managerGENDER" name="gender" value="남성" required>남성
		</td>
	</tr>
		<tr>
		<td align="center" bgcolor="orange"><label for="managerEMAIL">이메일</label></td>
		<td><input type="email" id="managerEMAIL" name="mail"/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="managerPHONE">전화번호</label></td>
		<td><input type="text" id="managerPHONE" name="phone"/></td>
	</tr>
	<tr>
		<td align="center" bgcolor="orange"><label for="managerADDRESS">주소</label></td>
		<td><input type="text" id="managerADDRESS" name="address"/></td>
	</tr>
	<tr>
		<td align="center" colspan="2">
			<button type="submit" id="submit" disabled="disabled">등록완료</button>
			<button type="button" onclick="">취소</button>
		</td>
	</tr>
	
</table>
</form>
</center>

</body>
</html>