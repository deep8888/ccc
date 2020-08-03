package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.BoardCreateDTO;
import model.DTO.NoticeBoardDTO;

public class BoardCreateDAO extends DataBaseInfo {
	final String COLUMNS = "BOARD_NUM" + ",USER_EMAIL" + ",BOARD_NAME" + ",BOARD_PASS" + ",BOARD_SUBJECT"
			+ ",BOARD_CONTENT" + ",BOARD_DATE" + ",IP_ADDR" + ",READ_COUNT,BOARD_STEP";

	public BoardCreateDTO cenOneSelect(String num) {
		   BoardCreateDTO dto = new BoardCreateDTO();
		   conn = getConnection();
		   sql= "select "+COLUMNS+" from boardcreate where board_num=?";
		   try {
			   pstmt= conn.prepareStatement(sql);
			   pstmt.setNString(1, num);
			   rs = pstmt.executeQuery();
			   if(rs.next()) {
				    dto.setBoardNum(rs.getLong(1));
		            dto.setUserEmail(rs.getString("USER_EMAIL"));
		            dto.setBoardName(rs.getString("BOARD_NAME"));
		            dto.setBoardPass(rs.getString("BOARD_PASS"));
		            dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
		            dto.setBoardContent(rs.getString("BOARD_CONTENT"));
		            dto.setBoardDate(rs.getTimestamp("BOARD_DATE"));
		            dto.setIpAddr(rs.getString("IP_ADDR"));
		            dto.setReadCount(rs.getLong("READ_COUNT"));
		            dto.setBoardStep(rs.getNString("BOARD_STEP"));
				
			}
			   
			   
		   }catch(Exception e) {
			   e.printStackTrace();
		   }finally {
			   close();
		   }
		   return dto;
	}  
	public List<BoardCreateDTO> crSelectAll(int page, int limit) {
		List<BoardCreateDTO> list = new ArrayList<BoardCreateDTO>();
		int startRow = (page - 1) * limit + 1;
		int endRow = startRow + limit - 1;
		conn = getConnection();
		sql = "select * from(select rownum rn, " + COLUMNS + " from (SELECT " + COLUMNS
				+ " FROM BOARDCREATE order by board_num desc)) where rn between ? and ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardCreateDTO dto = new BoardCreateDTO();
				dto.setBoardNum(rs.getLong("BOARD_NUM"));
				dto.setUserEmail(rs.getString("USER_EMAIL"));
				dto.setBoardName(rs.getString("BOARD_NAME"));
				dto.setBoardPass(rs.getString("BOARD_PASS"));
				dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
				dto.setBoardContent(rs.getString("BOARD_CONTENT"));
				dto.setBoardDate(rs.getTimestamp("BOARD_DATE"));
				dto.setIpAddr(rs.getString("IP_ADDR"));
				dto.setReadCount(rs.getLong("READ_COUNT"));
				dto.setBoardStep(rs.getNString("BOARD_STEP"));
				
				list.add(dto);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			close();
		}
		return list;
	}

	public int crCount() {
		int i = 0;
		conn = getConnection();
		sql = "SELECT COUNT(*) FROM BOARDCREATE";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				i = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return i;
	}
	public void crInsert(BoardCreateDTO dto) {
	      conn = getConnection();
	      String subQuery = "SELECT NVL(MAX(BOARD_NUM), 0) +1 FROM BOARDCREATE";
	      sql = "insert into BOARDCREATE("+COLUMNS+") values (("+subQuery+"),?,?,?,?,?,sysdate,?,?,?)";
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, dto.getUserEmail());
	         pstmt.setString(2, dto.getBoardName());
	         pstmt.setString(3, dto.getBoardPass());
	         pstmt.setString(4, dto.getBoardSubject());
	         pstmt.setString(5, dto.getBoardContent());
	         pstmt.setString(6, dto.getIpAddr());
	         pstmt.setLong(7, 0);
	         pstmt.setNString(8, null);
	         
	         int i = pstmt.executeUpdate();
	         System.out.println(i + "행이 저장되었습니다.");
	      } catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	   }



	public void crUpdate(BoardCreateDTO dto) {
		conn = getConnection();
		sql = " update BOARDCREATE set board_subject = ? , board_content = ? where board_num = ? and user_email = ? and board_pass = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, dto.getBoardSubject());
			pstmt.setNString(2, dto.getBoardContent());
			pstmt.setLong(3, dto.getBoardNum());
			pstmt.setNString(4, dto.getUserEmail());
			pstmt.setNString(5, dto.getBoardPass());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이 수정되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		
	}
	public void crDelete(BoardCreateDTO dto) {
		conn = getConnection();
		sql = " delete from BOARDCREATE where board_num = ? and user_email = ? and board_pass = ? ";
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, dto.getBoardNum());
		pstmt.setNString(2, dto.getUserEmail());
		pstmt.setNString(3, dto.getBoardPass());
		int i = pstmt.executeUpdate();
		System.out.println(i + "행이 삭제되었습니다.");
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		close();
	}
	}
	public void BoardStepUpdate(BoardCreateDTO dto) {
		conn = getConnection();
		sql = " update BOARDCREATE set board_step = ? where board_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, dto.getBoardStep());
			pstmt.setLong(2, dto.getBoardNum());
		
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이 수정되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}
