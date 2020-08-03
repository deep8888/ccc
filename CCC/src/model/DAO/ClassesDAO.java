package model.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DTO.ClassesDTO;
import model.DTO.ClassesListDTO;
import model.DTO.ClassesListPackageDTO;
import model.DTO.PackageDTO;
import model.DTO.ProductDTO;
import model.DTO.PurchaseDTO;

public class ClassesDAO extends DataBaseInfo{
	final String COLUMNS="CLASSES_NUM, CLASSES_SUBJECT, CLASSES_CONTENT, "
			+ "CLASSES_PHOTO, CLASSES_PRICE, REG_DATE, "
			+ "USER_EMAIL, BUY_COUNT, SUBMIT_OK, CLASSES_CATEGORY, CLASSES_SUB_MENT, CLASSES_STEP";
	final String PROCOLUMNS="PRODUCT_NUM, CLASSES_NUM, PRODUCT_NAME, "
			+ "PRODUCT_CONTENT, PRODUCT_PRICE";
	
	final String LISTCOLUMNS="CLASSES_LIST_NUM, CLASSES_NUM, "
			+ "CLASSES_LIST_SUBJECT, CLASSES_LIST_CONTENT";
	
	final String PURCHASECOLUMNS="PURCHASE_NUM, CLASSES_NUM, "
			+ "USER_EMAIL, PURCHASE_DATE, "
			+ "EXPIRE_DATE, PURCHASE_PRICE, refund, refund_ok";
	
	public void ClassStepUpdate(String userEmail, String classNum, int i) {
		// TODO Auto-generated method stub
		int res = 0;
		conn = getConnection();
		sql =	"	UPDATE CLASSES	"
				+ "	   SET CLASSES_STEP = ? "
				+ "  WHERE USER_EMAIL = ?	"
				+ "	   AND CLASSES_NUM = ?	";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, i);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, classNum);
			
			res = pstmt.executeUpdate();
			
			System.out.println("Class "+ i+"단계 저장 완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
	}
	
	public void submitOk(String purchaseNum) {
		conn=getConnection();
		sql="update purchase set refund_ok='Y' where PURCHASE_NUM=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			int i=pstmt.executeUpdate();
			System.out.println(i+"개가 취소승인 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	public List<PurchaseDTO> purchaseSelectAll2() {
		List<PurchaseDTO> list=new ArrayList<PurchaseDTO>();
		conn=getConnection();
		sql="select "+PURCHASECOLUMNS+" from purchase where refund_ok !='Y'";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				PurchaseDTO dto=new PurchaseDTO();
				dto.setPurchaseNum(rs.getString("PURCHASE_NUM"));
				dto.setPurchaseDate(rs.getTimestamp("PURCHASE_DATE"));
				dto.setPurchasePrice(Long.parseLong(rs.getString("PURCHASE_PRICE")));
				dto.setUserEmail(rs.getString("USER_EMAIL"));
				dto.setClassesNum(rs.getString("CLASSES_NUM"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
	}
	
	public List<PurchaseDTO> purchaseSelectAll() {
		List<PurchaseDTO> list=new ArrayList<PurchaseDTO>();
		conn=getConnection();
		sql="select "+PURCHASECOLUMNS+" from purchase where refund='Y' and refund_ok !='Y'";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				PurchaseDTO dto=new PurchaseDTO();
				dto.setPurchaseNum(rs.getString("PURCHASE_NUM"));
				dto.setPurchaseDate(rs.getTimestamp("PURCHASE_DATE"));
				dto.setPurchasePrice(Long.parseLong(rs.getString("PURCHASE_PRICE")));
				dto.setUserEmail(rs.getString("USER_EMAIL"));
				dto.setClassesNum(rs.getString("CLASSES_NUM"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
	}
	
	
	public void purchaseRefund(String purchaseNum) {
		conn=getConnection();
		sql="update purchase set refund='Y' where PURCHASE_NUM=? ";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, purchaseNum);
			int i=pstmt.executeUpdate();
			System.out.println(i+"개가 환불접수되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	
	public int fileUpdate(ClassesDTO dto) {
		// TODO Auto-generated method stub
		int i = 0;
		conn = getConnection();
		sql =	"	UPDATE CLASSES	"
				+ "	   SET CLASSES_PHOTO = ?	"
				+ "	 WHERE USER_EMAIL = ?			"
				+ "    AND CLASSES_NUM = ? 		";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getClassesPhoto());
			pstmt.setString(2, dto.getUserEmail());
			pstmt.setString(3, dto.getClassesNum());
			
			i = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		
		return i;
	}
	
	public void classesAdminSubmit(String classesNum) {
		conn=getConnection();
		sql="update classes set SUBMIT_OK='Y' where classes_num=?" ;
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, classesNum);
			int i=pstmt.executeUpdate();
			System.out.println(i+"개의 클래스가 승인 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	
	public Integer classesDel(String classesNum) {
		Integer i=0;
		conn=getConnection();
		sql="delete from classes where CLASSES_NUM=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, classesNum);
			i=pstmt.executeUpdate();
			System.out.println(i+"개의 클래스가 삭제 되었습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return i;
		
	}
	
	public Integer classesListDel(String classesNum) {
		Integer i=0;
		conn=getConnection();
		sql="delete from classes_list where CLASSES_NUM=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, classesNum);
			i=pstmt.executeUpdate();
			System.out.println(i+"개의 클래스 리스트가 삭제 되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return i;
	}
	
	
	public List<ClassesDTO> ClassesSelectUser(String userEmail, String classesNum) {
		List<ClassesDTO> list=new ArrayList<ClassesDTO>();
		String condition="";
		if(classesNum!=null) {
			condition=" and classes_num='"+classesNum+"'";
		}
		conn=getConnection();
		sql="select * from classes where USER_EMAIL=? "+condition+" order by classes_num";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				ClassesDTO dto=new ClassesDTO();
				dto.setClassesNum(rs.getString("classes_num"));
				dto.setClassesSubject(rs.getString("classes_subject"));
				dto.setClassesPhoto(rs.getString("classes_photo"));
				dto.setClassesContent(rs.getString("classes_content"));
				dto.setClassesPrice(rs.getLong("classes_price"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public void buyCountUp(ClassesDTO dto) {
		conn=getConnection();
		sql="update classes set buy_count=buy_count+1 "
				+ " where classes_num=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getClassesNum());
			int i=pstmt.executeUpdate();
			System.out.println(i+"개가 수정되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
	}
	
	
	
	public void purchaseInsert(PurchaseDTO dto) {
		conn=getConnection();
		sql="insert into purchase ("+PURCHASECOLUMNS+") values(NUM_SEQ.nextval, ?,?,sysdate,SYSDATE + (INTERVAL '60' DAY) ,?,'N','N') ";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getClassesNum());
			pstmt.setString(2, dto.getUserEmail());
			pstmt.setLong(3, dto.getPurchasePrice());
			System.out.println(sql);
			int i=pstmt.executeUpdate();
			System.out.println(i+"행이 저장되었습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
			
		
	}
	
	public List<ClassesListDTO> ClassesListSelectAll(String classesListNum) {
		List<ClassesListDTO> list=new ArrayList<ClassesListDTO>();
		conn=getConnection();
		sql="select "+LISTCOLUMNS+" from classes_list where classes_list_num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, classesListNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				ClassesListDTO dto=new ClassesListDTO();
				dto.setClassesListContent(rs.getString("CLASSES_LIST_CONTENT"));
				dto.setClassesListNum(rs.getString("CLASSES_LIST_NUM"));
				dto.setClassesListSubject(rs.getString("CLASSES_LIST_SUBJECT"));
				list.add(dto);
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}
	
	public List<PurchaseDTO> purchaseSelect(String userEmail,String date) {
		String condition="";
		if(date==null) {
			condition=" and p.EXPIRE_DATE > sysdate";
		}
		List<PurchaseDTO> list=new ArrayList<PurchaseDTO>();
		conn=getConnection();
		sql="select p.PURCHASE_NUM pnum, c.CLASSES_NUM cnum,  c.classes_price cprice, p.PURCHASE_DATE pdate,"
				+ " p.EXPIRE_DATE edate, p.PURCHASE_PRICE pprice, c.classes_subject csubject, p.refund refund, p.refund_ok rok"
				+ " from classes c join purchase p "
				+ " on c.classes_num=p.classes_num "
				+ "where p.user_email=? "+condition+" order by pnum";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				PurchaseDTO dto=new PurchaseDTO();
				dto.setClassesNum(rs.getString("cnum"));
				dto.setClassesSubject(rs.getString("csubject"));
				dto.setPurchaseNum(rs.getString("pnum"));
				dto.setPurchaseDate(rs.getTimestamp("pdate"));
				dto.setPurchasePrice(rs.getLong("pprice"));
				dto.setUserEmail(userEmail);
				dto.setExpireDate(rs.getTimestamp("edate"));
				dto.setClassesPrice(rs.getLong("cprice"));
				dto.setRefund(rs.getString("refund"));
				dto.setRefundOk(rs.getString("rok"));
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
		
		
	}

	
	
	public ClassesListPackageDTO ClassesListSelect(String classesNum) {
		ClassesDTO dto=new ClassesDTO();
		List<ClassesListDTO> classesList=new ArrayList<ClassesListDTO>();
		ClassesListPackageDTO listPacdto=new ClassesListPackageDTO();
		conn=getConnection();
		
		sql="select c.classes_num cnum, c.classes_subject csubject, c.classes_content ccontent, "
				+ " c.classes_photo cphoto, c.classes_price cprice, c.reg_date cregdate, "
				+ " c.user_email cemail, c.buy_count ccount, c.submit_ok cok, "
				+ " l.CLASSES_LIST_NUM llistnum, l.CLASSES_NUM lclassesnum, "
				+ "	l.CLASSES_LIST_SUBJECT lsubject, l.CLASSES_LIST_CONTENT lcontent "
				+ " from classes c left outer join classes_list l "
				+ " on c.classes_num=l.classes_num "
				+ " where c.classes_num=? ";
		
		try {
			pstmt=conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			pstmt.setString(1, classesNum);
			rs=pstmt.executeQuery();
			System.out.println(sql);
			
			if(rs.next()) {
				dto.setClassesNum(rs.getString("cnum"));
				dto.setClassesSubject(rs.getString("csubject"));
				dto.setClassesContent(rs.getString("ccontent"));
				dto.setClassesPhoto(rs.getString("cphoto"));
				dto.setClassesPrice(rs.getLong("cprice"));
				dto.setRegDate(rs.getTimestamp("cregdate"));
				dto.setUserEmail(rs.getString("cemail"));
				dto.setBuyCount(rs.getLong("ccount"));
				dto.setSubmitOk(rs.getString("cok"));
			}
			rs.beforeFirst();
			while (rs.next()) {
				ClassesListDTO cldto=new ClassesListDTO();
				cldto.setClassesListNum(rs.getString("llistnum"));
				cldto.setClassesListSubject(rs.getString("lsubject"));
				cldto.setClassesListContent(rs.getString("lcontent"));
				classesList.add(cldto);
				listPacdto.setClassesDTO(dto);
				listPacdto.setClassesList(classesList);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return listPacdto;
		
		
	}
	
	public PackageDTO packageSelect(String classesNum) {
		ClassesDTO dto=new ClassesDTO();
		List<ProductDTO> proList=new ArrayList<ProductDTO>();
		PackageDTO pacdto=new PackageDTO();
		conn=getConnection();

		sql="select c.classes_num cnum, c.classes_subject csubject, c.classes_content ccontent, "
				+ " c.classes_photo cphoto, c.classes_price cprice, c.reg_date cregdate, "
				+ " c.user_email cemail, c.buy_count ccount, c.submit_ok cok, "
				+ " p.product_num pnum, p.product_name pname, p.product_content pcontent, p.product_price pprice "
				+ " from classes c left outer join product p "
				+ " on c.classes_num=p.classes_num "
				+ " where c.classes_num=?";
		try {
			pstmt=conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			System.out.println(sql);
			pstmt.setString(1, classesNum);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setClassesNum(rs.getString("cnum"));
				dto.setClassesSubject(rs.getString("csubject"));
				dto.setClassesContent(rs.getString("ccontent"));
				dto.setClassesPhoto(rs.getString("cphoto"));
				dto.setClassesPrice(rs.getLong("cprice"));
				dto.setRegDate(rs.getTimestamp("cregdate"));
				dto.setUserEmail(rs.getString("cemail"));
				dto.setBuyCount(rs.getLong("ccount"));
				dto.setSubmitOk(rs.getString("cok"));
			}
			rs.beforeFirst();
			while (rs.next()) {
				ProductDTO prodto=new ProductDTO();
				prodto.setClassesNum(rs.getString("cnum"));
				prodto.setProductNum(rs.getString("pnum"));
				prodto.setProductPrice(rs.getLong("pprice"));
				prodto.setProductContent(rs.getString("pcontent"));
				prodto.setProductName(rs.getString("pname"));
				proList.add(prodto);
				pacdto.setClassesDTO(dto);
				pacdto.setProduct(proList);
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return pacdto;
	}
	
	
	public List<ClassesDTO> ClassesSelect(String classesNum) {
		List<ClassesDTO> list=new ArrayList<ClassesDTO>();
		String condition="";
		if(classesNum!=null) {
			condition=" and classes_num='"+classesNum+"'";
		}
		
		conn=getConnection();
		sql="select "+COLUMNS+" from classes where 1=1 and submit_ok!='N' "+condition+" "
				+ "order by BUY_COUNT desc" ;
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ClassesDTO dto=new ClassesDTO();
				dto.setClassesNum(rs.getString("classes_num"));
				dto.setClassesSubject(rs.getString("classes_subject"));
				dto.setClassesPhoto(rs.getString("classes_photo"));
				dto.setClassesContent(rs.getString("classes_content"));
				dto.setClassesPrice(rs.getLong("classes_price"));
				list.add(dto);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
	}
	
	public List<ClassesDTO> ClassesSelectNotOpen() {
		List<ClassesDTO> list=new ArrayList<ClassesDTO>();
		conn=getConnection();
		sql="select "+COLUMNS+" from classes where submit_ok ='N'";
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ClassesDTO dto=new ClassesDTO();
				dto.setClassesNum(rs.getString("classes_num"));
				dto.setClassesSubject(rs.getString("classes_subject"));
				dto.setClassesPhoto(rs.getString("classes_photo"));
				dto.setClassesContent(rs.getString("classes_content"));
				dto.setRegDate(rs.getTimestamp("REG_DATE"));
				dto.setSubmitOk(rs.getString("submit_ok"));
				list.add(dto);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
		
	}
	
	// 07.27 크리에이터센터 관련 DAO수정부분 추가 -- start--
	public String ClassNewCreate(String userEmail) {
		// TODO Auto-generated method stub
		String claNum = "";
		conn = getConnection();
		sql = 	"	INSERT INTO CLASSES ( "
				+ COLUMNS
				+ "	) VALUES ( "
				+ " 'CL_'||CLASSNUM_SEQ.NEXTVAL, NULL, NULL, NULL, 0, SYSDATE, ?, 0, 'N', NULL, NULL, 0 )";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			int i = pstmt.executeUpdate();
			System.out.println(i + "개 클래스가 생성되었습니다.");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		
		conn = getConnection();
		sql = 	"	SELECT MAX(CLASSES_NUM) AS CLASSES_NUM"
				+ "	  FROM CLASSES"
				+ "  WHERE USER_EMAIL = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userEmail);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				claNum = rs.getString("CLASSES_NUM");
			}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return claNum;
	}


	public String ClassWritePro(ClassesDTO dto) {
		// TODO Auto-generated method stub
		Integer i = null;
		String connection = "";
		String classesNum = "";
		if(dto.getClassesNum() == null) {		
			connection =	" 'CL_'|| (" 
						+	"    SELECT  MAX(TO_NUMBER(SUBSTR(CLASSES_NUM, 4))) AS MAX_NUM " 
						+	"      FROM CLASSES	" 
						+	"     WHERE USER_EMAIL = ?)	";
		}else {
			connection = " ?  AND	USER_EMAIL = ?  ";
		}
		conn = getConnection();
		sql = 	" 	UPDATE 	CLASSES "
				+ "	   SET 	CLASSES_SUBJECT = ? ,	"
				+ "			CLASSES_CONTENT = ? ,	"
				+ "			CLASSES_CATEGORY = ?, 	"
				+ "			CLASSES_SUB_MENT = ?,	"
				+ "			CLASSES_PRICE = ?		"
				+ "	 WHERE	CLASSES_NUM = "
				+ connection
				;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getClassesSubject());
			pstmt.setString(2, dto.getClassesContent());
			pstmt.setString(3, dto.getClassCategory());
			pstmt.setString(4, dto.getClassSubMent());
			pstmt.setLong(5, dto.getClassesPrice());
			if(dto.getClassesNum() != null) {
				pstmt.setString(6, dto.getClassesNum());
				pstmt.setString(7, dto.getUserEmail());
			}else {
				pstmt.setString(6, dto.getUserEmail());
			}
			i = pstmt.executeUpdate();
			System.out.println(i + "개가 수정되었습니다.");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		// 업데이트 대상 조회
		conn = getConnection();
		sql = " 	SELECT CLASSES_NUM "
				+ "	  FROM CLASSES"
				+ "	 WHERE CLASSES_NUM = " + connection ;
		
		try {
			pstmt = conn.prepareStatement(sql);
			if(dto.getClassesNum() != null) {
				pstmt.setString(1, dto.getClassesNum());
				pstmt.setString(2, dto.getUserEmail());
			}else {
				pstmt.setString(1, dto.getUserEmail());
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				classesNum = rs.getString("CLASSES_NUM");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("return값 전달 : "+ classesNum);
		return classesNum;
	}



	public ClassesDTO classSingleSelect(String userEmail, String classNum) {
		// TODO Auto-generated method stub
		ClassesDTO dto = new ClassesDTO();
		conn = getConnection();
		sql = 	" 	SELECT " + COLUMNS
				+ "	  FROM CLASSES "
				+ "  WHERE CLASSES_NUM = ? "
				+ "    AND USER_EMAIL = ?  ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classNum);
			pstmt.setString(2, userEmail);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dto.setClassesNum(rs.getString("CLASSES_NUM"));
				dto.setClassesSubject(rs.getString("CLASSES_SUBJECT"));
				dto.setClassesContent(rs.getString("CLASSES_CONTENT"));
				dto.setClassCategory(rs.getString("CLASSES_CATEGORY"));
				dto.setClassesPhoto(rs.getString("CLASSES_PHOTO"));
				dto.setClassSubMent(rs.getString("CLASSES_SUB_MENT"));
				dto.setClassesStep(rs.getString("CLASSES_STEP"));
				dto.setClassesPrice(rs.getLong("CLASSES_PRICE"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
	}
	// 07.27 크리에이터센터 관련 DAO수정부분 추가 -- end --

}
