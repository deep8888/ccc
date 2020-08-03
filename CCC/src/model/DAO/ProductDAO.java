package model.DAO;

import java.util.ArrayList;
import java.util.List;

import model.DTO.ProductDTO;

public class ProductDAO extends DataBaseInfo{
	final String COLUMNS = "PRODUCT_NUM, CLASSES_NUM, PRODUCT_NAME, PRODUCT_CONTENT, PRODUCT_PRICE, user_email";
	
	
	
	public Integer productDel(String classesNum, String productNum) {
		String condition="";
		if(productNum!=null) {
			condition=" and PRODUCT_NUM='"+productNum+"'";
		}
		Integer i=0;
		conn=getConnection();
		sql="delete from product where CLASSES_NUM=?" +condition;
		try {
			System.out.println(sql);
			System.out.println(classesNum);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, classesNum);
			i=pstmt.executeUpdate();
			System.out.println(i+"개가 삭제 되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return i;
		
	}

	public List<ProductDTO> productSelectAll(String classesNum) {
		// TODO Auto-generated method stub
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		conn=getConnection();
		sql = "select "+ COLUMNS +" from product "
				+ " where CLASSES_NUM=? order by product_num desc";
		System.out.println(sql);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, classesNum);
			rs = pstmt.executeQuery();
			int i = 0;
			while(rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setClassesNum(rs.getString("Classes_Num"));
				dto.setProductNum(rs.getString("Product_Num"));
				dto.setProductName(rs.getString("Product_Name"));
				dto.setProductContent(rs.getString("Product_Content"));
				dto.setProductPrice(rs.getLong("Product_Price"));
				list.add(dto);
				i++;
			}
			System.out.println(i + "개가 출력되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}
	
	
	public void productInsert(ProductDTO dto) {
		conn=getConnection();
		sql = "insert into product ("+ COLUMNS + ")"
				+ " values(?||'_'||num_seq.nextval,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			/* pstmt.setString(1, dto.getProductNum()); */
			pstmt.setString(1, dto.getClassesNum());
			pstmt.setString(2, dto.getClassesNum());
			pstmt.setString(3, dto.getProductName());
			pstmt.setString(4, dto.getProductContent());
			pstmt.setLong(5, dto.getProductPrice());
			pstmt.setString(6, dto.getUserEmail());
			int i = pstmt.executeUpdate();
			System.out.println(i + "개가 저장되었습니다.");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close();
		}
	}

}
