<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 조회</title>
</head>
<body>
<jsp:include page="../common/menu.jsp" />

	<div align="center">
		<div>
			<h1>전체 도서 목록</h1>
		</div>
		<div>
			<form id="frm" name="frm " method="post">
				<table border="1">
					<tr>
						<th width="100">도서코드</th>
						<th width="100">도서명</th>
						<th width="100">기본수량</th>
						<th width="100">현재수량</th>
					</tr>

					<c:forEach var="vo" items="${list }">
						<tr align="center">
							<td width="100">${vo.bCode }</td>
							<td width="100">${vo.bName }</td>
							<td width="100">${vo.bQty }</td>
							<td width="100">${vo.bCount }</td>
						</tr>
					</c:forEach>
				</table>
				<p/>
				<button type="button" onclick="location.href='main.do'">HOME</button>
				
			</form>
		</div>
	</div>


</body>
</html>