<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function login(){
		var f = document.frm;
		if(!f.mId.value){
			alert("아이디를 입력하세요.");
			f.mId.focus();
			return;
		}
		if(!f.mPassword.value){
			alert("비밀번호를 입력하세요.");
			f.mPassword.focus();
			return;
		}
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
            <button type="submit" onclick="login()">로그인</button>&nbsp;&nbsp;
            <button type="reset" onclick="memberJoin.do">회원가입</button>
            </div>
         </div>
      </form>
      
      <% 
      	String msg = request.getParameter("msg");
      if(msg != null && msg.equals("0")){
    	  out.println("<br>");
    	  out.println("<font color='red' size='5'>비밀번호를 확인해 주세요.</font>");
      }
      else if(msg!=null && msg.equals("-1"))
      {    
          out.println("<br>");
          out.println("<font color='red' size='5'>아이디를 확인해 주세요.</font>");
      }

      %>
   </div>
</body>
</html>