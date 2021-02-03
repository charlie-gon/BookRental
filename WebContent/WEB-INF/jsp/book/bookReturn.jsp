<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 반납 Form</title>

<style>
	tr{cursor:pointer}
</style>

<script>
	function bookReturnSubmit(str){
		var msg = confirm("해당 도서를 반납하시겠습니까?");
		frm.bCode.value = str;
		frm.action = "bookReturnUpdate.do";
		frm.submit();
	}
</script>
</head>
<body>

	<jsp:include page="../common/menu.jsp" />

	<div align="center">
		<div>
			<h1>반납 예정 도서 목록</h1>
		</div>
		<div>
			<form id="frm" name="frm " method="post">
				<input type="hidden" id="bCode" name="bCode">
				<table border="1">
				
					<tr>
						<th width="100">도서코드</th>
						<th width="100">도서명</th>
						<th width="100">기본수량</th>
						<th width="100">현재수량</th>
					</tr>

					<c:choose>
						<c:when test="${vo.bCount <= 5 }">
							<c:forEach var="vo" items="${list }">
								<tr align="center" onclick="bookReturnSubmit(${vo.bCode})">
									<td width="100">${vo.bCode }</td>
									<td width="100">${vo.bName }</td>
									<td width="100">${vo.bQty }</td>
									<td width="100">${vo.bCount }</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<td width="100" colspan="4" align="center" style="color:red">대여 예정 도서가 없습니다.</td>
						</c:otherwise>
					</c:choose>
				</table>
				
				<p/>
				<button type="button" onclick="location.href='main.do'">HOME</button>
				
			</form>
		</div>
	</div>

</body>
</html>