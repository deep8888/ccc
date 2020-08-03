package model.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DTO.OptionsDTO;
import model.DTO.QuestionDTO;
import model.DTO.QuestionOptionsDTO;

public class QuestionDAO extends DataBaseInfo {

	public int questionInsesrt(QuestionDTO qdto) {
		int i = 0;
		conn = getConnection();

		try {
			sql = " select nvl(max(question_num),0) + 1 from question where user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, qdto.getUserId());
			rs = pstmt.executeQuery();
			rs.next();
			i = rs.getInt(1);
			rs.close();
			pstmt.close();
			sql = " insert into question (question_num,question_title,user_id) values(?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			pstmt.setNString(2, qdto.getQuestionTitle());
			pstmt.setNString(3, qdto.getUserId());
			int j = pstmt.executeUpdate();
			System.out.println(j + "개가 입력되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			close();
		}

		return i;
	}

	public void optionInsert(OptionsDTO odto) {
		conn = getConnection();
		sql = " insert into options (user_id, question_num, options_num, options_name) values(?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setNString(1, odto.getUserId());
			pstmt.setInt(2, odto.getQuestionNum());
			pstmt.setInt(3, odto.getOptionsNum());
			pstmt.setNString(4,  odto.getOptionsName());
			int i = pstmt.executeUpdate();
			System.out.println(i+"행이 입력되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}

	public List<QuestionOptionsDTO> surveySelect(String userId) {
		List<QuestionOptionsDTO> list = 
				new ArrayList<QuestionOptionsDTO>() ;
		conn = getConnection();
		try {
			sql = " select count(*) from question "
					+ " where user_id = ? order by question_num";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			int qnum = 0;
			if(rs.next()) qnum = rs.getInt(1);
			rs.close();
			pstmt.close();
			sql ="select q.QUESTION_NUM QUESTION_NUM, "
				+ "QUESTION_TITLE,OPTIONS_NUM, "
				+ "OPTIONS_NAME " 
			   + " from question q , options o" 
			   + " where q.question_num = o.question_num(+) " 
			   + "and q.user_id = ? and q.QUESTION_NUM = ? order by q.question_num";
			pstmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, userId);
			for(int i = 1 ; i <= qnum ; i++) {
				pstmt.setInt(2, i);
				rs = pstmt.executeQuery();
				QuestionDTO qdto = new QuestionDTO();
				List<OptionsDTO> options = new ArrayList<OptionsDTO>();
				QuestionOptionsDTO qoDTO = new QuestionOptionsDTO();
				if(rs.next()) {
					qdto.setQuestionNum(
							rs.getInt("QUESTION_NUM"));
					qdto.setQuestionTitle(
							rs.getString("QUESTION_TITLE"));
				}
				rs.beforeFirst();
				while(rs.next()) {
					OptionsDTO odto = new OptionsDTO();
					odto.setOptionsName(rs.getString("OPTIONS_NAME"));
					odto.setOptionsNum(rs.getInt("OPTIONS_NUM"));
					options.add(odto);
				}
				qoDTO.setQuestion(qdto);
				qoDTO.setOptions(options);
				list.add(qoDTO);
			}
		}catch(Exception e) {}
		finally {close();}	
		return list; 
	}

}
