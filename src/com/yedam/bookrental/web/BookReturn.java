package com.yedam.bookrental.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.BookRentalDAO;
import com.yedam.bookrental.vo.BookRentalVO;

public class BookReturn implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 반납 Form 전달
		
		BookRentalDAO dao = new BookRentalDAO();
		ArrayList<BookRentalVO> list = new ArrayList<BookRentalVO>();

		list = dao.selectList();
		request.setAttribute("list", list);

		HttpSession session = request.getSession();
		String mId = (String) session.getAttribute("mId");
		
		BookRentalVO vo = new BookRentalVO();
		vo.setmId(mId);
		vo = dao.select(vo);
		
		return "book/bookReturn";
	}

}
