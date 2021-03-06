<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<div class="loader">
<!-- 접속 주소 : http://localhost:8080/Project_2nd/question/form.do -->
<script type = "text/javascript">
	//보이기
	function c02_show() {document.getElementById("c02").style.display = "block";}
	function c02_1_show() {document.getElementById("c02_1").style.display = "block";}
	function c02_2_show() {document.getElementById("c02_2").style.display = "block";}
	function c02_3_show() {document.getElementById("c02_3").style.display = "block";}
	function c02_4_show() {document.getElementById("c02_4").style.display = "block";}
	function c02_5_show() {document.getElementById("c02_5").style.display = "block";}
	function c02_6_show() {document.getElementById("c02_6").style.display = "block";}
	function c02_7_show() {document.getElementById("c02_7").style.display = "block";}
	function c02_8_show() {document.getElementById("c02_8").style.display = "block";}
	function c09_w_show() {document.getElementById("c09_w").style.display = "block";}
	function etc_show() {document.getElementById("etc").style.display = "block";}
	
	//숨기기
	function c02_hide() {document.getElementById("c02").style.display = "none";}
	function c02_1_hide() {document.getElementById("c02_1").style.display = "none";}
	function c02_2_hide() {document.getElementById("c02_2").style.display = "none";}
	function c02_3_hide() {document.getElementById("c02_3").style.display = "none";}
	function c02_4_hide() {document.getElementById("c02_4").style.display = "none";}
	function c02_5_hide() {document.getElementById("c02_5").style.display = "none";}
	function c02_6_hide() {document.getElementById("c02_6").style.display = "none";}
	function c02_7_hide() {document.getElementById("c02_7").style.display = "none";}
	function c02_8_hide() {document.getElementById("c02_8").style.display = "none";}
	function c09_w_hide() {document.getElementById("c09_w").style.display = "none";}

</script>

<h1>설문조사.</h1>

<form action = "/Project_2nd/question/rLoading.do" method = "post">
	
	<c:forEach var = "question" items = "${qSelect}">
		01. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "1-1" onclick = "c02_show();">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "1-2" onclick = "c02_1_show();">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "1-3" onclick = "c02_2_show();">${question.contents03}<br/>
			<input type = "checkbox" name = "contents" value = "1-4" onclick = "c02_3_show();">${question.contents04}<br/>
			<input type = "checkbox" name = "contents" value = "1-5" onclick = "c02_4_show();">${question.contents05}<br/>
			<input type = "checkbox" name = "contents" value = "1-6" onclick = "c02_5_show();">${question.contents06}<br/>
			<input type = "checkbox" name = "contents" value = "1-7" onclick = "c02_6_show();">${question.contents07}<br/>
			<input type = "checkbox" name = "contents" value = "1-8" onclick = "c02_7_show();">${question.contents08}<br/>
			<input type = "checkbox" name = "contents" value = "1-9" onclick = "c02_8_show();">${question.contents09}<br/>
			<input type = "checkbox" name = "contents" value = "5-1">${question.contents10}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<div id = "c02" style = "display: none">
		<c:forEach var = "question" items = "${qSelect02}">
			1-1. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "1-1-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "1-1-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "1-1-3">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "1-1-4">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_1" style = "display: none">
		<c:forEach var = "question" items = "${qSelect03}">
			1-2. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "1-2-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "1-2-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "1-2-3">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "1-2-4">${question.contents04}<br/>
				<input type = "checkbox" name = "contents" value = "1-2-5">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_2" style = "display: none">
		<c:forEach var = "question" items = "${qSelect04}">
			1-3. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "1-3-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "1-3-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "1-3-3">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "1-3-4">${question.contents04}<br/>
				<input type = "checkbox" name = "contents" value = "1-3-5">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_3" style = "display: none">
		<c:forEach var = "question" items = "${qSelect05}">
			1-4. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "1-4-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "1-4-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "1-4-3">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "1-4-4">${question.contents04}<br/>
				<input type = "checkbox" name = "contents" value = "1-4-5">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_4" style = "display: none">
		<c:forEach var = "question" items = "${qSelect06}">
			1-5. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "1-5-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "1-5-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "1-5-3">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "1-5-4">${question.contents04}<br/>
				<input type = "checkbox" name = "contents" value = "1-5-5">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_5" style = "display: none">
		<c:forEach var = "question" items = "${qSelect07}">
			1-6. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "1-6-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "1-6-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "1-6-3">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "1-6-4">${question.contents04}<br/>
				<input type = "checkbox" name = "contents" value = "1-6-5">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_6" style = "display: none">
		<c:forEach var = "question" items = "${qSelect08}">
			1-7. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "1-7-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "1-7-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "1-7-3">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "1-7-4">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_7" style = "display: none">
		<c:forEach var = "question" items = "${qSelect09}">
			1-8. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "1-8-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "1-8-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "1-8-3">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "1-8-4">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_8" style = "display: none">
		<c:forEach var = "question" items = "${qSelect10}">
			1-9. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "1-9-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "1-9-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "1-9-3">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "1-9-4">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<c:forEach var = "question" items = "${qSelect12}">
		02. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "2-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "2-2">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "2-3">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect13}">
		03. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "5-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "3-1">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "3-2">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect14}">
		04. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "4-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "4-2">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "4-3">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect15}">
		05. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "5-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "5-2">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "5-3">${question.contents03}<br/>
			<input type = "checkbox" name = "contents" value = "5-1">${question.contents05}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect16}">
		06. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "6-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "6-2">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "6-3">${question.contents04}<br/>
			<input type = "checkbox" name = "contents" value = "6-4">${question.contents05}<br/>
			<input type = "checkbox" name = "contents" value = "6-5">${question.contents06}<br/>
			<input type = "checkbox" name = "contents" value = "5-1">${question.contents07}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect17}">
		07. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "7-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "7-2">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "7-3">${question.contents03}<br/>
			<input type = "checkbox" name = "contents" value = "5-1">${question.contents04}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<div id = "c09_w">
		<c:forEach var = "question" items = "${qSelect18}">
			<c:if test = "${param.gender == 'female'}">
				08. ${question.title}<br/>
				<input type = "checkbox" name = "contents" value = "8-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "8-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "5-1">${question.contents03}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<!--
	<c:forEach var = "question" items = "${qSelect19}">
		10. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents10" value = "1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents10" value = "2">${question.contents02}<br/>
			<input type = "checkbox" name = "contents10" value = "3">${question.contents03}<br/>
			<input type = "checkbox" name = "contents10" value = "4">${question.contents04}<br/>
		</c:if>
	</c:forEach>
	<br/>
	-->
	
	<!--
	<c:forEach var = "question" items = "${qSelect20}">
		11. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents11" value = "1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents11" value = "2">${question.contents02}<br/>
			<input type = "checkbox" name = "contents11" value = "3">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	-->
	<!--
	<c:forEach var = "question" items = "${qSelect21}">
		10. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents12" value = "1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents12" value = "2">${question.contents02}<br/>
			<input type = "checkbox" name = "contents12" value = "3">${question.contents03}<br/>
			<input type = "checkbox" name = "contents12" value = "4">${question.contents04}<br/>
			<input type = "checkbox" name = "contents12" value = "5">${question.contents05}<br/>
			<input type = "checkbox" name = "contents12" value = "6">${question.contents06}<br/>
			<input type = "checkbox" name = "contents12" value = "7" onclick = "etc_show();">${question.contents07}<br/>
		</c:if>
	</c:forEach>
	<br/>
	<div id = "etc" style = "display: none"><input type = "text" name = "contents12"></div>
	-->
	<input type = "hidden" name = "nick" value = "${param.nick}">
	<input type = "hidden" name = "age" value = "${param.age}">
	<input type = "hidden" name = "weight" value = "${param.weight}">
	<input type = "hidden" name = "height" value = "${param.height}">
	<input type = "hidden" name = "gender" value = "${param.gender}">
	<input type = "submit" value = "결과">
</form>
</div>