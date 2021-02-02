package com.yedam.bookrental.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.BookDAO;
import com.yedam.bookrental.dao.BookRentalDAO;
import com.yedam.bookrental.vo.BookRentalVO;
import com.yedam.bookrental.vo.BookVO;
import com.yedam.bookrental.vo.MemberVO;

public class BookRental implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 대여 페이지 전달
		
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		BookVO vo = new BookVO();
		MemberVO mvo = new MemberVO();
		BookRentalVO rvo = new BookRentalVO();
		
		list = dao.selectList();
		request.setAttribute("list", list);
		
		request.setAttribute("vo", vo); // BookCode
		request.setAttribute("mvo", mvo); // MemberId
		request.setAttribute("rvo", rvo); // ReturnDate
		
		return "book/bookRental";
	}

}
