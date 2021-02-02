<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 대여 Form</title>
</head>

<style>
	td{cursor:pointer}	
	
	#noticeYes{color:#0100ff}
	#noticeNo{color: #ff0000}
</style>

<script>
	function bookRentalSubmit(str){
		var msg = confirm("해당 도서를 대출하시겠습니까?");
		if(msg){
		frm.bCode.value = str;
		frm.action = "bookRentalUpdate.do";
		frm.submit();
		}
	}
</script>

<body>
	<jsp:include page="../common/menu.jsp" />

	<div align="center">
		<div>
			<h1>대여 가능 도서 목록</h1>
		</div>
		<div>
			<form id="frm" name="frm " method="post">
				<input type="hidden" id="bCode" name="bCode">
			</form>
				<table border="1">
					<tr>
						<th width="100">도서코드</th>
						<th width="100">도서명</th>
						<th width="100">기본수량</th>
						<th width="100">현재수량</th>
						<th width="100">대출여부</th>
					</tr>

					<c:forEach var="vo" items="${list }">
						<tr align="center" onclick="bookRentalSubmit(${vo.bCode})">
							<td width="100">${vo.bCode }</td>
							<td width="100">${vo.bName }</td>
							<td width="100">${vo.bQty }</td>
							<td width="100">${vo.bCount }</td>
							<c:if test="${vo.bCount != 0  }">
								<th width="100" id="noticeYes">대출가능</th>
							</c:if>
							<c:if test="${vo.bCount == 0  }">
								<th width="100" id="noticeNo">대출불가능</th>
							</c:if>
						</tr>
					</c:forEach>
				</table>
				<p/>
				<div block ="inline-block">
				<button type="button" onclick="location.href='main.do'">HOME</button>
				</div>
		</div>
	</div>
</body>
</html>