<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function checkValue(){
		var f = document.frm;
		if(!f.mId.value){
			alert("아이디를 입력하세요.");
			f.mId.focus();
			return false;
		}
		
		if(!f.mPassword.value){
			alert("비밀번호를 입력하세요.");
			f.mPassword.focus();
			return false;
		}
		f.submit();
	}
	

	function goJoin(){
		location.href = "location.href='memberJoin.do";
	}
</script>
</head>
<jsp:include page="../common/menu.jsp" />
<body>
   <div align="center">
   <div><h1>로 그 인</h1></div>
      <form id="frm" name="frm" action="login.do" method="post">
         <div>
            <table border="1">
               <tr>
                  <th>아이디</th>
                  <td><input type="text" id="mId" name="mId"></td>
               </tr>
               <tr>
                  <th>패스워드</th>
                  <td><input type="password" id="mPassword" name="mPassword"></td>
               </tr>
            </table><br>
            <div>
            <input type="button" onclick = "checkValue()" value="로그인">&nbsp;&nbsp;
            <input type="reset" onclick="goJoin()" value="회원가입">
            </div>
         </div>
      </form>
      
   </div>
</body>
</html>