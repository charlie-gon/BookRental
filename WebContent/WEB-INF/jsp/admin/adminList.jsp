<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table td {
	text-align: center;
}
</style>
<script>
function adminView(str){
	frm.mId.value=str;
	frm.action="adminView.do";
	frm.submit();
}
</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>관리자용 리스트</h1>
		</div>
		<form id="frm" name="frm" action="adminInsert.do" method="post">
			<input type="hidden" id="mId" name="mId">
			<div>
				<table border="1">
					<tr>
						<th width="100">회원아이디</th>
						<th width="100">회원명</th>
						<th width="100">회원패스워드</th>
						<th width="150">전화번호</th>
						<th width="100">회원주소</th>
						<th width="100">권한</th>
					</tr>

					<c:if test="${not empty list }">
						<c:forEach var="vo" items="${list}">
							<tr class="row" onclick="adminView(${vo.mId})">
								<td width="100" id="mId">${vo.mId}</td>
								<td width="100" id="mName">${vo.mName}</td>
								<td width="100">${vo.mPassword}</td>
								<td width="100">${vo.mTel}</td>
								<td width="100">${vo.mAddress}</td>
								<td width="100">${vo.mAuth}</td>
							</tr>
						</c:forEach>
					</c:if>
				</table><br>
				<button type="button" onclick="location.href='adminInsertForm.do'">등록</button>
			</div>
		</form>
	</div>
</body>
</html>