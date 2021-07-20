<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/myPage.css">
</head>
<body>

<div id="headline"><a href="http://localhost:8080/Project_2nd/mypage.ns">마이페이지</a></div>

<div id="side">
	<div class="side_menu">맞춤 영양제</div>
	<div class="side_menu">관심 영양제</div>
	<div class="side_menu">내 문의내역</div>
	<div class="side_menu">내 정보수정</div>
</div>

<div id="body">
	<div class="body_headline">맞춤 영양제</div>
	<div class="body_content">
		<div class="item_list">
			<div class="item">영양제 1</div>
			<div class="item">영양제 2</div>
			<div class="item">영양제 3</div>
		</div>
		<div class="more_info"><a href="#">더보기</a></div>
	</div>
</div>

</body>
</html>