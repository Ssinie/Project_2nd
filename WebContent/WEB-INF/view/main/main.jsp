<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Nutrient Sunday</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js" ></script>
	<script type="text/javascript"></script>
</head>

<body>
	<!-- 헤더 -->
	<div id="header">
		<div class="btn">카테고리</div>
		<div class="btn">Nutrient Sunday</div>
		<div class="search">검색</div>
		<div class="btn"><a href="#"></a>고객센터</div> <!-- 고객센터 페이지 href 입력 필-->
		<div class="btn"><a href="http://localhost:8080/Project_2nd/login.ns">로그인</a></div>
	</div>
	
	<!-- 메인 -->
	<div id="main">
		<div id="container">
			<div class="banner">이것은 배너</div>
			
			<div class="headline">${nickname} 님에게 추천하는 영양제</div>
			<div class="subline">vitamin</div>
			<div class="item_list">
				<div class="item">
					<a href="#"><img src=""/></a> <!-- 상품 상세 페이지 href 입력 필요 -->
					<a href="http://localhost:8080/Project_2nd/product.ns">영양제 판매순 1위 이름</a>
				</div>
				<div class="item">
					<a href="#"><img src=""/></a> <!-- 상품 상세 페이지 href 입력 필요 -->
					<a href="#">영양제 판매순 2위 이름</a>
				</div>
				<div class="item">
					<a href="#"><img src=""/></a> <!-- 상품 상세 페이지 href 입력 필요 -->
					<a href="#">영양제 판매순 3위 이름</a>
				</div>
			</div> <!-- item_list -->
			
		</div>
	</div>
	
	<!-- 푸터 -->
	<div id="footer">
		<div class="btn">회사소개</div>
		<div class="btn">이용약관</div>
		<div class="btn">개인정보처리방침</div>
	</div>
	
</body>
</html>