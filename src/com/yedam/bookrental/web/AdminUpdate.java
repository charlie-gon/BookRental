package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.MemberDAO;
import com.yedam.bookrental.vo.MemberVO;

public class AdminUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 관리자-수정
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();

		vo.setmId(request.getParameter("mId"));
		vo.setmName(request.getParameter("mName"));
		int n = dao.memberUpdate(vo);
		String viewPage = null;
		if (n != 0) {
			viewPage = "adminView.do";
		}

		return viewPage;
	}

}
