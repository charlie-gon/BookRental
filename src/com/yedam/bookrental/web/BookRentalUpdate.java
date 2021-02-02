package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.BookRentalDAO;
import com.yedam.bookrental.vo.BookRentalVO;

public class BookRentalUpdate implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 대여 확인 form 전달
		
		BookRentalDAO dao = new BookRentalDAO();
		BookRentalVO vo = new BookRentalVO();
		
		vo.setbCode(request.getParameter("bCode"));
		request.setAttribute("vo", vo);
		
		int n = dao.bookInsert(vo);
		String viewPage = null;
		
		if(n != 0) {
			viewPage = "book/bookRentalUpdate";
		}
		
		return viewPage;
	}

}
