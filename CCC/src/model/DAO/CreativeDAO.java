package model.DAO;

import model.DTO.CreativeDTO;

public class CreativeDAO extends DataBaseInfo {
	final String COLUMNS = 	"USER_EMAIL   ,	"+
							"USER_PH1     ,	"+
							"APPLY_PATH   ,	"+
							"DEMAND_OK    ,	"+
							"CREATOR_NNAME,	"+
							"CREATOR_INTRO,	"+
							"CREATOR_PH1  ,	"+
							"CREATOR_PHOTO	"
							;
	public void creativeUpdate(CreativeDTO dto) {
		conn = getConnection();
		sql = " insert into membercreative(user_email, user_ph1, apply_path, demand_ok) values(?,?,?,null) ";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setNString(1, dto.getUserEmail());
			pstmt.setNString(2, dto.getUserPh1());
			pstmt.setNString(3, dto.getApplyPath());

			int i = pstmt.executeUpdate();
			System.out.println(i + "행이 수정되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public Integer demandCk(String userEmail) {// 수요조사여부체크
		Integer result = 0;
		conn = getConnection();
		sql = "select demand_ok from membercreative  where user_email =?  and demand_ok is not null";
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, userEmail);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String dbck = rs.getString(1);

				if (dbck == null) {
					result = 0; // null값이 없으면
				} else {
					result = 1; // null값이 있으면
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return result;
	}

	public void demandInsert(String userEmail, String demandOk) {
		conn = getConnection();
		sql = " update membercreative set demand_ok = ? where user_email = ? ";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setNString(1, demandOk);
			pstmt.setNString(2, userEmail);

			int i = pstmt.executeUpdate();
			System.out.println(i + "수요조사설문이 체크되었습니다..");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public void CreatorWriteSave(CreativeDTO dto) {
		// TODO Auto-generated method stub
		CreativeDTO resDto = new CreativeDTO();
		conn = getConnection();
		sql = 	" 	UPDATE MEMBERCREATIVE 		"
				+ "	   SET CREATOR_NNAME = ? ,	"
				+ "		   CREATOR_INTRO = ? ,	"
				+ "		   CREATOR_PH1 = ? ,	"
				+ "		   CREATOR_PHOTO = ? 	"
				+ "	 WHERE USER_EMAIL = ? "	;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCreatorNname());
			pstmt.setString(2, dto.getCreatorIntro());
			pstmt.setString(3, dto.getCreatorPh1());
			pstmt.setString(4, dto.getCreatorPhoto());
			pstmt.setString(5, dto.getUserEmail());
			
			int i = pstmt.executeUpdate();
			
			System.out.println(i+ "개 크리에이터 정보가 업데이트 되었습니다.( 테이블 : MEMBERCREATIVE )");
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		
	}

	public CreativeDTO CreatorInfoSelect(String userEmail) {
		// TODO Auto-generated method stub
		CreativeDTO resDto = new CreativeDTO();
		conn = getConnection();
		sql =	"	SELECT " + COLUMNS	
				+ "	  FROM MEMBERCREATIVE	"
				+ "	 WHERE USER_EMAIL = ?	";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				resDto.setCreatorIntro(rs.getString("CREATOR_INTRO"));
				resDto.setCreatorNname(rs.getString("CREATOR_NNAME"));
				resDto.setCreatorPh1(rs.getString("CREATOR_PH1"));
				resDto.setCreatorPhoto(rs.getString("CREATOR_PHOTO"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return resDto;
	}

	public Integer OpenCheckResUpdate(String userEmail, String classNum) {
		// TODO Auto-generated method stub
		Integer i = null;
		conn = getConnection();
		sql =	"	UPDATE CLASSES	"
				+ "	   SET TOS = 'Y'	"
				+ "	 WHERE USER_EMAIL = ? "
				+ "	   AND CLASSES_NUM = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			pstmt.setString(2, classNum);
			
			i = pstmt.executeUpdate();
			if(i>0) {
				System.out.println(i+"건 오픈전 확인사항 업데이트 완료");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return i;
	}

	public int fileUpdate(CreativeDTO dto) {
		// TODO Auto-generated method stub
		int i = 0;
		conn = getConnection();
		sql =	"	UPDATE MEMBERCREATIVE		"
				+ "	   SET CREATOR_PHOTO = ? 	"
				+ "	 WHERE USER_EMAIL = ?		"
				;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getCreatorPhoto());
			pstmt.setString(2, dto.getUserEmail());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return i;
	}

}