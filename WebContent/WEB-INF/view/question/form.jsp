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
	nick: <input type = "text" name = "nick"><br/>
	age: <input type = "text" name = "age"><br/>
	height: <input type = "text" name = "height"><br/>
	weight: <input type = "text" name = "weight"><br/>
	gender: m<input type = "radio" name = "gender" value = "male" onclick = "c09_w_hide();">
	w<input type = "radio" name = "gender" value = "female" onclick = "c09_w_show();"><br/>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect}">
		01. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents01" value = "omega3-3" onclick = "c02_show();c02_1_hide();c02_2_hide();c02_3_hide();c02_4_hide();c02_5_hide();c02_6_hide();c02_7_hide();c02_8_hide();">${question.contents01}<br/>
			<input type = "radio" name = "contents01" value = "probiotic-3" onclick = "c02_1_show();c02_hide();c02_2_hide();c02_3_hide();c02_4_hide();c02_5_hide();c02_6_hide();c02_7_hide();c02_8_hide();">${question.contents02}<br/>
			<input type = "radio" name = "contents01" value = "collagen-3" onclick = "c02_2_show();c02_hide();c02_1_hide();c02_3_hide();c02_4_hide();c02_5_hide();c02_6_hide();c02_7_hide();c02_8_hide();">${question.contents03}<br/>
			<input type = "radio" name = "contents01" value = "lutein-3,vitaminA-3" onclick = "c02_3_show();c02_hide();c02_1_hide();c02_2_hide();c02_4_hide();c02_5_hide();c02_6_hide();c02_7_hide();c02_8_hide();">${question.contents04}<br/>
			<input type = "radio" name = "contents01" value = "vitaminE-3" onclick = "c02_4_show();c02_hide();c02_1_hide();c02_2_hide();c02_3_hide();c02_5_hide();c02_6_hide();c02_7_hide();c02_8_hide();">${question.contents05}<br/>
			<input type = "radio" name = "contents01" value = "vitaminC-3,redginseng-3" onclick = "c02_5_show();c02_hide();c02_1_hide();c02_2_hide();c02_3_hide();c02_4_hide();c02_6_hide();c02_7_hide();c02_8_hide();">${question.contents06}<br/>
			<input type = "radio" name = "contents01" value = "calcium-3" onclick = "c02_6_show();c02_hide();c02_1_hide();c02_2_hide();c02_3_hide();c02_4_hide();c02_5_hide();c02_7_hide();c02_8_hide();">${question.contents07}<br/>
			<input type = "radio" name = "contents01" value = "redginseng-3,zinc-3" onclick = "c02_7_show();c02_hide();c02_1_hide();c02_2_hide();c02_3_hide();c02_4_hide();c02_5_hide();c02_6_hide();c02_8_hide();">${question.contents08}<br/>
			<input type = "radio" name = "contents01" value = "biotin-3" onclick = "c02_8_show();c02_hide();c02_1_hide();c02_2_hide();c02_3_hide();c02_4_hide();c02_5_hide();c02_6_hide();c02_7_hide();">${question.contents09}<br/>
			<input type = "radio" name = "contents01" value = "0" onclick = "c02_hide();c02_1_hide();c02_2_hide();c02_3_hide();c02_4_hide();c02_5_hide();c02_6_hide();c02_7_hide();c02_8_hide();">${question.contents10}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<div id = "c02" style = "display: none">
		<c:forEach var = "question" items = "${qSelect02}">
			02. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "radio" name = "contents02" value = "vitaminK-2">${question.contents01}<br/>
				<input type = "radio" name = "contents02" value = "magnesium-2">${question.contents02}<br/>
				<input type = "radio" name = "contents02" value = "probiotic-2,vitaminK-2">${question.contents03}<br/>
				<input type = "radio" name = "contents02" value = "probiotic-2">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_1" style = "display: none">
		<c:forEach var = "question" items = "${qSelect03}">
			02. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "radio" name = "contents02" value = "cabbage-2">${question.contents01}<br/>
				<input type = "radio" name = "contents02" value = "probiotic-2">${question.contents02}<br/>
				<input type = "radio" name = "contents02" value = "probiotic-2">${question.contents03}<br/>
				<input type = "radio" name = "contents02" value = "milkthistle-2">${question.contents04}<br/>
				<input type = "radio" name = "contents02" value = "milkthistle-2,probiotic-2">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_2" style = "display: none">
		<c:forEach var = "question" items = "${qSelect04}">
			02. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "radio" name = "contents02" value = "vitaminD-2">${question.contents01}<br/>
				<input type = "radio" name = "contents02" value = "vitaminD-2,zinc-2">${question.contents02}<br/>
				<input type = "radio" name = "contents02" value = "collagen-2,vitaminC-2">${question.contents03}<br/>
				<input type = "radio" name = "contents02" value = "vitaminB-2">${question.contents04}<br/>
				<input type = "radio" name = "contents02" value = "collagen-2">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_3" style = "display: none">
		<c:forEach var = "question" items = "${qSelect05}">
			02. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "radio" name = "contents02" value = "omega3-2,vitaminA-2,lutein-2">${question.contents01}<br/>
				<input type = "radio" name = "contents02" value = "magnesium-2">${question.contents02}<br/>
				<input type = "radio" name = "contents02" value = "milkthistle-2,lutein-2">${question.contents03}<br/>
				<input type = "radio" name = "contents02" value = "vitaminA-2">${question.contents04}<br/>
				<input type = "radio" name = "contents02" value = "vitaminA-2,lutein-2">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_4" style = "display: none">
		<c:forEach var = "question" items = "${qSelect06}">
			02. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "radio" name = "contents02" value = "vitaminB-2">${question.contents01}<br/>
				<input type = "radio" name = "contents02" value = "vitaminB-2">${question.contents02}<br/>
				<input type = "radio" name = "contents02" value = "mineral-2">${question.contents03}<br/>
				<input type = "radio" name = "contents02" value = "omege3-2,vitaminD-2">${question.contents04}<br/>
				<input type = "radio" name = "contents02" value = "vitaminE-2">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_5" style = "display: none">
		<c:forEach var = "question" items = "${qSelect07}">
			02. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "radio" name = "contents02" value = "vitaminB-2,vitaminC-2">${question.contents01}<br/>
				<input type = "radio" name = "contents02" value = "iron-2,vitaminD-2,vitaminC-2">${question.contents02}<br/>
				<input type = "radio" name = "contents02" value = "iron-2,vitaminD-2,vitaminC-2,vitaminB-2">${question.contents03}<br/>
				<input type = "radio" name = "contents02" value = "redginseng-2">${question.contents04}<br/>
				<input type = "radio" name = "contents02" value = "redginseng-2">${question.contents05}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_6" style = "display: none">
		<c:forEach var = "question" items = "${qSelect08}">
			02. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "radio" name = "contents02" value = "calcium-2,phosphorus-2,vitaminK-2">${question.contents01}<br/>
				<input type = "radio" name = "contents02" value = "calcium-2,phosphorus-2,vitaminK-2">${question.contents02}<br/>
				<input type = "radio" name = "contents02" value = "calcium-2,vitaminD-2,selenium-2,vitaminK-2">${question.contents03}<br/>
				<input type = "radio" name = "contents02" value = "calcium-2,phosphorus-2,vitaminK-2">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_7" style = "display: none">
		<c:forEach var = "question" items = "${qSelect09}">
			02. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "radio" name = "contents02" value = "Propolis-2,magnesium-2">${question.contents01}<br/>
				<input type = "radio" name = "contents02" value = "probiotic-2">${question.contents02}<br/>
				<input type = "radio" name = "contents02" value = "Propolis-2,zinc-2">${question.contents03}<br/>
				<input type = "radio" name = "contents02" value = "redginseng-2">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<div id = "c02_8" style = "display: none">
		<c:forEach var = "question" items = "${qSelect10}">
			02. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "radio" name = "contents02" value = "biotin-2">${question.contents01}<br/>
				<input type = "radio" name = "contents02" value = "biotin-2">${question.contents02}<br/>
				<input type = "radio" name = "contents02" value = "biotin-2">${question.contents03}<br/>
				<input type = "radio" name = "contents02" value = "biotin-2">${question.contents04}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<c:forEach var = "question" items = "${qSelect12}">
		03. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents03" value = "amino-1">${question.contents01}<br/>
			<input type = "radio" name = "contents03" value = "amino-1,vitaminD-1">${question.contents02}<br/>
			<input type = "radio" name = "contents03" value = "vitaminD-1">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect13}">
		04. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents04" value = "0">${question.contents01}<br/>
			<input type = "radio" name = "contents04" value = "vitaminD-1">${question.contents02}<br/>
			<input type = "radio" name = "contents04" value = "vitaminD-1">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect14}">
		05. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents05" value = "omega3-1">${question.contents01}<br/>
			<input type = "radio" name = "contents05" value = "dietryfiber-1">${question.contents02}<br/>
			<input type = "radio" name = "contents05" value = "dietryfiber-1,omega3-1">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect15}">
		06. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents06" value = "vitaminC-1">${question.contents01}<br/>
			<input type = "radio" name = "contents06" value = "vitaminC-1">${question.contents02}<br/>
			<input type = "radio" name = "contents06" value = "omega3-1">${question.contents03}<br/>
			<input type = "radio" name = "contents06" value = "0">${question.contents05}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect16}">
		07. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents07" value = "vitaminC-1,lutein-1">${question.contents01}<br/>
			<input type = "radio" name = "contents07" value = "lutein-1,vitaminA-1">${question.contents02}<br/>
			<input type = "radio" name = "contents07" value = "omega3-1">${question.contents04}<br/>
			<input type = "radio" name = "contents07" value = "calcium-1,vitaminC-1">${question.contents05}<br/>
			<input type = "radio" name = "contents07" value = "vitaminB-1">${question.contents06}<br/>
			<input type = "radio" name = "contents07" value = "0">${question.contents07}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<c:forEach var = "question" items = "${qSelect17}">
		08. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents08" value = "milkthistle-1">${question.contents01}<br/>
			<input type = "radio" name = "contents08" value = "omega3-1">${question.contents02}<br/>
			<input type = "radio" name = "contents08" value = "calcium-1,phosphorus-1,vitaminK-1">${question.contents03}<br/>
			<input type = "radio" name = "contents08" value = "0">${question.contents04}<br/>
		</c:if>
	</c:forEach>
	<br/>
	
	<div id = "c09_w" style = "display: none">
		<c:forEach var = "question" items = "${qSelect18}">
			09. ${question.title}<br/>
			<c:if test = "${question != null}">
				<input type = "radio" name = "contents09" value = "mineral-1">${question.contents01}<br/>
				<input type = "radio" name = "contents09" value = "gammalinolenic-1">${question.contents02}<br/>
				<input type = "radio" name = "contents09" value = "0">${question.contents03}<br/>
			</c:if>
		</c:forEach>
		<br/>
	</div>
	
	<!--
	<c:forEach var = "question" items = "${qSelect19}">
		10. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents10" value = "1">${question.contents01}<br/>
			<input type = "radio" name = "contents10" value = "2">${question.contents02}<br/>
			<input type = "radio" name = "contents10" value = "3">${question.contents03}<br/>
			<input type = "radio" name = "contents10" value = "4">${question.contents04}<br/>
		</c:if>
	</c:forEach>
	<br/>
	-->
	
	<!--
	<c:forEach var = "question" items = "${qSelect20}">
		11. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents11" value = "1">${question.contents01}<br/>
			<input type = "radio" name = "contents11" value = "2">${question.contents02}<br/>
			<input type = "radio" name = "contents11" value = "3">${question.contents03}<br/>
		</c:if>
	</c:forEach>
	<br/>
	-->
	<!--
	<c:forEach var = "question" items = "${qSelect21}">
		10. ${question.title}<br/>
		<c:if test = "${question != null}">
			<input type = "radio" name = "contents12" value = "1">${question.contents01}<br/>
			<input type = "radio" name = "contents12" value = "2">${question.contents02}<br/>
			<input type = "radio" name = "contents12" value = "3">${question.contents03}<br/>
			<input type = "radio" name = "contents12" value = "4">${question.contents04}<br/>
			<input type = "radio" name = "contents12" value = "5">${question.contents05}<br/>
			<input type = "radio" name = "contents12" value = "6">${question.contents06}<br/>
			<input type = "radio" name = "contents12" value = "7" onclick = "etc_show();">${question.contents07}<br/>
		</c:if>
	</c:forEach>
	<br/>
	<div id = "etc" style = "display: none"><input type = "text" name = "contents12"></div>
	-->
	<input type = "submit" value = "결과">
</form>