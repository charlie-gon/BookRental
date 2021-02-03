package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.MemberDAO;

public class idCheck implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 아이디 중복체크
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = 0;
		String id = (request.getParameter("id"));
		 cnt = dao.isIdCheck(id);
		
		String message = null;
		if(cnt == 1) {
			message = "이미 사용중인 아이디";
		}else {
			message = "사용할 수 있는 아이디";
		}
		
		request.setAttribute("msg", message);
		
		return "book/idCheck";
	}

}
