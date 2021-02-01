package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.BookDAO;
import com.yedam.bookrental.vo.BookVO;

public class BookRentalUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 대여 확인 form 전달
		
		BookDAO dao = new BookDAO();
		BookVO vo = new BookVO();
		
		vo.setbCode(request.getParameter("bCode"));
		vo = dao.bookRental(vo);
		request.setAttribute("vo", vo);
		
		return "book/bookRentalUpdate";
	}

}
