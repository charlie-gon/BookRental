package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.BookDAO;
import com.yedam.bookrental.vo.BookVO;

public class BookReturnUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 반납 확인
		
		BookDAO dao = new BookDAO();
		BookVO vo = new BookVO();
		
		vo.setbCode(request.getParameter("bCode"));
		vo = dao.bookSelect(vo);
		request.setAttribute("vo", vo);
		
		return "book/bookReturnUpdate";
	}

}
