package com.yedam.bookrental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yedam.bookrental.common.DAO;
import com.yedam.bookrental.vo.BookRentalVO;

public class BookRentalDAO extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;
	
	// 전체조회
	public ArrayList<BookRentalVO> selectList(){
		
		ArrayList<BookRentalVO> list = new ArrayList<BookRentalVO>();
		
		String sql = "SELECT * FROM RENTAL";
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				BookRentalVO vo = new BookRentalVO();
				vo.setRentalDate(rs.getDate("rentaldate"));
				vo.setbCode(rs.getString("bookcode"));
				vo.setmId(rs.getString("memberid"));
				vo.setReturnDate(rs.getString("returndate"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	
	
	// 도서 반납 멤버 선택
	public BookRentalVO select(BookRentalVO vo) {

		String sql = "SELECT * FROM RENTAL WHERE MEMBERID = ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getmId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				vo.setRentalDate(rs.getDate("rentalDate"));
				vo.setbCode(rs.getString("bCode"));
				vo.setmId(rs.getString("mId"));
				vo.setReturnDate(rs.getString("returnDate"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}

	// 도서 대여
	public int bookInsert(BookRentalVO vo) {
		int n = 0;
		String sql = "INSERT INTO RENTAL(BOOKCODE, MEMBERID) VALUES(?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbCode());
			psmt.setString(2, vo.getmId());
			n = psmt.executeUpdate();
			if(n != 0) {
				countMinus(Integer.parseInt(vo.getbCode()));
			}
			System.out.println("입력 완료");
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("입력 실패");
		}finally {
			close();
		}
		
		return n;
	}
	
	// 도서 대여
		public int bookReturn(BookRentalVO vo) {
			int n = 0;
			String sql = "INSERT INTO RENTAL(BOOKCODE, MEMBERID) VALUES(?,?)";
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getbCode());
				psmt.setString(2, vo.getmId());
				n = psmt.executeUpdate();
				if(n != 0) {
					countPlus(Integer.parseInt(vo.getbCode()));
				}
				System.out.println("입력 완료");
			}catch(SQLException e) {
				e.printStackTrace();
				System.out.println("입력 실패");
			}finally {
				close();
			}
			
			return n;
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
