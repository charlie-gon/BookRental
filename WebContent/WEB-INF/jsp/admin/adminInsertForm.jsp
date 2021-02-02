<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자등록</title>
<script>
	function alertInsert() {
		var yn = confirm("등록하시겠습니까?");
		if (yn) {

			frm.action = "adminInsert.do";
			frm.submit();
		}
	}
</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
	<div align="center">
		<div>
			<h1>사용자 등록 페이지</h1>
		</div>
		<form id="frm" name="frm" method="post">
			<div>
				<table border="1">
					<tr>
						<th>아이디</th>
						<td><input type="text" id="mId" name="mId" size=20
							required="required">
							<button>중복</button></td>
					</tr>
					<tr>
						<th>이 름</th>
						<td><input type="text" id="mName" name="mName" size=20
							required="required"></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" id="mPassword" name="mPassword"
							size=20 required="required"></td>
					</tr>
					<tr>
						<th>패스워드확인</th>
						<td><input type="password" id="mPassword2" name="mPassword2"
							size=20 required="required"></td>
					</tr>

					<tr>
						<th>전화번호</th>
						<td><input type="tel" id="mTel" name="mTel" size=20
							required="required"></td>
					</tr>

					<tr>
						<th>주 소</th>
						<td><input type="text" id="mAddress" name="mAddress" size=20
							required="required"></td>
					</tr>
				</table>
				<br>
				<div>
					<button type="button" onclick="alertInsert()">등록</button>
					&nbsp;&nbsp;
					<button type="reset">취소</button>
				</div>
			</div>
		</form>

	</div>
</body>
</html>