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
		
		vo = dao.select(vo);
		vo.setbCode(request.getParameter("bCode"));
		
		int n = dao.bookInsert(vo);
		String viewPage = null;
		if(n != 0) {
			viewPage = "book/bookRentalUpdate";
		}
		request.setAttribute("vo", vo);
		
		return viewPage;
	}

}
