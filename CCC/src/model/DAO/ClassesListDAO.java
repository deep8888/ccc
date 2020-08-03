package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.ClassesListDTO;

public class ClassesListDAO extends DataBaseInfo {
	final String COLUMNS = 	"CLASSES_LIST_NUM, "	+
							"CLASSES_NUM, "			+
							"CLASSES_LIST_SUBJECT, "+
							"CLASSES_LIST_CONTENT "
							;
	final String subSql = 	"( SELECT NVL(MAX(CLASSES_NUM),0) || '_' || +1 "
							+ "	FROM CLASSES_LIST "
							+ "WHERE CLASSES_NUM = ? )";
	public void ClassListAdd2(String cU, String cLS, String cln,String classNum) {
		// TODO Auto-generated method stub\
		conn = getConnection();
		sql =	"	INSERT INTO CLASSES_LIST	( "
				+ COLUMNS 
				+ " ) "
				+ "	VALUES (( SELECT NVL(MAX(CLASSES_NUM),0) || '_' || "+ cln +" "
				+ "				FROM CLASSES "
				+ "			   WHERE CLASSES_NUM = ? )" 
				+ ", ?, ?, ?) "
				;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classNum);
			pstmt.setString(2, classNum);
			pstmt.setString(3, cLS);
			pstmt.setString(4, cU);
			
			
			int i1 = pstmt.executeUpdate();
			System.out.println(i1 + "개가 생성되었습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public void ClassListAdd(String classUrl, String classListSubject, String classListNum,String classNum) {
		// TODO Auto-generated method stub\
		conn = getConnection();
		sql =	"	INSERT INTO CLASSES_LIST	( "
				+ COLUMNS 
				+ " ) "
				+ "	VALUES (( SELECT NVL(MAX(CLASSES_NUM),0) || '_' || "+ classListNum +" "
				+ "				FROM CLASSES "
				+ "			   WHERE CLASSES_NUM = ? )" 
				+ ", ?, ?, ?) "
				;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classNum);
			pstmt.setString(2, classNum);
			pstmt.setString(3, classListSubject);
			pstmt.setString(4, classUrl);
			
			
			int i1 = pstmt.executeUpdate();
			System.out.println(i1 + "개가 생성되었습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
	}
	public List<ClassesListDTO> ClassListSelect(String classNum) {
		// TODO Auto-generated method stub
		conn = getConnection();
		/*
		 * sql = "	SELECT "+ COLUMNS + "	  FROM CLASSES_LIST	" +
		 * "	 WHERE CLASSES_NUM = ? " + "  ORDER BY CLASSES_LIST_NUM ASC";
		 */
		sql =   "   SELECT SUBSTR(CLASSES_LIST_NUM ,8,11) AS CNT, "
	            + "          CLASSES_NUM,   "
	            + "         CLASSES_LIST_SUBJECT,   "
	            + "         CLASSES_LIST_CONTENT   "
	            + "     FROM CLASSES_LIST   "
	            + "    WHERE CLASSES_NUM   = ? "
	            + "  ORDER BY CAST(CNT AS INT) *1 "
	            ;
		
		List<ClassesListDTO> list = new ArrayList<ClassesListDTO>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classNum);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ClassesListDTO dto = new ClassesListDTO();
				System.out.println(rs.getString("CNT"));
				dto.setClassesListNum(rs.getString("CNT"));
				dto.setClassesNum(rs.getString("CLASSES_NUM"));
				dto.setClassesListSubject(rs.getString("CLASSES_LIST_SUBJECT"));
				dto.setClassesListContent(rs.getString("CLASSES_LIST_CONTENT"));
				
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
	public Integer classesListYn(String classNum) {
		// TODO Auto-generated method stub
		Integer i = 0;
		conn = getConnection();
		sql =	"	SELECT COUNT(CLASSES_LIST_NUM) AS CNT	"
				+ "	  FROM CLASSES_LIST	"
				+ "	 WHERE CLASSES_NUM = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classNum);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				i = rs.getInt(1);
			}
			System.out.println(i +" 존재 확인!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return i;
	}
	public void ClassListUpdate(String classUrl, String classListSubject, String classListNum,String classNum) {
		// TODO Auto-generated method stub
		int i = 0;
		String connection = classNum+"_"+classListNum;
		System.out.println(classListNum);
		conn = getConnection();
		sql = 	"	UPDATE CLASSES_LIST "
				+ "	   SET CLASSES_LIST_SUBJECT = ?, "
				+ "		   CLASSES_LIST_CONTENT = ? "
				+ "  WHERE CLASSES_NUM = ?	"
				+ "	   AND CLASSES_LIST_NUM = ? ";
		
		try {
			System.out.println(sql);
			System.out.println(connection);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classListSubject);
			pstmt.setString(2, classUrl);
			pstmt.setString(3, classNum);
			pstmt.setString(4, connection);
			
			i = pstmt.executeUpdate();
			i++;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		System.out.println(i+"건 클래스 수정되었습니다.");
	}
	
}
