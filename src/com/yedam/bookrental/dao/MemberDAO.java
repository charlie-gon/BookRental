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
			
			// 회원 확인 메소드
			public int checkMember(String id, String pwd) {
				String checkPwd = "";
				int x = -1;
				String sql = "SELECT MEMBERPASSWORD FROM MEMBER WHERE MEMBERID = ?";
				
				try {
					psmt = conn.prepareStatement(sql);
					psmt.setString(1, id);
					rs = psmt.executeQuery();
					if(rs.next()) { // 입력된 아이디에 해당하는 비밀번호 있을 경우
						checkPwd = rs.getString("memberpassword");
						
						if(checkPwd.equals(pwd)) // 넘겨받은 비밀번호와 꺼내온 비밀번호 비교
							x = 1; 
						else
							x = 0;
					}else {
						x = -1; // 해당 아이디가 없음.
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				return x;
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
