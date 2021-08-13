<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nutrient Sunday</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.14.0/css/all.css" integrity="sha384-HzLeBuhoNPvSl5KYnjx0BT+WB0QEEqLprO+NBkkk5gbc67FTaL7XIGa2w1L0Xbgc" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/Project_2nd/css/pForm.css">
</head>
<body>

<div id="wrap">

	<div id="content">
	
		<div class="title"><h1>맞춤 영양제 추천 테스트를 시작합니다.</h1></div>
		
		
		
		<div id="form">
			<form action = "/Project_2nd/question/pInsert.do" method = "post">
			<div id="left" class="display">
				<div class="subtitle"><h3>다음 정보를 기입해주세요.</h3></div>
				<div class="txt"><span>닉네임</span></div>
				<div class="insert"><input class="input" type = "text" name = "nick" required /></div>
				
				<div class="txt"><span>나이</span></div>
				<div class="insert"><input class="input" type = "number" min = "10" max = "120" name = "age" required /></div>
				
				
				<div class="txt"><span>키</span></div>
				<div class="insert"><input class="input" type = "number" min = "100" max = "250" name = "height" value = "h" required /></div>
				
				<div class="txt"><span>몸무게</span></div>
				<div class="insert"><input class="input" type = "number" min = "30" max = "300" name = "weight" value = "w" required /></div>
				
				<div class="txt"><span>성별</span></div>
				<div class="insert">
					<span>남</span><input class="input" type = "radio" name = "gender" value = "male" required />
					<span>여</span><input class="input" type = "radio" name = "gender" value = "female" required />
				</div>
				
				<div class="next"><input class="btn" type = "submit" value = "다음" /></div>
			</div>
				
			
			
			</form>
		</div>
		
	</div>

</div>

</body>
</html>