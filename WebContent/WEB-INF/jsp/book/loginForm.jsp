<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
            <button type="submit">로그인</button>&nbsp;&nbsp;
            <button type="reset">취소</button>
            </div>
         </div>
      </form>
   </div>
</body>
</html>