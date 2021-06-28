<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="test.model.bean.memberDAO" %>
<%@ page import="test.model.bean.memberDTO" %>
<%@ page import="java.util.List"%>

<%
	memberDAO dao = new memberDAO();
	ArrayList list = dao.member();
	
for(int i = 0; i < list.size(); i++){
	memberDTO dto = (memberDTO)list.get(i);%>
	<h1>num = <%=dto.getNum()%></h1>
	<h1>name = <%=dto.getName() %></h1>
	<h1>reg_date = <%=dto.getReg_date() %></h1>
<%}%>

<h1>GIT 사용</h1>
<h1>이호재입니다.</h1>