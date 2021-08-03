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
	li {list-style: none; display: flex;}
</style>
</head>
<body>
<center>
<p style="font-size: 30px">식품안전처에 등록된 API를 이용해 아래의 버튼을 눌러 진행할 수 있습니다.</p>
<p style="font-size: 30px">아래의 버튼 순서로 진행하여야 합니다.</p>
<ul>
	<li>
		1. 식품안전처에 등록된 제품정보 입력(10 단위 입력)
		<form action="iteminsert.do" method="post">
		<input type="text" name="input"/>
		<input type="submit" value="GO"/>
		</form>
	</li>
	<li>
		2. 등록된 제품의 키 값 추출
		<button type="button" onclick='location.href="ItemTypeKeyInsert.do"'>GO</button>
	</li>
	<li>
		3. 제품정보의 가중치 부여
		<button type="button" onclick='location.href="ItemTypeValueInsert.do"'>GO</button>
	</li>
	<li>
		4. 설문비교를 위한 가중치 재가공
		<button type="button" onclick='location.href="RetrunValueLists.do"'>GO</button>
	</li>
</ul>

</center>
</body>
</html>