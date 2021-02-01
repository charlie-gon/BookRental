<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginFail</title>
</head>
<body>
<jsp:include page="../common/menu.jsp" />

<div align="center">
	<h2><%= session.getAttribute("message") %></h2>
</div>
</body>
</html>