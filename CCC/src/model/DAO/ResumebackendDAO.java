package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.ResumebackendDTO;

public class ResumebackendDAO extends DataBaseInfo{
	final String COLUMNS = 
			"RESUME_NUM, RESUME_NAME, RESUME_EMAIL,"
			+ "RESUME_PHCON, GITHUB_URL, PORT_URL, "
			+ "RESUME_CONTENT, IP_ADDR, ORIGINAL_FILE_NAME,"
					  + " STORE_FILE_NAME, FILE_SIZE, DEPARTMENT_NAME,YES_NO";
	public String checkYesNo(String resumeName, String resumePhcon, String departmentName) {
		conn = getConnection();
		sql = "select yes_no from resumeboard where resume_name = ? and resume_phcon = ? and department_Name = ?";
		String YesNo = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, resumeName);
			pstmt.setString(2, resumePhcon);
			pstmt.setString(3, departmentName);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				YesNo = rs.getString(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return YesNo;
	}
	
	public void ResumeUpdate(ResumebackendDTO dto) {
		conn = getConnection();
		sql = "update resumeboard "
				+ " set YES_NO =?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getYesNo());
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이 수정되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		}
	
	public List<ResumebackendDTO> resumeSelectAll(){
		List<ResumebackendDTO> list = new ArrayList<ResumebackendDTO>();
		conn=getConnection();
		sql = "select "+ COLUMNS +" from resumeboard where RESUME_NUM=? order by resume_num desc";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				ResumebackendDTO dto = new ResumebackendDTO();
				dto.setDepartmentName(rs.getString("Department_Name"));
				dto.setFileSize(rs.getLong("File_Size"));
				dto.setGithubUrl(rs.getString("Github_Url"));
				dto.setIpAddr(rs.getString("Ip_Addr"));
				dto.setOriginalFileName(rs.getString("Original_File_Name"));
				dto.setPortUrl(rs.getString("Port_Url"));
				dto.setResumeContent(rs.getString("Resume_Content"));
				dto.setResumeEmail(rs.getString("Resume_Email"));
				dto.setResumeName(rs.getString("Resume_Name"));
				dto.setResumeNum(rs.getLong("Resume_Num"));
				dto.setResumePhcon(rs.getString("Resume_Phcon"));
				dto.setStoreFileName(rs.getString("Store_File_Name"));
				dto.setYesNo(rs.getString("Yes_No"));
				list.add(dto);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
	return list;
	}
	
	
	public List<ResumebackendDTO> resumeSelect(String resumeNum){
	List<ResumebackendDTO> list = new ArrayList<ResumebackendDTO>();
	String condition="";
	if (resumeNum!=null) {
		condition=" and resume_Num='"+resumeNum+"'";
	}
	conn=getConnection();
	
	sql = "select "+ COLUMNS +" from resumeboard where 1=1 "+condition+""
			+ " order by resume_num desc ";
	System.out.println(sql);
	try {
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			ResumebackendDTO dto = new ResumebackendDTO();
			dto.setDepartmentName(rs.getString("Department_Name"));
			dto.setFileSize(rs.getLong("File_Size"));
			dto.setGithubUrl(rs.getString("Github_Url"));
			dto.setIpAddr(rs.getString("Ip_Addr"));
			dto.setOriginalFileName(rs.getString("Original_File_Name"));
			dto.setPortUrl(rs.getString("Port_Url"));
			dto.setResumeContent(rs.getString("Resume_Content"));
			dto.setResumeEmail(rs.getString("Resume_Email"));
			dto.setResumeName(rs.getString("Resume_Name"));
			dto.setResumeNum(rs.getLong("Resume_Num"));
			dto.setResumePhcon(rs.getString("Resume_Phcon"));
			dto.setStoreFileName(rs.getString("Store_File_Name"));
			dto.setYesNo(rs.getString("Yes_No"));
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
	public void resInsert(ResumebackendDTO dto) {
		sql = "insert into RESUMEBOARD ("+ COLUMNS +") "
				+ "values(NUM_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
	try {
		conn= getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, dto.getResumeName());
		pstmt.setString(2, dto.getResumeEmail());
		pstmt.setString(3, dto.getResumePhcon());
		pstmt.setString(4, dto.getGithubUrl());
		pstmt.setString(5, dto.getPortUrl());
		pstmt.setString (6, dto.getResumeContent());
		pstmt.setString (7, dto.getIpAddr());
		pstmt.setString(8, dto.getOriginalFileName());
		pstmt.setString(9, dto.getStoreFileName());
		pstmt.setLong(10, dto.getFileSize());
		pstmt.setString(11, dto.getDepartmentName());
		pstmt.setString(12, dto.getYesNo());
		int i =pstmt.executeUpdate();
		System.out.println(i + "행이 수정되었습니다.");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	} finally {
		close();
	}
	}

	public void resumeYesNoUpdate(ResumebackendDTO dto) {  //합격여부 
		conn = getConnection();
		sql = " update RESUMEBOARD set YES_NO = ? where resume_num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setNString(1, dto.getYesNo());
			pstmt.setLong(2, dto.getResumeNum());
			
						
			int i = pstmt.executeUpdate();
			System.out.println(i + "행이 수정되었습니다.");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
	}
}
