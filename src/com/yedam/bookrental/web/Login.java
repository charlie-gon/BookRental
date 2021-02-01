package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.MemberDAO;
import com.yedam.bookrental.vo.MemberVO;

public class Login implements Command {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
	   
	   String id = request.getParameter("mId");
	   String pwd = request.getParameter("mPassword");
	   
	   MemberDAO dao = new MemberDAO();
	   int check = dao.checkMember(id, pwd);
	   
	   HttpSession session = request.getSession();
	   
	   String viewPage = "";
	   if(check == 1) {
		   session.setAttribute("sessionId", id);
		   viewPage = "book/loginSuccess";
	   }
	   else {
		   viewPage = "book/loginFail";
	   }
	   
	   return viewPage;
   
	   	

	}
}