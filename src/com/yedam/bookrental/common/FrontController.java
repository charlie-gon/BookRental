package com.yedam.bookrental.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.bookrental.web.AdminDelete;
import com.yedam.bookrental.web.AdminInsert;
import com.yedam.bookrental.web.AdminInsertForm;
import com.yedam.bookrental.web.AdminList;
import com.yedam.bookrental.web.AdminUpdate;
import com.yedam.bookrental.web.AdminUpdateForm;
import com.yedam.bookrental.web.AdminView;
import com.yedam.bookrental.web.BookList;
import com.yedam.bookrental.web.BookRental;
import com.yedam.bookrental.web.BookRentalUpdate;
import com.yedam.bookrental.web.BookReturn;
import com.yedam.bookrental.web.BookReturnUpdate;
import com.yedam.bookrental.web.LogOut;
import com.yedam.bookrental.web.Login;
import com.yedam.bookrental.web.LoginForm;
import com.yedam.bookrental.web.MainCommand;
import com.yedam.bookrental.web.MemberJoin;
import com.yedam.bookrental.web.MemberJoinSuccess;
import com.yedam.bookrental.web.idCheck;
import com.yedam.bookrental.web.joinSuccess;


/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		map.put("/main.do", new MainCommand()); // 메인 페이지
		
		map.put("/loginForm.do", new LoginForm());// 로그인
		map.put("/login.do", new Login());// 로그인 정보 송출
		map.put("/logOut.do", new LogOut()); // 로그아웃

		map.put("/memberJoin.do", new MemberJoin()); // 회원가입
		map.put("/idCheck.do", new idCheck()); // 아이디 중복체크
		map.put("/memberJoinSuccess.do", new MemberJoinSuccess()); // 회원가입 확인
		map.put("/joinSuccess.do", new joinSuccess()); // 회원가입 성공
		
		map.put("/bookList.do", new BookList()); // 도서 목록
		map.put("/bookRental.do", new BookRental()); // 도서 대여
		map.put("/bookRentalUpdate.do", new BookRentalUpdate()); // 도서 대여 확인
		map.put("/bookReturn.do", new BookReturn()); // 도서 반납
		map.put("/bookReturnUpdate.do", new BookReturnUpdate()); // 도서 반납 확인
		
		map.put("/adminList.do", new AdminList());// 관리자-전체리스트
		map.put("/adminView.do", new AdminView());// 관리자-상세보기
		map.put("/adminDelete.do", new AdminDelete());// 관리자-상세보기-삭제 Child record가 있으면 삭제가 안되도록
		map.put("/adminInsertForm.do", new AdminInsertForm());// 관리자-등록 폼
		map.put("/adminInsert.do", new AdminInsert());// 관리자-등록
		map.put("/adminUpdateForm.do", new AdminUpdateForm());// 관리자-수정 폼
		map.put("/adminUpdate.do", new AdminUpdate());//관리자-수정
	
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
request.setCharacterEncoding("utf-8");
		
		String contextPath = request.getContextPath();
		String uri = request.getRequestURI();
		String path = uri.substring(contextPath.length());
		
		Command command = map.get(path);
		String viewPage = command.execute(request, response);
		
		// View Resolve 설정하여 WEB-INF 내부 파일 접근 가능
		//if(viewPage.endsWith(".jsp")) viewPage = "/WEB-INF/jsp/" + viewPage; 
		
		// viewPage가 .do로 끝나지 않으면, viewPage를 "/WEB-INF/jsp/" + viewPage + ".jsp"과 같이 만들어라.
		// Command 호출 시 .jsp 없어도 OK
		if(!viewPage.endsWith(".do")) viewPage = "/WEB-INF/jsp/" + viewPage + ".jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
