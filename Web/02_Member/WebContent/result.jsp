<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- '주소'에 사는 '나이'세인 '이름' 가입 완료!  <-- h1 태그 사용  -->
	<h1>
	<%= request.getParameter("addr") %>에 사는 <%= request.getParameter("age") %>세인 
	<%= request.getParameter("name") %> 가입 완료!
	</h1>
</body>
</html>