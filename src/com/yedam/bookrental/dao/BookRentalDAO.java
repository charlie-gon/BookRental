package com.yedam.bookrental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.yedam.bookrental.common.DAO;
import com.yedam.bookrental.vo.BookRentalVO;

public class BookRentalDAO extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;
	
	// 도서 대여
	public int bookInsert(BookRentalVO vo) {
		int n = 0;
		String sql = "INSERT INTO RENTAL(BOOKCODE, MEMBERID, RETURNDATE) VALUES(?,?,SYSDATE+14)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbCode());
			psmt.setString(2, vo.getmId());
			psmt.setString(3, vo.getReturnDate());
			n = psmt.executeUpdate();
			if(n != 0) {
				countMinus(Integer.parseInt(vo.getbCode()));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}
	
	// 도서 반납
		public BookRentalVO bookReturn(BookRentalVO vo) {
			
			String sql = "UPDATE RENTAL SET(BOOKCODE, MEMBERID, RETURNDATE) VALUES(?,?,SYSDATE)";
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getbCode());
				psmt.setString(2, vo.getmId());
				psmt.setString(3, vo.getReturnDate());
				rs = psmt.executeQuery();
				if(rs.next()) {
					vo.setRentalDate(rs.getDate("rentaldate"));
					vo.setbCode(rs.getString("bookcode"));
					vo.setmId(rs.getString("memberid"));
					vo.setReturnDate(rs.getString("returndate"));
					countPlus(Integer.parseInt(vo.getbCode()));
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return vo;
		}
	
	// 현재수량 더하기
	public void countPlus(int count) {

		String sql = "UPDATE BOOK SET BCOUNT = BCOUNT + 1 WHERE BOOKCODE = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, count);
			psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 현재수량 빼기
		public void countMinus(int count) {
			
			String sql = "UPDATE BOOK SET BCOUNT = BCOUNT - 1 WHERE BOOKCODE = ?";
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, count);
				psmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	
	
	
	// close 메소드
		private void close() {
			try {
				// 실행의 반대 순서
				if(rs != null) rs.close();
				if(psmt != null) psmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
}
