package com.yedam.bookrental.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.MemberDAO;
import com.yedam.bookrental.vo.MemberVO;

public class Login implements Command {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
	   
	   // 로그인 멤버 validation 처리
	   
	   MemberDAO dao = new MemberDAO();
	   MemberVO vo = new MemberVO();
	   
	   vo.setmId(request.getParameter("mId"));
	   vo.setmPassword(request.getParameter("mPassword"));
	   vo = dao.checkMember(vo);
	   
	   String viewPage = null;
	   
		   HttpSession session = request.getSession();
		   session.setAttribute("mname", vo.getmName());
		   session.setAttribute("mauth", vo.getmAuth());
		   session.setAttribute("mId", vo.getmId());
		   
			if (vo.getmAuth() != null) {
				viewPage = "book/loginSuccess";
			} else {
				viewPage = "book/loginFail";
			}
			request.setAttribute("vo", vo);
	   
	   return viewPage;

	}
}