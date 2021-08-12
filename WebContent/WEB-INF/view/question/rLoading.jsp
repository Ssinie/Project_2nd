<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<script src="//code.jquery.com/jquery-3.6.0.min.js"></script>
		
		<script language="JavaScript">
        	setTimeout("location.href='qResult.do'",1000);
        	setTimeout("pInfo()",1000);
      		function pInfo(){
      			nick = "${nick}";
      			age = "${age}";
      			weight = "${weight}";
      			height = "${height}";
      			gender = "${gender}";
      			location.href = "qResult.do?nick="+nick+"&age="+age+"&weight="+weight+"&height="+height+"&gender="+gender+";
      		}
      	</script>
		
		<!-- 
		<script type="text/javascript">
			var url='qResult.do?contents=${contents}'
			setTimeout("location.href='${url}'", 5000);
		</script>
		 -->
		 
		<style>
			img {
			  margin: 0 auto;
			  display: block;
			  margin-top: 10%;
			}
		</style>
	
	</head>
	
	<body>
	
		<a href="qResult.do"><img src="https://colorlib.com/wp/wp-content/uploads/sites/2/colorlib-push-logo.png" alt="Colorlib logo"></a>
		<h1 style="text-align:center;">결과 페이지로 이동 중입니다.</h1>
		<p style="text-align:center;"><strong>잠시만 기다려주세요.</strong></p>
		<p style="text-align:center;"><strong>최대 2-4분 정도 소요 될 수 있습니다.</strong></p>
		<br>
		<p style="text-align:center;">Nutrient Sunday는 정보 중개자로서, 상품 판매와는 직접적인 관련이 없습니다.
		<p style="text-align:center;">쇼핑몰로 이동 후 주문, 배송, 환불에 대한 책임은 해당 쇼핑몰에 있습니다.
		<p style="text-align:center;">자세한 내용은 Nutrient Sunday <a href="#">공지사항</a>을 참조 바랍니다.</p>
	
	</body>
</html>