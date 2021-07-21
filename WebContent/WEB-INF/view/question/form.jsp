<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

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

<form action = "/Project_2nd/question/qResult.do" method = "post">
	nick: <input type = "text" name = "nick" required><br/>
	age: <input type = "number" min = "10" max = "120" name = "age" required><br/>
	height: <input type = "number" min = "100" max = "250" name = "height" value = "h" required><br/>
	weight: <input type = "number" min = "30" max = "300" name = "weight" value = "w" required><br/>
	gender: m<input type = "radio" name = "gender" value = "male" required onclick = "c09_w_hide();">
	w<input type = "radio" name = "gender" value = "female" required onclick = "c09_w_show();"><br/>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect}">
		01. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "omega3-3" onclick = "c02_show();">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "probiotic-3" onclick = "c02_1_show();">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "collagen-3" onclick = "c02_2_show();">${question.contents03}<br/>
			<input type = "checkbox" name = "contents" value = "lutein-3,vitaminA-3" onclick = "c02_3_show();">${question.contents04}<br/>
			<input type = "checkbox" name = "contents" value = "vitaminE-3" onclick = "c02_4_show();">${question.contents05}<br/>
			<input type = "checkbox" name = "contents" value = "vitaminC-3,redginseng-3" onclick = "c02_5_show();">${question.contents06}<br/>
			<input type = "checkbox" name = "contents" value = "calcium-3" onclick = "c02_6_show();">${question.contents07}<br/>
			<input type = "checkbox" name = "contents" value = "redginseng-3,zinc-3" onclick = "c02_7_show();">${question.contents08}<br/>
			<input type = "checkbox" name = "contents" value = "biotin-3" onclick = "c02_8_show();">${question.contents09}<br/>
			<input type = "checkbox" name = "contents" value = "0">${question.contents10}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<div id = "c02" style = "display: none">
		<c:forEach var = "question" items = "${qSelect02}">
			1-1. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "vitaminK-2">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "magnesium-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "probiotic-2,vitaminK-2">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "probiotic-2">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_1" style = "display: none">
		<c:forEach var = "question" items = "${qSelect03}">
			1-2. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "cabbage-2">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "probiotic-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "probiotic-2">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "milkthistle-2">${question.contents04}<br/>
				<input type = "checkbox" name = "contents" value = "milkthistle-2,probiotic-2">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_2" style = "display: none">
		<c:forEach var = "question" items = "${qSelect04}">
			1-3. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "vitaminD-2">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "vitaminD-2,zinc-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "collagen-2,vitaminC-2">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "vitaminB-2">${question.contents04}<br/>
				<input type = "checkbox" name = "contents" value = "collagen-2">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_3" style = "display: none">
		<c:forEach var = "question" items = "${qSelect05}">
			1-4. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "omega3-2,vitaminA-2,lutein-2">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "magnesium-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "milkthistle-2,lutein-2">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "vitaminA-2">${question.contents04}<br/>
				<input type = "checkbox" name = "contents" value = "vitaminA-2,lutein-2">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_4" style = "display: none">
		<c:forEach var = "question" items = "${qSelect06}">
			1-5. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "vitaminB-2">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "vitaminB-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "mineral-2">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "omege3-2,vitaminD-2">${question.contents04}<br/>
				<input type = "checkbox" name = "contents" value = "vitaminE-2">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_5" style = "display: none">
		<c:forEach var = "question" items = "${qSelect07}">
			1-6. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "vitaminB-2,vitaminC-2">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "iron-2,vitaminD-2,vitaminC-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "iron-2,vitaminD-2,vitaminC-2,vitaminB-2">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "redginseng-2">${question.contents04}<br/>
				<input type = "checkbox" name = "contents" value = "redginseng-2">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_6" style = "display: none">
		<c:forEach var = "question" items = "${qSelect08}">
			1-7. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "calcium-2,phosphorus-2,vitaminK-2">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "calcium-2,phosphorus-2,vitaminK-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "calcium-2,vitaminD-2,selenium-2,vitaminK-2">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "calcium-2,phosphorus-2,vitaminK-2">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_7" style = "display: none">
		<c:forEach var = "question" items = "${qSelect09}">
			1-8. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "Propolis-2,magnesium-2">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "probiotic-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "Propolis-2,zinc-2">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "redginseng-2">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_8" style = "display: none">
		<c:forEach var = "question" items = "${qSelect10}">
			1-9. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "biotin-2">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "biotin-2">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "biotin-2">${question.contents03}<br/>
				<input type = "checkbox" name = "contents" value = "biotin-2">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<c:forEach var = "question" items = "${qSelect12}">
		03. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "amino-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "amino-1,vitaminD-1">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "vitaminD-1">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect13}">
		04. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "0">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "vitaminD-1">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "vitaminD-1">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect14}">
		05. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "omega3-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "dietryfiber-1">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "dietryfiber-1,omega3-1">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect15}">
		06. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "vitaminC-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "vitaminC-1">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "omega3-1">${question.contents03}<br/>
			<input type = "checkbox" name = "contents" value = "0">${question.contents05}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect16}">
		07. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "vitaminC-1,lutein-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "lutein-1,vitaminA-1">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "omega3-1">${question.contents04}<br/>
			<input type = "checkbox" name = "contents" value = "calcium-1,vitaminC-1">${question.contents05}<br/>
			<input type = "checkbox" name = "contents" value = "vitaminB-1">${question.contents06}<br/>
			<input type = "checkbox" name = "contents" value = "0">${question.contents07}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect17}">
		08. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "checkbox" name = "contents" value = "milkthistle-1">${question.contents01}<br/>
			<input type = "checkbox" name = "contents" value = "omega3-1">${question.contents02}<br/>
			<input type = "checkbox" name = "contents" value = "calcium-1,phosphorus-1,vitaminK-1">${question.contents03}<br/>
			<input type = "checkbox" name = "contents" value = "0">${question.contents04}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<div id = "c09_w" style = "display: none">
		<c:forEach var = "question" items = "${qSelect18}">
			09. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "checkbox" name = "contents" value = "mineral-1">${question.contents01}<br/>
				<input type = "checkbox" name = "contents" value = "gammalinolenic-1">${question.contents02}<br/>
				<input type = "checkbox" name = "contents" value = "0">${question.contents03}<br/>
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
	<input type = "submit" value = "결과">
</form>