<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인성공</title>
</head>
<body>
<jsp:include page="../common/topmenu.jsp" />
<div align="center">
<div><h1> ${member.memberName }님 환영합니다.</h1></div>

<jsp:include page="../common/footer.jsp" />
</div>
</body>
</html>