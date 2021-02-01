<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#topMenu {
	height: 30px;
	width: 1300px;
}

#topMenu ul li {
	list-style: none;
	color: white;
	background-color: #2d2d2d;
	float: left;
	line-height: 30px;
	vertical-align: middle;
	text-align: center;
}

#topMenu .menuLink {
	text-decoration: none;
	color: white;
	display: block;
	width: 145px;
	font-size: 12px;
	font-weight: bold;
	font-family: "Trebuchet MS";
}

#topMenu .menuLink:hover {
	color: red;
	background-color: #4d4d4d;
}
</style>
</head>
<body>
	<div align="center">
		<nav id="topMenu">
			<ul>
				<li><a class="menuLink" href="main.do">Home</a></li>
				<li>|</li>

				<li><a class="menuLink" href="bookList.do">조회</a></li>
				<li>|</li>

				<li><a class="menuLink" href="bookRental.do">대여</a></li>
				<li>|</li>
				
				<li><a class="menuLink" href="bookReturn.do">반납</a></li>
				<li>|</li>

				<li><a class="menuLink" href="#">관리</a></li>
				<li>|</li>
				
				<li><a class="menuLink" href="memberJoin.do">회원가입</a></li>
				<li>|</li>
				
				<li><a class="menuLink" href="#">Login</a></li>

				<li>|</li>
				<li><a class="menuLink" href="#">Logout</a></li>

			</ul>
		</nav>
	</div>
</body>
</html>