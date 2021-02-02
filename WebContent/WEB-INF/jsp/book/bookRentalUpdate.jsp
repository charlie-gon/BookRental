<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 대여 확인 Form</title>
</head>
<body>
	<jsp:include page="../common/menu.jsp" />

	<div align="center">
		<div>
			<h1>대여 완료</h1>
		</div>
		<div>
			<table border="1">
				<tr>
					<th width="100">대여일자</th>
					<th width="100">도서코드</th>
					<th width="100">회원아이디</th>
					<th width="100">반납일자</th>
				</tr>
						<tr align="center">
							<td width="100">${vo.rentalDate }</td>
							<td width="100">${vo.bCode }</td>
							<td width="100">${vo.mId }</td>
							<td width="100">${vo.returnDate }</td>
						</tr>
			</table>
			<p />
			<div block="inline-block">
				<button type="button" onclick="location.href='bookRental.do'">대여 목록</button>
				<button type="button" onclick="location.href='main.do'">HOME</button>
			</div>

		</div>
	</div>
</body>
</html>