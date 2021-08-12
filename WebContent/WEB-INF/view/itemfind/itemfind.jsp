<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<font size="4">
셀레니움 상품 수집<br /><br />
셀레니움을 활용해 동적 크롤링을 진행합니다.
<br /><br />
1. zip 파일을 다운받아, 각자의 경로에 추가합니다.<br /><br />
2. cmd 창을 2개 실행시켜, 아래와 같이 진행하여주세요.<br /><br />
3. 1번의 cmd창엔 자신의 R경로로 'cd'명령어를 이용한 후,<br />
'Rserve --RS-encoding utf8' 명령어를 입력하여주세요.<br />
경로 예) cd C:\Program Files\R\R-4.1.0\bin\x64<br /><br />
4. 2번의 cmd창엔 자신의 셀레니움을 셋팅한 환경으로 이동 후 아래의 명령어를 입력하여주세요.<br />
'java   -jar   selenium-server-standalone.jar   -port   4445'<br />
경로 예 'D:' > 'cd D:/r'<br /><br />
</font>

<form action="itemfindPro.do" >
<select name="subtag">
<c:forEach var="subtag" items="${subtag}">
	<option value="${subtag}">${subtag}</option>
</c:forEach>
</select>
<input type="number" name="count" min="75" />
<input type="submit" value="입력" />
</form>