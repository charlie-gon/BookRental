<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
 <style>
        #wrap{
            width:530px;
            margin-left:auto; 
            margin-right:auto;
            text-align:center;
        }
        
        table{
            border:3px solid skyblue
        }
        
        td{
            border:1px solid skyblue
        }
        
        #title{
            background-color:skyblue
        }
    </style>

<script>
	function checkValue(){
		if(!document.frm.id.value){
			alert("아이디를 입력하세요.");
			return false;
		}
		if(!document.frm.password.value){
			alert("비밀번호를 입력하세요.");
			return false;
		}
		if(document.frm.password.value != document.frm.passwordc.value){
			alert("비밀번호를 동일하게 입력하세요.");
			return false;
		}
		
	}
	
	function goMain(){
		location.href = "main.do";
	}
	
</script>

</head>
<body>
<jsp:include page="../common/menu.jsp" />
	<div id="wrap">
		<br>
		<br> <b><font size="6">회원가입</font></b> <br>
		<br>

		<form align="left" id="frm" name="frm" action="memberJoinSuccess.do" onsubmit="checkValue()" method="post">
			<table>
				<tr>
					<td id="title">아이디</td>
					<td><input type="text" name="id" maxlength="20"> <input type="button" value="중복확인"></td>
				</tr>

				<tr>
					<td id="title">비밀번호</td>
					<td><input type="password" name="password" maxlength="15">
					</td>
				</tr>

				<tr>
					<td id="title">비밀번호 확인</td>
					<td><input type="password" name="passwordc" maxlength="15">
					</td>
				</tr>

				<tr>
					<td id="title">이름</td>
					<td><input type="text" name="name" maxlength="40"></td>
				</tr>

				<tr>
					<td id="title">휴대전화</td>
					<td><input type="text" name="phone" /></td>
				</tr>
				<tr>
					<td id="title">주소</td>
					<td><input type="text" size="50" name="address" /></td>
				</tr>
			</table>
			<br> 
			<div align="center">
			<input type="submit" value="가입" /> 
			<input type="button" onclick="goMain()" value="취소" />
			</div>
		</form>
	</div>


</body>
</html>