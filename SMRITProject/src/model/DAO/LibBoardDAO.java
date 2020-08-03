package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.LibBoardDTO;
import model.DTO.QnaBoardDTO;

public class LibBoardDAO extends DataBaseInfo{
	final String COLUMNS = "BOARD_NUM,USER_ID,BOARD_NAME,BOARD_PASS,BOARD_SUBJECT,BOARD_CONTENT,BOARD_DATE,IP_ADDR,READ_COUNT,ORIGINAL_FILE_NAME,STORE_FILE_NAME,FILE_SIZE"; 
	
		
	public  List<LibBoardDTO> libSelectAll(int page, int limit, String num) {
		String condition = "";
		if (num != null) {
			condition = " and board_num = " + num;
			
		}
		int startRow= (page -1) * limit +1;
		  int endRow = startRow + limit -1;
		
	      List<LibBoardDTO> list = new ArrayList<LibBoardDTO>();
	      conn = getConnection();
	      sql = "select * from(select rownum rn, " + COLUMNS + " from (SELECT "+ COLUMNS + " FROM LIBRARYBOARD where 1=1 " + condition + " order by board_num desc)) where rn between ? and ?";
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, startRow);
	         pstmt.setInt(2, endRow);
	         rs = pstmt.executeQuery();
	         while(rs.next()){
	            LibBoardDTO dto = new LibBoardDTO();
	            dto.setBoardNum(rs.getLong("BOARD_NUM"));
	            dto.setUserId(rs.getString("USER_ID"));
	            dto.setBoardName(rs.getString("BOARD_NAME"));
	            dto.setBoardPass(rs.getString("BOARD_PASS"));
	            dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
	            dto.setBoardContent(rs.getString("BOARD_CONTENT"));
	            dto.setBoardDate(rs.getTimestamp("BOARD_DATE"));
	            dto.setIpAddr(rs.getString("IP_ADDR"));
	            dto.setReadCount(rs.getLong("READ_COUNT"));
	            dto.setOriginalFileName(rs.getNString("ORIGINAL_FILE_NAME"));
	            dto.setStoreFileName(rs.getNString("STORE_FILE_NAME"));
	            dto.setFileSize(rs.getLong("FILE_SIZE"));
	            
	           	            list.add(dto);
	         }
	      } catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      return list;
	   }
	
	   public int libCount() {
	      int i=0;
	      conn = getConnection();
	      sql = "SELECT COUNT(*) FROM LIBRARYBOARD";
	      try {
	         pstmt = conn.prepareStatement(sql);
	         rs = pstmt.executeQuery();
	         if(rs.next()) {
	            i =  rs.getInt(1);
	         }
	      } catch (Exception e) {
	         // TODO: handle exception
	         e.printStackTrace();
	      }finally {
	         close();
	      }
	      return i;
	   }
	   
	
	
	public  void LibInsert(LibBoardDTO dto) {
		conn = getConnection();
		String subQuery = "select nvl(max(board_num),0)+1 from libraryboard";
		sql = "insert into libraryboard("+COLUMNS+")"
				+"values(("+subQuery+"),?,?,?,?,?,sysdate,?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getBoardName());
			pstmt.setString(3, dto.getBoardPass());
			pstmt.setString(4, dto.getBoardSubject());
			pstmt.setString(5, dto.getBoardContent());
			pstmt.setString(6, dto.getIpAddr());
			pstmt.setLong(7, 0);
			pstmt.setString(8, dto.getOriginalFileName());
			pstmt.setString(9, dto.getStoreFileName());
			pstmt.setLong(10, dto.getFileSize());
			int i = pstmt.executeUpdate();
			System.out.println(i+"행이 저장되었습니다.");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
}
	public void libContentUpdate(LibBoardDTO dto) {
		conn = getConnection();
		sql = " update libraryboard set board_subject = ? , board_content = ? where board_num = ? and user_id = ? and board_pass = ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, dto.getBoardSubject());
			pstmt.setNString(2, dto.getBoardContent());
			pstmt.setLong(3, dto.getBoardNum());
			pstmt.setNString(4, dto.getUserId());
			pstmt.setNString(5, dto.getBoardPass());
			
			System.out.println(dto.getUserId());
			System.out.println(dto.getBoardPass());
			
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이 수정되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
		public Integer fileUpdate(LibBoardDTO dto) {
			Integer i = 0;
			conn = getConnection();
			sql = " update libraryboard set original_file_name =? , store_file_name = ? , file_size = ? where board_num = ? and board_pass = ? and user_id = ?";
			
		    try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setNString(1, dto.getOriginalFileName());
				pstmt.setNString(2, dto.getStoreFileName());
				pstmt.setLong(3, dto.getFileSize());
				pstmt.setLong(4, dto.getBoardNum());
				pstmt.setNString(5, dto.getBoardPass());
				pstmt.setNString(6, dto.getUserId());
				i = pstmt.executeUpdate();
				System.out.println(i+"행이 수정되었습니다.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		    return i;
		}
		
	
	public Integer libBoardDel(String boardNum) {
		Integer i = 0;
		conn = getConnection();
		sql = " delete from libraryboard where board_num = ?";
		try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, boardNum);
		i = pstmt.executeUpdate();
		System.out.println(i + "행이 삭제되었습니다.");
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		close();
	}
		return i;
	}
	
	
}