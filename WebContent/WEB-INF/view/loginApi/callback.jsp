<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.2.js" charset="utf-8"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.3.min.js"></script>

<script type="text/javascript">
	if(${preUrl == null}){
		location.replace("/Project_2nd/main.ns");
	}else{
		location.replace('${preUrl}');
	}
</script>
</head>

<body>
	여기는 callback
</body>
</html>
