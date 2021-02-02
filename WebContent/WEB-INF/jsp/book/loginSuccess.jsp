<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginSuccess</title>
</head>
<body>
<jsp:include page="../common/menu.jsp" />

<div align="center">
	<h1>${mname }님 환영합니다.</h1><br/>
	<h2>권한: ${mauth }</h2>
</div>

</body>
</html>