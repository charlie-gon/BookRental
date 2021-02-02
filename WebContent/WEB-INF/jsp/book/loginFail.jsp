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
	<h1>${vo.mName }님 아이디 또는 비밀번호가 틀렸습니다.</h1><br/>
	<button type="button" onclick="location.href='loginForm.do'">로그인</button>

</div>


</body>
</html>