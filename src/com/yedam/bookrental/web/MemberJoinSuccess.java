package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.MemberDAO;
import com.yedam.bookrental.vo.MemberVO;

public class MemberJoinSuccess implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 확인
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		
		vo.setmId(request.getParameter("id"));
		vo.setmName(request.getParameter("name"));
		vo.setmPassword(request.getParameter("password"));
		vo.setmTel(request.getParameter("phone"));
		vo.setmAddress(request.getParameter("address"));
		request.setAttribute("vo", vo);
		String viewPage = null;
		int n = dao.memberInsert(vo);
		
		if(n != 0) {
			viewPage = "joinSuccess.do";
		}
		
		return viewPage;
	}

}
