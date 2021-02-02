package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.MemberDAO;
import com.yedam.bookrental.vo.MemberVO;

public class AdminDelete implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setmId(request.getParameter("mId"));
		dao.memberDelete(vo);
		
		
		return "adminList.do";
	}

}
