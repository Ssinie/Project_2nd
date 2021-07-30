<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	li {list-style: none; float: left; padding: 6px;}
</style>
</head>
<body>
<center>
<h1>설문지 내용</h1>
<p>총 게시글 수:(${pageMaker.totalCount }개)</p>
<a href="/Project_2nd/manager/hello.ns">홈</a>
<table border="1" cellpadding="0" cellspacing="0">
<tr>
	<th width="70" bgcolor="#65e08c">번호</th>
	<th width="400" bgcolor="#65e08c">제목</th>
</tr>
<c:forEach items="${boardList }" var="board">
<tr>
	<td align="center">${board.num }</td>
	<td align="center"><a href="getBoard.do?num=${board.num }">${board.title }</a></td>
</tr>
</c:forEach>
</table>

<div style="display: inline-block;">
 <ul>
  <c:if test="${pageMaker.prev}">
   <li><a href="getBoardList.do${pageMaker.makeQuery(pageMaker.startPage - 1)}">이전</a></li>
  </c:if> 
  
  <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
   <li><a href="getBoardList.do${pageMaker.makeQuery(idx)}">${idx}</a></li>
  </c:forEach>
    
  <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
   <li><a href="getBoardList.do${pageMaker.makeQuery(pageMaker.endPage + 1)}">다음</a></li>
  </c:if> 
 </ul>
</div>
</center>
</body>
</html>