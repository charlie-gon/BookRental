package com.yedam.bookrental.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.BookDAO;
import com.yedam.bookrental.vo.BookVO;

public class BookReturn implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 도서 반납 Form 전달
		
		BookDAO dao = new BookDAO();
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		list = dao.selectList();
		request.setAttribute("list", list);
		
		return "book/bookReturn";
	}

}
