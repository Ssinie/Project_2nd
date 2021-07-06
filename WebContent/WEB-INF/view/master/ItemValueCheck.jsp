<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="/Project_2nd/js/jquery-1.10.2.min.js"></script>
<script src="/Project_2nd/js/socket.io.js"></script>
<script type="text/javascript">
   timerOn = false;
   expnowminsec = 0;
   // Ajax 통신중인지를 확인하는 전역변수 설정


   // Ajax 요청 이전에 확인하는 timer() 함수를 생성
   timer = function(delay) {
      var delayVal = delay || 1000;
      if (timerOn) {
         // timer에 현재시간을 설정
         nowTime = new Date;
         nowmin = nowTime.getMinutes()*60*1000;
         nowsec = nowTime.getSeconds() * 1000;
         nowmillisec = nowTime.getMilliseconds();
         nowminsec = nowmin + nowsec + nowmillisec;
      }
      else {
         nowTime = new Date;
         nowmin = nowTime.getMinutes()*60*1000;
         nowsec = nowTime.getSeconds() * 1000;
         nowmillisec = nowTime.getMilliseconds();
         expnowminsec = nowmin + nowsec + nowmillisec + delay;
         timerOn = true;
         return true;
       }

       if (((timerOn)) && (expnowminsec != 0) && (expnowminsec != '')) {
          if (expnowminsec <= nowminsec) {
              timerOn = false;
              expnowminsec = 0;
              return false;
          }
          else {
             timerOn = true;
             return true;
          }
       }
       timerOn = true;
       return true;
   }
</script>

<script type="text/javascript">
if (timer(delay) == false) {
   $.ajax({
      ...
   });
}
</script>
</head>
<body>
<a>딜레이 체크</a><br />
${nowTime} : ${nowmin} : ${nowsec}
</body>
