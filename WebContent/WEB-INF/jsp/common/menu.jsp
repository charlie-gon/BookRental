<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu Page</title>
<style>

ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #333;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: red;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f9f9f9;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {background-color: #f1f1f1;}

.dropdown:hover .dropdown-content {
  display: block;
}

</style>
</head>
<body>
	<div align="center">
		<h1>도서 대여 관리</h1>
	</div>
	<ul>
		<li><a href="main.do">Home</a></li>
		<c:if test="${mauth == 'USER' and not empty mname}">
		<li class="dropdown">
		<a href="javascript:void(0)" class="dropbtn">마이 라이브러리</a>
			<div class="dropdown-content">
				<!-- <a href="bookList.do">조회</a>  -->
				<a href="bookRental.do">대여</a> 
				<a href="bookReturn.do">반납</a>
			</div>
		</li>
		</c:if>
		
		<c:if test="${mauth == 'ADMIN' and not empty mname}">
		<li class="dropdown">
		<a href="javascript:void(0)" class="dropbtn">관리자</a>
			<div class="dropdown-content">
				<a href="adminInsertForm.do">추가</a> 
				<a href="adminList.do">관리</a> 
				<a href="adminUpdateForm.do">수정</a>
				<a href="adminDelete.do">삭제</a>
			</div>
		</li>
		</c:if>
		
		<c:if test="${empty mname }">
		<li><a href="memberJoin.do">회원가입</a></li>
		<li><a href="loginForm.do">Login</a></li>
		</c:if>
		
		<c:if test="${not empty mname }">
		<li><a href="logOut.do">Logout</a></li>
		</c:if>
	</ul>

</body>
</html>