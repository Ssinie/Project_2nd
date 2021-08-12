<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

    <title></title>
    
    <style type="text/css">
        #wrap{
            text-align: center;
        }
    </style>
    
    <script type="text/javascript">
        
        function changeView(value){
            
            if(value == "1") // 관리자 계정
            {
                location.href="/Project_2nd/manager/hello.ns?contentPage=getBoardList";
            }
            else if(value == "2") // 테스트 질문
            {
                location.href="/Project_2nd/manager/hello.ns?contentPage=/question/getBoardList";
            }
            else if(value == "3") // 테스트 값
            {
                location.href="/Project_2nd/manager/hello.ns?contentPage=question/getValueList";
            }
            else if(value == "4") // 건강정보
            {
                location.href="/Project_2nd/manager/hello.ns?contentPage=healthy/getBoardList";
            }
            else if(value == "5") // 제품 등록
            {
                location.href="/Project_2nd/manager/hello.ns?contentPage=/master/item";
            }
            else if(value == "6") // 공지사항
            {
                location.href="/Project_2nd/manager/hello.ns?contentPage=/notice/board";
            }
            
        }
    </script>
    
</head>
<body>

<div id="wrap">

	<c:if test="${mem != null }">
		<p>${mem.id }님 반갑습니다.</p>
		<input type="button" onclick='location.href="/Project_2nd/manager/managerlogout.ns"' value="로그아웃"/>
	</c:if>
	
	<div>
		<button id="" class="btn btn-primary" onclick="changeView(1)">관리자 계정</button>
		<button id="" class="btn btn-primary" onclick="changeView(2)">설문지 질문</button>
		<button id="" class="btn btn-primary" onclick="changeView(3)">설문지 값</button>
		<button id="" class="btn btn-primary" onclick="changeView(4)">건강정보</button>
		<button id="" class="btn btn-primary" onclick="changeView(5)">제품 등록</button>
		<button id="" class="btn btn-primary" onclick="changeView(6)">공지사항</button>
	</div>

	
</div>

</body>
</html>