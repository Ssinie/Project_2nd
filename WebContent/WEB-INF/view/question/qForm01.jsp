<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>qform01</h1>

<script language = "javascript">
	function check(){
		var form = document.form01;
		// 첫번째 라디오 버튼을 선택한 경우.
		// contents01
		if(form.contents[0].checked == true){
			form.action = "/Project_2nd/question/qForm02.do";
		}
		else if(form.contents[1].checked == true){
			form.action = "/Project_2nd/question/qForm03.do";
		}
		else if(form.contents[2].checked == true){
			form.action = "/Project_2nd/question/qForm04.do";
		}
		else if(form.contents[3].checked == true){
			form.action = "/Project_2nd/question/qForm05.do";
		}
		else if(form.contents[4].checked == true){
			form.action = "/Project_2nd/question/qForm06.do";
		}
		else if(form.contents[5].checked == true){
			form.action = "/Project_2nd/question/qForm07.do";
		}
		else if(form.contents[6].checked == true){
			form.action = "/Project_2nd/question/qForm08.do";
		}
		else if(form.contents[7].checked == true){
			form.action = "/Project_2nd/question/qForm09.do";
		}
		else if(form.contents[8].checked == true){
			form.action = "/Project_2nd/question/qForm10.do";
		}
		else{
			form.action = "/Project_2nd/question/qForm11.do";
		}
		form.submit();
	}
</script>

<form name = "form01" method = "post">
	<c:forEach var = "question" items = "${qSelect}">
		${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents" value = "1">${question.contents01}<br/>
			<input type = "radio" name = "contents" value = "2">${question.contents02}<br/>
			<input type = "radio" name = "contents" value = "3">${question.contents03}<br/>
			<input type = "radio" name = "contents" value = "4">${question.contents04}<br/>
			<input type = "radio" name = "contents" value = "5">${question.contents05}<br/>
			<input type = "radio" name = "contents" value = "6">${question.contents06}<br/>
			<input type = "radio" name = "contents" value = "7">${question.contents07}<br/>
			<input type = "radio" name = "contents" value = "8">${question.contents08}<br/>
			<input type = "radio" name = "contents" value = "9">${question.contents09}<br/>
			<input type = "radio" name = "contents" value = "10">${question.contents10}<br/>
		</c:if>
	</c:forEach>
	<input type = "button" value = "이전" onclick = "history.back();"/>
	<input type = "submit" value = "다음" onclick = "check()">
</form>