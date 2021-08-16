<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nutrients Sunday</title>
</head>
<c:if test="${mem != null }">
	<p>${mem.id }님 반갑습니다.</p>
	<input type="button" onclick='location.href="managerlogout.ns"' value="로그아웃"/>
</c:if>
<ul>
	<li><a href="/Project_2nd/manager/getManagerList.ns">관리자 계정</a>
    </li>
    
    <li>설문지 내용
        <ul>
        <li><a href="/Project_2nd/question/getBoardList.do">QUESTION</a></li>
        <li><a href="/Project_2nd/question/getValueList.do">QUESTION_VALUE</a></li>                  
        </ul>
    </li>
    
    <li><a href="/Project_2nd/healthy/healthyBoardList.ns">건강정보</a>
    </li>
    
    <li><a href="/Project_2nd/master/item.do">Item</a>
    </li>
    
    <li><a href="/Project_2nd/notice/board.do">공지사항</a>
    </li>
</ul>
<body>
</body>
</html>