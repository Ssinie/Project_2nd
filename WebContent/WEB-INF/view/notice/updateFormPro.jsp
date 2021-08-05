<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${result == 1}">
	<meta http-equiv="Refresh" content="0;url=board.jsp" >
	   <script language="JavaScript">         
         alert("수정이 완료되었습니다.");
         window.location="board.do";
      </script>
</c:if>
<c:if test="${result == 0}">
	<script language="JavaScript">         
         alert("작성 중 오류가 발생하였습니다. 다시 작성하여주세요.");
         history.go(-1);
      </script>
</c:if>