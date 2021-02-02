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
	function updateAlert() {
		var yn = confirm("수정하시겠습니까?");
		if (yn) {
			frm.action = "adminUpdate.do";
			frm.submit();
		}

	}
</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>수정페이지 회원명만 수정가능</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<input type="hidden" id="mId" name="mId" value="${vo.mId}">
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
					<c:if test="${not empty vo }">
						<tr>
							<td width="100"><input type="text" id="mId" name="mId"
								value="${vo.mId }" readonly="readonly"></td>
							<td width="100"><input type="text" id="mName" name="mName"
								value="${vo.mName }"></td>
							<td width="100"><input type="password" id="mPassword"
								name="mPassword" value="${vo.mPassword }" readonly="readonly"></td>
							<td width="100"><input type="tel" id="mTel" name="mTel"
								value="${vo.mTel }" readonly="readonly"></td>
							<td width="100"><input type="text" id="mAddress"
								name="mAddress" value="${vo.mAddress }" readonly="readonly"></td>
							<td width="100"><input type="text" id="mAuth" name="mAuth"
								value="${vo.mAuth}" readonly="readonly"></td>
						</tr>
					</c:if>
				</table>
				<br>
				<button type="button" onclick="updateAlert()">수정</button>
				&nbsp;&nbsp;
				<button type="button" onclick="location.href='adminList.do'">목록</button>
				<br>
			</div>
		</form>
	</div>
</body>
</html>