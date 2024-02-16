<%@page import="com.kh.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 관리 기능</h1>

	<ul>
	<%-- c:when test 값 : session과 request가 같기 때문에 sessionScope.member 대신 member로만 작성 가능 --%>
	<%-- 
		== : eq,
		!= : ne, 
		==null : empty, 
		!=null : not empty 
	--%>
		<c:choose>
			<c:when test="${empty member}">
				<li><a href="views/register.html">회원가입</a></li>
				<li><a href="views/login.html">로그인</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="views/search.html">회원검색</a></li>
				<li><a href="front.do?command=allShow">전체회원보기</a></li> <%-- 보여주는 html 페이지 없이 바로 페이지 이동이기 때문에 바로 링크 지정 --%>
				<li><a href="front.do?command=logout">로그아웃</a></li> <%-- 보여주는 html 페이지 없이 바로 페이지 이동이기 때문에 바로 링크 지정 --%>
			</c:otherwise>
		</c:choose>
	</ul>
</body>
</html>