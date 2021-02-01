package com.yedam.bookrental.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.bookrental.common.Command;
import com.yedam.bookrental.dao.MemberDAO;
import com.yedam.bookrental.vo.MemberVO;

public class Login implements Command {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) {
      MemberDAO dao = new MemberDAO();
      MemberVO vo = new MemberVO();

      vo.setmId(request.getParameter("mId"));
      vo.setmPassword(request.getParameter("mPassword"));
      
      vo = dao.select(vo);

      if (vo.getmAuth() != null) {

         HttpSession session = request.getSession();
         session.setAttribute("mId", vo.getmId());
         session.setAttribute("mPassword", vo.getmPassword());
      }
      request.setAttribute("vo", vo);

      return "main/main";
   }

}