<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
  <script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<!--   <style type="text/css"> 
  html, div, body{
      margin: 0;
      padding: 0;
  }
  .login{
      display: inline-block;
      text-align: center;
  }
  
  </style> -->
</head>
<body>

	<!-- 네이버 로그인 화면으로 이동 시키는 URL -->
	<!-- 네이버 로그인 화면에서 ID, PW를 올바르게 입력하면 callback 메소드 실행 요청 -->
	<div id="naver_id_login" style="text-align:center"><a href="${url}"><img width="23" height="23" src="img/naver.png"/></a></div>
	<div id="kakao_id_login" style="text-align:center"><a href="https://kauth.kakao.com/oauth/authorize?client_id=cab40a487624fe914d53ae28da0663b8&redirect_uri=http://localhost:8080/Project_2nd/kakao.ns&response_type=code"><img width="24" height="24" src="img/kakao.png"/></a></div>
		
</body>
</html>