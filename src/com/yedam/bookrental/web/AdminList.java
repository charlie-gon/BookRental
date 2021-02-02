package com.yedam.bookrental.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.MemberDAO;
import com.yedam.bookrental.vo.MemberVO;

public class AdminList implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		list = dao.selectMemberList();
		request.setAttribute("list", list);

		return "admin/adminList";
	}

}
