<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 쌍따옴표 사용 시 쌍타옴표 내 따옴표는 작은 따옴표 사용 -->
	<c:if test="${param.num == '1'}">
		<h2>1값이 들어왔습니다.</h2>
	</c:if>
	<!-- else 역할 없으므로 다른 조건 사용 원할경우 c:if 태그로 작성 -->
	<c:if test="${param.num != '1'}">
		<h2>1값이 들어오지 않았습니다.</h2>
	</c:if>
</body>
</html>