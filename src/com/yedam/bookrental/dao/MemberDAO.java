package com.yedam.bookrental.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.yedam.bookrental.common.DAO;
import com.yedam.bookrental.vo.MemberVO;

public class MemberDAO extends DAO {
	
	private PreparedStatement psmt;
	private ResultSet rs;
	
	// 멤버 관리
	
		// 멤버 관리 조회
			public ArrayList<MemberVO> selectMemberList(){
				ArrayList<MemberVO> list = new ArrayList<MemberVO>();
				
				String sql = "SELECT * FROM MEMBER";
				MemberVO vo;
				try {
					psmt = conn.prepareStatement(sql);
					rs = psmt.executeQuery();
					while(rs.next()) {
						vo = new MemberVO();
						vo.setmId(rs.getString("memberid"));
						vo.setmName(rs.getString("membername"));
						vo.setmPassword(rs.getString("memberpassword"));
						vo.setmTel(rs.getString("membertel"));
						vo.setmAddress(rs.getString("memberaddress"));
						vo.setmAuth(rs.getString("memberauth"));
						list.add(vo);
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				
				return list;
			} 
			
			// 멤버 관리 등록
			public int memberInsert(MemberVO vo) {
				int n = 0;
				
				String sql = "INSERT INTO MEMBER(MEMBERID, MEMBERNAME, MEMBERPASSWORD, MEMBERTEL, MEMBERADDRESS) VALUES(?,?,?,?,?)";
				
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getmId());
					psmt.setString(2, vo.getmName());
					psmt.setString(3, vo.getmPassword());
					psmt.setString(4, vo.getmTel());
					psmt.setString(5, vo.getmAddress());
					
					n = psmt.executeUpdate();
					
					System.out.println(n + "건의 멤버 등록 완료");
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return n;
			}
			
			
			// 멤버 관리 수정
			
			public int memberUpdate(MemberVO vo) {
				int n = 0;

				String sql = "UPDATE MEMBER SET MEMBERNAME = ? WHERE MEMBERID = ?";

				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getmName());
					psmt.setString(2, vo.getmId());
					n = psmt.executeUpdate();

					System.out.println(n + "건의 멤버 수정 완료");
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					close();
				}

				return n;
			}
			
			
			// 멤버 관리 삭제
			public int memberDelete(MemberVO vo) {
					int n = 0;
					
					String sql = "DELETE FROM MEMBER WHERE MEMBERID = ?";
					
					try {
						psmt = conn.prepareStatement(sql);
						psmt.setString(1, vo.getmId());
						n = psmt.executeUpdate();
						
						System.out.println(n + "건의 멤버 삭제 완료");
					}catch(SQLException e) {
						e.printStackTrace();
					}finally {
						close();
					}
					
					return n;
				}
			
			public MemberVO select(MemberVO vo) {
			      String sql = "SELECT * FROM MEMBER WHERE MEMBERID =?";
			      try {
			         psmt = conn.prepareStatement(sql);
			         psmt.setString(1, vo.getmId());
			         rs = psmt.executeQuery();
			         if (rs.next()) {
			            vo.setmId(rs.getString("memberid"));
			            vo.setmName(rs.getString("membername"));
			            vo.setmPassword(rs.getString("memberpassword"));
			            vo.setmTel(rs.getString("membertel"));
			            vo.setmAddress(rs.getString("memberaddress"));
			            vo.setmAuth(rs.getString("memberauth"));
			         }
			      } catch (SQLException e) {

			      } finally {
			         close();
			      }
			      return vo;
			   }
			
			// 로그인 확인
			public MemberVO checkMember(MemberVO vo) {
				
				String sql = "SELECT * FROM MEMBER WHERE MEMBERID = ? AND MEMBERPASSWORD = ?";
				
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, vo.getmId());
					psmt.setString(2, vo.getmPassword());
					rs = psmt.executeQuery();
					if(rs.next()) {
						vo.setmId(rs.getString("memberid"));
			            vo.setmName(rs.getString("membername"));
			            vo.setmPassword(rs.getString("memberpassword"));
			            vo.setmTel(rs.getString("membertel"));
			            vo.setmAddress(rs.getString("memberaddress"));
			            vo.setmAuth(rs.getString("memberauth"));
					}
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return vo;
			}
			
			// 아이디 체크
			public int isIdCheck(String id) {
				int cnt = 0;
				String sql = "SELECT MEMBERID FROM MEMBER WHERE MEMBERID = ?";
				
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, id);
					rs = psmt.executeQuery();
					if(rs.next()) {
						cnt = 1; // 아이디 있으면 1
					}else {
						cnt = 0; // 아이디 없으면 0
					}
				}catch(SQLException e) {
					e.printStackTrace();
					System.out.println("아이디 중복확인 실패");
				}finally {
					close();
				}
				return cnt;
			}
			
			// 아이디별 대여 도서 확인
//			select b.bookcode, b.bookname, m.memberid, m.membername, r.rentaldate, r.returndate
//			from book b JOIN rental r
//			ON(b.bookcode = r.bookcode)
//			JOIN member m
//			ON(m.memberid = r.memberid)
//			where m.memberid = '1';
			
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
