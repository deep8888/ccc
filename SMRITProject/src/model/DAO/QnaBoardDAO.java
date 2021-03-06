package model.DAO;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import model.DTO.QnaBoardDTO;

public class QnaBoardDAO extends DataBaseInfo{
   final String COLUMNS =  "BOARD_NUM" + 
                     ",USER_ID" + 
                     ",BOARD_NAME" + 
                     ",BOARD_PASS" + 
                     ",BOARD_SUBJECT" + 
                     ",BOARD_CONTENT" + 
                     ",BOARD_DATE" + 
                     ",IP_ADDR" + 
                     ",READ_COUNT" 
                     ;

    
   public QnaBoardDTO QnaOneSelect(String num) {
	   QnaBoardDTO dto = new QnaBoardDTO();
	   conn = getConnection();
	   sql= "select "+COLUMNS+" from board where board_num=?";
	   try {
		   pstmt= conn.prepareStatement(sql);
		   pstmt.setNString(1, num);
		   rs = pstmt.executeQuery();
		   if(rs.next()) {
			    dto.setBoardNum(rs.getLong(1));
	            dto.setUserId(rs.getString("USER_ID"));
	            dto.setBoardName(rs.getString("BOARD_NAME"));
	            dto.setBoardPass(rs.getString("BOARD_PASS"));
	            dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
	            dto.setBoardContent(rs.getString("BOARD_CONTENT"));
	            dto.setBoardDate(rs.getTimestamp("BOARD_DATE"));
	            dto.setIpAddr(rs.getString("IP_ADDR"));
	            dto.setReadCount(rs.getLong("READ_COUNT"));
	    
			
		}
		   
		   
	   }catch(Exception e) {
		   e.printStackTrace();
	   }finally {
		   close();
	   }
	   return dto;
}  
   
   
   
   public List<QnaBoardDTO> qnaSelectAll(int page, int limit) {
      List<QnaBoardDTO> list = new ArrayList<QnaBoardDTO>();
      int startRow= (page -1) * limit +1;
	  int endRow = startRow + limit -1;
      conn = getConnection();
      sql = "select * from(select rownum rn, " + COLUMNS + " from (SELECT "+ COLUMNS + " FROM BOARD order by board_num desc)) where rn between ? and ?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, startRow);
         pstmt.setInt(2, endRow);
         rs = pstmt.executeQuery();
      
         while(rs.next()){
            QnaBoardDTO dto = new QnaBoardDTO();
            dto.setBoardNum(rs.getLong("BOARD_NUM"));
            dto.setUserId(rs.getString("USER_ID"));
            dto.setBoardName(rs.getString("BOARD_NAME"));
            dto.setBoardPass(rs.getString("BOARD_PASS"));
            dto.setBoardSubject(rs.getString("BOARD_SUBJECT"));
            dto.setBoardContent(rs.getString("BOARD_CONTENT"));
            dto.setBoardDate(rs.getTimestamp("BOARD_DATE"));
            dto.setIpAddr(rs.getString("IP_ADDR"));
            dto.setReadCount(rs.getLong("READ_COUNT"));
           
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
   public int qnaCount() {
      int i=0;
      conn = getConnection();
      sql = "SELECT COUNT(*) FROM BOARD";
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
   
   public void qnaInsert(QnaBoardDTO dto) {
      conn = getConnection();
      String subQuery = "SELECT NVL(MAX(BOARD_NUM), 0) +1 FROM BOARD";
      sql = "insert into board("+COLUMNS+") values (("+subQuery+"),?,?,?,?,?,sysdate,?,?)";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, dto.getUserId());
         pstmt.setString(2, dto.getBoardName());
         pstmt.setString(3, dto.getBoardPass());
         pstmt.setString(4, dto.getBoardSubject());
         pstmt.setString(5, dto.getBoardContent());
         pstmt.setString(6, dto.getIpAddr());
         pstmt.setLong(7, 0);
         
         int i = pstmt.executeUpdate();
         System.out.println(i + "행이 저장되었습니다.");
      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
      }finally {
         close();
      }
   }



public void qnaUpdate(QnaBoardDTO dto) {
	conn = getConnection();
	sql = " update board set board_subject = ? , board_content = ? where board_num = ? and user_id = ? and board_pass = ? ";
	try {
		pstmt = conn.prepareStatement(sql);
		pstmt.setNString(1, dto.getBoardSubject());
		pstmt.setNString(2, dto.getBoardContent());
		pstmt.setLong(3, dto.getBoardNum());
		pstmt.setNString(4, dto.getUserId());
		pstmt.setNString(5, dto.getBoardPass());
		
		int i = pstmt.executeUpdate();
		System.out.println(i + "행이 수정되었습니다.");
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		close();
	}
	
	
}
public void qnaDelete(QnaBoardDTO dto) {
	conn = getConnection();
	sql = " delete from board where board_num = ? and user_id = ? and board_pass = ? ";
	try {
	pstmt = conn.prepareStatement(sql);
	pstmt.setLong(1, dto.getBoardNum());
	pstmt.setNString(2, dto.getUserId());
	pstmt.setNString(3, dto.getBoardPass());
	int i = pstmt.executeUpdate();
	System.out.println(i + "행이 삭제되었습니다.");
}catch(Exception e) {
	e.printStackTrace();
}finally {
	close();
}
}
}