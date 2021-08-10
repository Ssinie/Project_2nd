<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<select name="subtag">
<c:forEach var="subtag" items="${subtag}">
	<option value="${subtag}">${subtag}</option>
</c:forEach>
</select>