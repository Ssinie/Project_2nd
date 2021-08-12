<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

    <style type="text/css">
   		a { color: #000000; }
        #wrap { text-align: center; }
        #header, #content { margin-bottom: 30px; }
        .iframe { width:100%; height: 500px; }
    </style>
    
</head>
<body>

<div id="wrap">

	<div id="header">
		<c:if test="${mem != null }">
			<p>${mem.id }님 반갑습니다.</p>
			<input type="button" onclick='location.href="/Project_2nd/manager/managerlogout.ns"' value="로그아웃"/>
		</c:if>
	</div>
	
	<div id="content">
		<a href="/Project_2nd/manager/getManagerList.ns" target="iframe">관리자계정</a>
		<a href="/Project_2nd/question/getBoardList.do" target="iframe">테스트질문</a>
		<a href="/Project_2nd/question/getValueList.do" target="iframe">테스트값</a>
		<a href="/Project_2nd/healthy/getBoardList.ns" target="iframe">건강정보</a>
		<a href="/Project_2nd/master/item.do" target="iframe">제품등록</a>
		<a href="/Project_2nd/manager/board.do" target="iframe">공지사항</a>
	</div>
	
	<div id="iframe">
		<iframe name="iframe" class="iframe" src=""></iframe>
	</div>
	
</div>

</body>
</html>