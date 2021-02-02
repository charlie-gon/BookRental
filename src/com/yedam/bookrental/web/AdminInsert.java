package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.MemberDAO;
import com.yedam.bookrental.vo.MemberVO;

public class AdminInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 관리자-등록
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setmId(request.getParameter("mId"));
		vo.setmName(request.getParameter("mName"));
		vo.setmPassword(request.getParameter("mPassword"));
		vo.setmTel(request.getParameter("mTel"));
		vo.setmAddress(request.getParameter("mAddress"));

		dao.memberInsert(vo);
				
		return "adminList.do";
	}

}
