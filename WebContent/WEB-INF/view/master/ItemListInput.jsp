<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<% int i = 1; %>
<table border="1">
	<tr>
		<td>num</td>
		<td>제품번호</td>
		<td>비타민A</td>
		<td>비타민B</td>
		<td>비타민C</td>
		<td>비타민D</td>
		<td>비타민E</td>
		<td>비타민K</td>
		<td>오메가3</td>
		<td>루테인</td>
		<td>프로바이오틱스</td>
		<td>칼슘</td>
		<td>콜라겐</td>
		<td>홍삼</td>
		<td>마그네슘</td>
		<td>미네랄</td>
		<td>아연</td>
		<td>비오틴</td>
		<td>밀크씨슬</td>
		<td>철</td>
		<td>프로폴리스</td>
		<td>아미노산</td>
		<td>식이섬유</td>
		<td>감마리놀레산</td>
		
	</tr>
	<c:forEach var="IKVDTO" items="${result}">
	<tr>
		<td><%=i%></td>
		<td>${IKVDTO.PRDLST_REPORT_NO}</td>
		<td>${IKVDTO.vitaA}</td>
		<td>${IKVDTO.vitaB}</td>
		<td>${IKVDTO.vitaC}</td>
		<td>${IKVDTO.vitaD}</td>
		<td>${IKVDTO.vitaE}</td>
		<td>${IKVDTO.vitaK}</td>
		<td>${IKVDTO.omega3}</td>
		<td>${IKVDTO.lutein}</td>
		<td>${IKVDTO.probiotics}</td>
		<td>${IKVDTO.calcium}</td>
		<td>${IKVDTO.collagen}</td>
		<td>${IKVDTO.redGinseng}</td>
		<td>${IKVDTO.magnesium}</td>
		<td>${IKVDTO.mineral}</td>
		<td>${IKVDTO.zinc}</td>
		<td>${IKVDTO.biotin}</td>
		<td>${IKVDTO.milkthistle}</td>
		<td>${IKVDTO.iron}</td>
		<td>${IKVDTO.propolis}</td>
		<td>${IKVDTO.amino}</td>
		<td>${IKVDTO.dietryfiber}</td>
		<td>${IKVDTO.gammalinolenic}</td>
	</tr>
	<% ++i; %>
	</c:forEach>
</table>