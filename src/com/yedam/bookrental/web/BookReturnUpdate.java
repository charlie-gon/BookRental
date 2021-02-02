package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.BookRentalDAO;
import com.yedam.bookrental.vo.BookRentalVO;

public class BookReturnUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 반납 확인
		
		BookRentalDAO dao = new BookRentalDAO();
		BookRentalVO vo = new BookRentalVO();
		
		vo.setbCode(request.getParameter("bCode"));
		vo = dao.bookReturn(vo);
		request.setAttribute("vo", vo);
		
		return "book/bookReturnUpdate";
	}

}
