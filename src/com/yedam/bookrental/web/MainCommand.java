package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;

public class MainCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {

		return "main/main";

	}

}
