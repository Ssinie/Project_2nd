<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h1>qResult.</h1>

<div id = result>
	<form method = "post" action = "aResult.do">
		${param.nick} 님에게 추천 드리는 영양제는...<br/>
		<c:choose>
			<c:when test = "${pResult01.BSSH_NM == pResult02.BSSH_NM || pResult01.BSSH_NM == pResult02.BSSH_NM || pResult01.BSSH_NM == pResult03.BSSH_NM || pResult01.BSSH_NM == pResult04.BSSH_NM || pResult01.BSSH_NM == pResult05.BSSH_NM}">
				${pResult01.BSSH_NM} 의  ${pResult01.PRDLST_NM} 입니다!
			</c:when>
			<c:when test = "${pResult02.BSSH_NM == pResult03.BSSH_NM || pResult02.BSSH_NM == pResult04.BSSH_NM || pResult02.BSSH_NM == pResult05.BSSH_NM || pResult01.BSSH_NM == pResult05.BSSH_NM}">
				${pResult02.BSSH_NM} 의  ${pResult02.PRDLST_NM} 입니다!
			</c:when>
			<c:when test = "${pResult03.BSSH_NM == pResult04.BSSH_NM || pResult03.BSSH_NM == pResult05.BSSH_NM}">
				${pResult03.BSSH_NM} 의  ${pResult03.PRDLST_NM} 입니다!
			</c:when>
			<c:when test = "${pResult04.BSSH_NM == pResult05.BSSH_NM}">
				${pResult04.BSSH_NM} 의  ${pResult04.PRDLST_NM} 입니다!
			</c:when>
			<c:otherwise>
				${pResult05.BSSH_NM} 의  ${pResult05.PRDLST_NM} 입니다!
			</c:otherwise>
		</c:choose>
		<br/>
		나이: ${param.age}세<br/>
		몸무게: ${param.weight}kg<br/>
		신장: ${param.height}cm<br/>
		성별: <c:if test = "${param.gender == 'male'}">남성</c:if><c:if test = "${param.gender == 'female'}">여성</c:if><br/>
		<c:choose>
			<c:when test = "${pResult01.BSSH_NM == pResult02.BSSH_NM || pResult01.BSSH_NM == pResult03.BSSH_NM || pResult01.BSSH_NM == pResult04.BSSH_NM || pResult01.BSSH_NM == pResult05.BSSH_NM}">
				${pResult01.BSSH_NM} 의  ${pResult01.PRDLST_NM} 입니다!
			</c:when>
			<c:otherwise>
				${pResult01.BSSH_NM} 의  ${pResult01.PRDLST_NM} 입니다!
			</c:otherwise>
		</c:choose><br/>
		<c:choose>
			<c:when test = "${pResult02.BSSH_NM == pResult03.BSSH_NM || pResult02.BSSH_NM == pResult04.BSSH_NM || pResult02.BSSH_NM == pResult05.BSSH_NM && pResult02.BSSH_NM != pResult01.BSSH_NM}">
				${pResult02.BSSH_NM} 의  ${pResult02.PRDLST_NM} 입니다!
			</c:when>
			<c:otherwise>
				
			</c:otherwise>
		</c:choose><br/>
		<c:choose>
			<c:when test = "${pResult03.BSSH_NM == pResult04.BSSH_NM || pResult03.BSSH_NM == pResult05.BSSH_NM && pResult03.BSSH_NM != pResult01.BSSH_NM && pResult03.BSSH_NM != pResult02.BSSH_NM}">
				${pResult03.BSSH_NM} 의  ${pResult03.PRDLST_NM} 입니다!
			</c:when>
			<c:otherwise>
				
			</c:otherwise>
		</c:choose><br/>
		<c:choose>
			<c:when test = "${pResult04.BSSH_NM == pResult05.BSSH_NM && pResult04.BSSH_NM != pResult01.BSSH_NM && pResult04.BSSH_NM != pResult02.BSSH_NM && pResult04.BSSH_NM != pResult03.BSSH_NM}">
				${pResult04.BSSH_NM} 의  ${pResult04.PRDLST_NM} 입니다!
			</c:when>
			<c:otherwise>
				${pResult04.BSSH_NM} 의  ${pResult04.PRDLST_NM} 입니다!
			</c:otherwise>
		</c:choose><br/>
		<c:choose>
			<c:when test = "${pResult05.BSSH_NM != pResult01.BSSH_NM && pResult05.BSSH_NM != pResult02.BSSH_NM && pResult05.BSSH_NM != pResult03.BSSH_NM && pResult05.BSSH_NM != pResult04.BSSH_NM}">
				${pResult05.BSSH_NM} 의  ${pResult05.PRDLST_NM} 입니다!
			</c:when>
		</c:choose><br/>
		
		${pr.BSSH_NM} 의  ${pr.PRDLST_NM} 입니다!???<br/>
		${pr.BSSH_NM} 의  ${pr.PRDLST_NM} 입니다!???
		
		<c:forEach var = "pr" items = "${setList}">
    		${pr.BSSH_NM}
    		${r.BSSH_NM}
    		
		</c:forEach>
		
	</form>
</div>

<!--
<div id = result02>
	<form method = "post">
		${aResult.nick}님이 제일 필요한 영양소는 ${paramValues.contents} 입니다.
	</form>
</div>
-->