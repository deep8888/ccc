package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.MemberDTO;
import model.DTO.NoticeBoardDTO;

public class MemberDAO extends DataBaseInfo {
	final String COLUMNS = "USER_EMAIL,USER_PW, USER_NAME, USER_REGIST, USER_ADDR, USER_PH1";

	public void userMemberDel(String userEmail, String userPw) { // 회원탈퇴

		conn = getConnection();
		sql = "delete from memberccc where user_email = ? and user_pw = ?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, userEmail);
			pstmt.setNString(2, userPw);
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이 삭제 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public Integer passUpdate(String userEmail, String userPw, String newPw) { // 비밀번호 수정
		Integer i = 0;
		conn = getConnection();
		sql = "update memberccc set user_pw = ? where user_email = ? and user_pw = ?";
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, newPw);
			pstmt.setNString(2, userEmail);
			pstmt.setNString(3, userPw);
			i = pstmt.executeUpdate();
			System.out.println(i + "행이 수정되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return i;
	}

	public Integer memberLoginCk(String userEmail, String userPw) { // 회원로그인
		Integer result = -1;
		conn = getConnection();
		sql = "select user_pw from memberccc where user_email = ? and join_ok is not null";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, userEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbPw = rs.getNString(1);
				if (userPw.equals(dbPw)) {
					result = 1; // 로그인
				} else {
					result = 0; // 비밀번호가 틀렸을 떄
				}

			} else {
				result = -1; // 아이디가 틀렸을때
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}

	public Integer masterLoginCk(String userEmail) { // 관리자권한 체크
		Integer result = null;
		conn = getConnection();
		sql = "select class_ok from memberccc where user_email = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, userEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbPw = rs.getNString(1);
				if (dbPw==null) {
					result = 0; // null값이 아닐때 1
				} else {
					result = 1; // 
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return result;
	}
	public Integer joinOkUpdate(String email, String joinOk) {// 메일가입승인
		Integer result = 0;
		conn = getConnection();
		sql = "update memberccc set join_ok = ? where user_email = ? and join_ok is null";
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, joinOk);
			pstmt.setNString(2, email);
			result = pstmt.executeUpdate();
			System.out.println(result + "행이 수정되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public String memberConfirm(String userEmail) { // 이메일 중복 체크
		String email = null;
		conn = getConnection();
		sql = " select user_email from memberccc where user_email = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				email = rs.getNString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return email;

	}

	public void memberDelete(MemberDTO dto) { // 관리자 회원탈퇴
		int i = 0;
		conn = getConnection();
		String condition = "";
		if (dto.getUserPw() != null) {
			condition = " and user_pw =?";
		}
		sql = "delete from memberccc where user_email = ? " + condition;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, dto.getUserEmail());
			if (dto.getUserPw() != null) {
				pstmt.setNString(2, dto.getUserPw());
			}

			i = pstmt.executeUpdate();
			System.out.println(i + "행이 삭제 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void memberUpdate(MemberDTO dto) { // 관리자 회원정보 수정멤버
		conn = getConnection();
		sql = "update memberccc set USER_ADDR=? , USER_PH1=? where user_email=?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setNString(1, dto.getUserAddr());
			pstmt.setNString(2, dto.getUserPh1());
			pstmt.setNString(3, dto.getUserEmail());

			int i = pstmt.executeUpdate();
			System.out.println(i + "행이 수정되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<MemberDTO> memberSelect(int page, int limit, String userEmail) { // 회원리스트

		List<MemberDTO> list = new ArrayList<MemberDTO>();
		int startRow = (page - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		conn = getConnection();
		String condition = "";

		if (userEmail != null) {
			condition = " and user_email=? ";
		}
		sql = "select * from(select rownum rn, " + COLUMNS + " from (select " + COLUMNS + " from memberccc where 1=1 "
				+ condition + "order by USER_REGIST desc)) where rn between ? and ?";

		try {
			pstmt = conn.prepareStatement(sql);
			if (userEmail != null) {
				pstmt.setString(1, userEmail);
				pstmt.setInt(2, startRow);
				pstmt.setInt(3, endRow);
			} else {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
			}
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setUserAddr(rs.getNString("user_Addr"));
				dto.setUserEmail(rs.getNString("user_Email"));
				dto.setUserName(rs.getNString("user_Name"));
				dto.setUserPh1(rs.getNString("user_Ph1"));
				dto.setUserRegist(rs.getTimestamp("user_Regist"));

				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public Integer memberCount() { // 회원수
		Integer result = 0;
		conn = getConnection();
		sql = "select count(*) from memberccc";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt(1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public Integer memberInsert(MemberDTO dto) { // 회원가입
		Integer i = null;
		conn = getConnection();
		sql = "insert into memberccc (" + COLUMNS + ")" + "values(?,?,?,sysdate,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, dto.getUserEmail());
			pstmt.setNString(2, dto.getUserPw());
			pstmt.setNString(3, dto.getUserName());
			pstmt.setNString(4, dto.getUserAddr());
			pstmt.setString(5, dto.getUserPh1());
			i = pstmt.executeUpdate();
			System.out.println(i + "행이 저장되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return i;
	}

	public String checkEmail(String userName, String userPh1) {
		conn = getConnection();
		sql = "select user_email from memberccc where user_name = ? and user_ph1 = ?";
		String userEmail = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userPh1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userEmail = rs.getString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return userEmail;
	}

	public String checkPass(String userName, String userEmail, String userPh1) {
		conn = getConnection();
		sql = "select user_Pw from memberccc where user_name = ? and user_email = ? and user_ph1 = ?";
		String userPass = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, userPh1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				userPass = rs.getString(1);

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return userPass;
	}

	public Integer checkPassInsert(MemberDTO dto) {
		Integer i = null;
		conn = getConnection();
		sql = "update memberccc set USER_PW=? where user_name=? and user_email =? and user_ph1 =? ";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setNString(1, dto.getUserPw());
			pstmt.setNString(2, dto.getUserName());
			pstmt.setNString(3, dto.getUserEmail());
			pstmt.setNString(4, dto.getUserPh1());
			i = pstmt.executeUpdate();
			System.out.println(i + "행이 수정되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return i;
	}

	  public MemberDTO CrSelect(String userEmail) {
		  MemberDTO dto = new MemberDTO();
			   conn = getConnection();
			   sql= "select "+COLUMNS+" from memberccc where user_email=?";
			   try {
				   pstmt= conn.prepareStatement(sql);
				   pstmt.setNString(1, userEmail);
				   rs = pstmt.executeQuery();
				   if(rs.next()) {
					    dto.setUserEmail(rs.getString("USER_EMAIL"));
			            dto.setUserPh1(rs.getNString("user_Ph1"));
				}
			   }catch(Exception e) {
				   e.printStackTrace();
			   }finally {
				   close();
			   }
			   return dto;
		  
	}

	public List<MemberDTO> loginSelect(String userEmail) {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		
		conn = getConnection();
		

		sql = "select user_name from memberccc where 1=1 and user_email=? ";
				

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
						
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberDTO dto = new MemberDTO();
				dto.setUserName(rs.getNString("user_Name"));
			
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return list;

	}
}
