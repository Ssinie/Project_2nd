<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- <script type="text/javascript" src="./js/product.js"></script> -->

<script type="text/javascript">

$(document).ready(function() {
	var id = '${id}'
	
	$("#wish").click(function() {
		if(id == ""){
			alert("로그인이 필요합니다.");
			//document.location.href="http://localhost:8080/Project_2nd/login.ns";
		}else{
			$.ajax({
				url: "/Project_2nd/wishlistPro.ns",
				data: { id:'${id}', num:'${num}', wishCheck:'${wishCheck}' },
				success: function(result){
					if(result == "1"){
						alert("관심상품 등록 완료");
					}
					if(result == "0"){
						alert("관심상품 삭제 완료");
					}
				}
			});
		}
		
	});
});

</script>

</head>
<body>

<h1>상품정보 페이지</h1>
<button id="wish">관심상품</button>

</body>
</html>