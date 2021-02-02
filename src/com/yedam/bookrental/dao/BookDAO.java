package com.yedam.bookrental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yedam.bookrental.common.DAO;
import com.yedam.bookrental.vo.BookVO;

public class BookDAO extends DAO {
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	// 도서 관리
	
	// 도서 관리 조회
	public ArrayList<BookVO> selectList(){
		ArrayList<BookVO> list = new ArrayList<BookVO>();
		
		String sql = "SELECT * FROM BOOK ORDER BY BOOKCODE ASC";
		BookVO vo;
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new BookVO();
				vo.setbCode(rs.getString("bookcode"));
				vo.setbName(rs.getString("bookname"));
				vo.setbQty(rs.getInt("quantity"));
				vo.setbCount(rs.getInt("bcount"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	
	// 도서 관리 등록
	public int bookInsert(BookVO vo) {
		int n = 0;
		
		String sql = "insert into book values(?,?,?,?)";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getbCode());
			psmt.setString(2, vo.getbName());
			psmt.setInt(3, vo.getbQty());
			psmt.setInt(4, vo.getbCount());
			n = psmt.executeUpdate();
			
			System.out.println(n + "건의 도서 등록 완료");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return n;
	}
	
	
	// 도서 관리 수정
		public int bookUpdate(BookVO vo) {
			int n = 0;
			
			String sql = "UPDATE BOOK SET QUANTITY = ? WHERE BOOKCODE = ?";
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setInt(1, vo.getbQty());
				psmt.setString(2, vo.getbCode());
				n = psmt.executeUpdate();
				
				System.out.println(n + "건의 도서 수정 완료");
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
		
			
			return n;
		}
	
	// 도서 관리 삭제
	public int bookDelete(BookVO vo) {
			int n = 0;
			
			String sql = "DELETE FROM BOOK WHERE BOOKCODE = ?";
			
			try {
				psmt = conn.prepareStatement(sql);
				psmt.setString(1, vo.getbCode());
				n = psmt.executeUpdate();
				
				System.out.println(n + "건의 도서 삭제 완료");
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return n;
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

} // end of class
