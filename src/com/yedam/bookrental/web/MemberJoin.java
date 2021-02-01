package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;

public class MemberJoin implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 회원가입 Form 전달
		return "book/memberJoin";
	}

}
