package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.bookrental.common.Command;

public class LogOut implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃
		
		HttpSession session = request.getSession();
		session.invalidate();
				
		return "main/main";
	}

}
