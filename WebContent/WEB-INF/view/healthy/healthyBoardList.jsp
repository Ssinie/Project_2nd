<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nutrients Sunday</title>
<style type="text/css">
	li {list-style: none; float: left; padding: 6px;}
</style>
</head>
<body>
<center>
<h1>게시글 목록</h1>
<p>총 게시글 수:(${pageMaker.totalCount }개)</p>
<p>현재 페이지: ${cri.page}페이지</p>
<br>
<c:if test="${mem != null }">
	<p>${mem.id }님 반갑습니다.</p>
	<input type="button" onclick='location.href="/Project_2nd/manager/hello.ns"' value="홈"/>
	<input type="button" onclick='location.href="insertBoardV.ns"' value="새글"/>
	<input type="button" onclick='location.href="crawling.ns"' value="크롤링"/>
	<button type="button" onclick='location.href="deleteAll.ns"'>전체삭제</button>
	<input type="button" onclick='location.href="/Project_2nd/manager/managerlogout.ns"' value="로그아웃"/>	
</c:if>
<c:if test="${mem == null }">
	<a href="/Project_2nd/index.ns">메인으로 돌아가기</a>
</c:if>
<table border="1" cellpadding="0" cellspacing="0" width="1050">
<tr>
	<th bgcolor="#b7a2de" width="100">번호</th>
	<th bgcolor="#b7a2de" width="400">제목</th>
	<th bgcolor="#b7a2de" width="150">작성자</th>
	<th bgcolor="#b7a2de" width="200">등록일</th>
	<th bgcolor="#b7a2de" width="200">수정일</th>
</tr>

<c:forEach items="${boardList }" var="board">
<tr>
	<td align="center">${board.num }</td>
	<c:if test="${board.writer eq 'naver' }"> 
		<td align="left"><a href="${board.content }">${board.title }</a></td>
	</c:if>
	<c:if test="${board.writer ne 'naver' }">
		<td align="left"><a href="getBoard.ns?num=${board.num }">${board.title }</a></td>
	</c:if>
	<td align="center">${board.writer }</td>
	<td align="center">${board.regdate }</td>
	<td align="center">${board.updateDate }</td>
</tr>
</c:forEach>
</table>
<div style="display: inline-block;">
 <ul>
  <c:if test="${pageMaker.prev}">
   <li><a href="getBoardList.ns${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
  </c:if> 
  
  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
   <li><a href="getBoardList.ns${pageMaker.makeQuery(idx)}">${idx}</a></li>
  </c:forEach>
    
  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
   <li><a href="getBoardList.ns${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
  </c:if> 
 </ul>
</div>




</center>
</body>
</html>